package com.mpb.basic.auth.backend.web.controller;

import com.mpb.basic.auth.backend.entity.auth.Role;
import com.mpb.basic.auth.backend.entity.auth.User;
import com.mpb.basic.auth.backend.entity.auth.UserStatus;
import com.mpb.basic.auth.backend.entity.type.ERole;
import com.mpb.basic.auth.backend.repository.RoleRepository;
import com.mpb.basic.auth.backend.repository.UserRepository;
import com.mpb.basic.auth.backend.service.UserService;
import com.mpb.basic.auth.backend.web.api.Auth;
import com.mpb.basic.auth.backend.web.exception.EntityNotFoundException;
import com.mpb.basic.auth.backend.web.req.LoginRequest;
import com.mpb.basic.auth.backend.web.req.RegisterRequest;
import com.mpb.basic.auth.backend.web.res.ApiResponse;
import com.mpb.basic.auth.backend.web.res.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class AuthController implements Auth {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public AuthController(UserService userService, RoleRepository roleRepository, UserRepository userRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ApiResponse> createRoles(List<ERole> roleList) {
        List<Role> roleList1 = roleList
                .stream()
                .map(eRole -> Role.builder().name(eRole).build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(ApiResponse
                .builder()
                .status(true)
                .timestamp(new Date())
                .body(roleRepository.saveAll(roleList1))
                .build());
    }

    @Override
    public ResponseEntity<ApiResponse> changeState(UserStatus uSerState, UUID uuid) {
        Optional<User> byId = userRepository.findById(uuid);
        if(byId.isPresent()){
            User user = byId.get();
            user.setUserStatus(uSerState);
            userRepository.save(user);
        }
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> registerUser(RegisterRequest registerRequest) throws EntityNotFoundException {
        User user = new User();
        user.setUserName(registerRequest.getEmail());
        user.setUserStatus(UserStatus.ACTIVATED);
        user.setLastName(registerRequest.getLastName());
        user.setFirstName(registerRequest.getFirstName());
        user.setPassword(registerRequest.getPassword());
        Set<Role> roleList = registerRequest
                .getRoleList()
                .stream()
                .map(eRole -> {
                    Optional<Role> byName = roleRepository.findByName(eRole);
                    if (byName.isPresent()) {
                        return byName.get();
                    } else {
                        throw new EntityNotFoundException(Role.class, "id", eRole.toString());
                    }
                })
                .collect(Collectors.toSet());
        user.setRoles(roleList);

        User addUser = userService.addUser(user);


        return ResponseEntity.ok(ApiResponse
                .builder()
                .status(true)
                .timestamp(new Date())
                .message("register success")
                .body("")
                .build());

    }

    @Override
    public ResponseEntity<ApiResponse> registerCustomer(RegisterRequest registerRequest) throws EntityNotFoundException {
        User user = new User();
        user.setUserName(registerRequest.getEmail());
        user.setLastName(registerRequest.getLastName());
        user.setFirstName(registerRequest.getFirstName());
        user.setUserStatus(UserStatus.ACTIVATED);
        user.setPassword(registerRequest.getPassword());
        registerRequest
                .getRoleList()
                .add(ERole.ROLE_CUSTOMER);
        Set<Role> roleList = registerRequest
                .getRoleList()
                .stream()
                .map(eRole -> {
                    Optional<Role> byName = roleRepository.findByName(eRole);
                    if (byName.isPresent()) {
                        return byName.get();
                    } else {
                        throw new EntityNotFoundException(Role.class, "id", eRole.toString());
                    }
                })
                .collect(Collectors.toSet());
        user.setRoles(roleList);

        User addUser = userService.addUser(user);


        return ResponseEntity.ok(ApiResponse
                .builder()
                .status(true)
                .timestamp(new Date())
                .message("register success")
                .body("")
                .build());
    }

    @Override
    public ResponseEntity<JwtResponse> login(LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @Override
    public ResponseEntity<ApiResponse> users() {
        return ResponseEntity.ok(ApiResponse
                .builder()
                .status(true)
                .timestamp(new Date())
                .message("Done")
                .body(userService.all())
                .build());
    }
}
