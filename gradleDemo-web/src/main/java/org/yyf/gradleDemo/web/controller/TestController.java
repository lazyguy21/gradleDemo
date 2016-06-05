package org.yyf.gradleDemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyf.gradleDemmo.domain.ColorEnum;
import org.yyf.gradleDemmo.domain.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by lazyguy on 2016-5-20.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("test1")
    public String test(HttpServletRequest httpServletRequest) {

        return "success";
    }
    @RequestMapping("user")
    public User user(HttpServletRequest httpServletRequest) {
        User user = new User(111L,"yyf",new Date(),true);
        user.setColorEnum(ColorEnum.blue);
        return user;
    }
    @RequestMapping("au")
    public User user(User user,String name2){
        System.out.println(user);
        System.out.println(name2);
        return user;
    }
}
