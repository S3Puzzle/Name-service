package com.CasS3.Name.repository;


import org.springframework.data.repository.CrudRepository;
import com.CasS3.Name.entities.UserLogin;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserLoginRepository extends CrudRepository<UserLogin, Integer> {

}