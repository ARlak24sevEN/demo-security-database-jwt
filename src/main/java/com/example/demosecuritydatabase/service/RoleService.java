package com.example.demosecuritydatabase.service;

import com.example.demosecuritydatabase.entity.Role;
import com.example.demosecuritydatabase.repository.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    final private RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role createNewRole(Role role) {
        return roleRepo.save(role);
    }
}
