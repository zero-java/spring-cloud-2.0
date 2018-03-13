package com.zero.scvzerng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author scvzerng
 * @date 2018-2018/3/13-20:49
 */
@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class ProviderApplication {
    @GetMapping
    public String hello(){
        return "hello world";
    }
    @PostMapping
    public Map<String,String> save(@RequestBody Map<String,String> params){
        params.put("status","200");
        return params;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
