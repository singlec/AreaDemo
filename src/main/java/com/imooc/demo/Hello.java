package com.imooc.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {
    @GetMapping (value = "/hello/{id}")
    public String sayHello(@PathVariable("id") Integer id){
        return "Hello SpringBoot"+ id;
    }
}
