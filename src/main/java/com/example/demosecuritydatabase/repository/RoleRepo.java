package com.example.demosecuritydatabase.repository;

import com.example.demosecuritydatabase.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,String> {
}
