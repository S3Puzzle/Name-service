package com.cas.name;

import com.cas.name.controllers.UserLoginController;
import com.cas.name.entities.Form;
import com.cas.name.entities.UserLogin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UnitTests {
    @Autowired
    private UserLoginController userLoginController;

    @Test
    void shouldGetName(){
        //arrange
        Form userLogin = new Form();
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
        Form userLogin = new Form();
        userLogin.setName("Cas");
        userLogin.setEmail("cas.esselink@gmail.com");
        //act
        UserLogin postUserLogin = userLoginController.addNewUserLogin(userLogin);
        //assert
        assertThat(userLogin.getName()).isEqualTo(postUserLogin.getName());
        assertThat(userLogin.getEmail()).isEqualTo(postUserLogin.getEmail());
    }
}
