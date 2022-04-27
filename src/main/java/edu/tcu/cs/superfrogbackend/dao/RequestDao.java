package edu.tcu.cs.superfrogbackend.dao;

import edu.tcu.cs.superfrogbackend.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDao extends JpaRepository<Request, String> {

}
