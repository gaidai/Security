package com.sgaidai.springdatajpa.dao.repositories;


import com.sgaidai.security.entities.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Raichand
 */
public interface RoleRepository extends JpaRepository<Role,Integer>{
    
    @Query("SELECT max(r.roleId) FROM Role r")//Retrieving Maximun Id of UserRole Record
   int getMaxRoleId();
    
}
