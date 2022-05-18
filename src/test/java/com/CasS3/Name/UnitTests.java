package com.CasS3.Name;

import com.CasS3.Name.controllers.UserLoginController;
import com.CasS3.Name.entities.UserLogin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UnitTests {
    @Autowired
    private UserLoginController userLoginController;

    @Test
    void shouldGetName(){
        //arrange
        UserLogin userLogin = new UserLogin();
        userLogin.setName("Cas");
        userLogin.setEmail("cas.esselink@gmail.com");
        userLoginController.addNewUserLogin(userLogin);
        //act
        String name = userLoginController.getName("cas.esselink@gmail.com");
        //assert
        assertThat(userLogin.getName()).isEqualTo(name);
    }
    @Test
    void shouldAddLoginUser(){
        //arrange
        UserLogin userLogin = new UserLogin();
        userLogin.setName("Cas");
        userLogin.setEmail("cas.esselink@gmail.com");
        //act
        UserLogin postUserLogin = userLoginController.addNewUserLogin(userLogin);
        //assert
        assertThat(userLogin.getName()).isEqualTo(postUserLogin.getName());
        assertThat(userLogin.getEmail()).isEqualTo(postUserLogin.getEmail());
    }
}
