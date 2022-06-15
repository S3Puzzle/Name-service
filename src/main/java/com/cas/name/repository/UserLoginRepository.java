package com.cas.name.repository;


import org.springframework.data.repository.CrudRepository;
import com.cas.name.entities.UserLogin;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserLoginRepository extends CrudRepository<UserLogin, Integer> {

}