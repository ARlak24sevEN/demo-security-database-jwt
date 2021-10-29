package com.example.demosecuritydatabase.service;

import com.example.demosecuritydatabase.entity.Role;
import com.example.demosecuritydatabase.entity.User;
import com.example.demosecuritydatabase.repository.RoleRepo;
import com.example.demosecuritydatabase.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    final private UserRepo userRepo;
    final private RoleRepo roleRepo;
    final private PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void initRoleAndUser() {
        //set data about admin
        //set role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepo.save(adminRole);

        //set init information about admin
        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);

        //set data about user

       // set role
        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepo.save(userRole);
//        //set init information about user
//        User user = new User();
//        user.setUserName("arlak");
//        user.setUserPassword(getEncodedPassword("arlak@pass"));
//        user.setUserFirstName("arlak");
//        user.setUserLastName("abdulloh");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userRepo.save(user);
    }
    public User registerNewUser(User user) {
        Role role = roleRepo.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepo.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

}
