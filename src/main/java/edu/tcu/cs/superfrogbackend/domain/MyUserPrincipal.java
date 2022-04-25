/*
package edu.tcu.cs.superfrogbackend.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserPrincipal implements UserDetails {
    private User user;
    private List<GrantedAuthority> authorities;

    public MyUserPrincipal(User user) {
        this.user = user;

        // Convert a user's roles from space-delimited string to a list of SimpleGrantedAuthority objects
        // E.g., john's roles are stored in a string like "admin user moderator", we need to convert it to a list of GrantedAuthority
        this.authorities = Arrays.stream(StringUtils.tokenizeToStringArray(user.getRole(), " "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public MyUserPrincipal(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = (List<GrantedAuthority>) authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }





    @Override
    public Integer getId() {
        return user.getId();
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public String getLname() {
        return user.getLname();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getRole() {
        return user.getRole();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isInactive() {
        return user.isInactive();
    }

    public User getUser() {
        return user;
    }
}
*/