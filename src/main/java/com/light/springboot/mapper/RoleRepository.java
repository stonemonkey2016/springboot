package com.light.springboot.mapper;

import com.light.springboot.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @descrption:
 * @author: bubbles
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
