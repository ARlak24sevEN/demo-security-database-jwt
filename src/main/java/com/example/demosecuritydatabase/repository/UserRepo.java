package com.example.demosecuritydatabase.repository;

import com.example.demosecuritydatabase.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,String> {
}
