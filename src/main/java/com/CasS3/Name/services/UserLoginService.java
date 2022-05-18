package com.CasS3.Name.services;

import com.CasS3.Name.entities.UserLogin;
import com.CasS3.Name.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired // This means to get the bean called userRepository
    private UserLoginRepository userLoginRepository;

    public void addUserLogin(UserLogin n){
        userLoginRepository.save(n);
    }
    public String getNameByEmail(String email){
        Iterable<UserLogin> userLogins = userLoginRepository.findAll();
        for (UserLogin p:userLogins) {
            if(p.getEmail().equals(email)){
                return p.getName();
            }
        }
        return "";
    }
}
