package com.zero.scvzerng;

import com.zero.scvzerng.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author scvzerng
 * @date 2018-2018/3/13-20:49
 */
@SpringBootApplication
@RestController
@RequestMapping("/test")
public class ProviderApplication {

    @PostMapping(value = "/form",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User testForm(@ModelAttribute User user){
        return user;
    }
    @GetMapping("/{var}")
    public String testPathVar(@PathVariable String var){
        return var;
    }
    @GetMapping
    public String hello(){
        return "hello world";
    }
    @PostMapping
    public Map<String,String> testJson(@RequestBody Map<String,String> params){
        params.put("status","200");
        return params;
    }

    @GetMapping("/testParam")
    public String testRequestParam(@RequestParam String param){
        return param;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
