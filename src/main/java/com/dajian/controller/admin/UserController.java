package com.dajian.controller.admin;

import com.dajian.entity.User;
import com.dajian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 86156
 * @date 2019/7/19
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    /*
    @auther dajian
    @date 2019/7/19
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
}
