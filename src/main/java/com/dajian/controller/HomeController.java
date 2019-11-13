package com.dajian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 86156
 * @date 2019/7/19
 */
@Controller
public class HomeController {

    /*
    系统首页
     */
    @GetMapping(value = {"/", "/index"})
    public  String index(){
        return "home/index";
    }

    /*
    商品列表页
     */
    @GetMapping(value = {"/goods"})
    public String user(){
        return "site/goods";
    }
}
