package com.zero.svzerng;

import com.zero.svzerng.clients.HelloClients;
import com.zero.svzerng.entity.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scvzerng
 * @date 2018-2018/3/13-20:48
 */
@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/test")
public class ConsumerApplication {

    @Resource
    private HelloClients helloClients;
    @GetMapping("/{var}")
    public String testPathVar(@PathVariable String var){
        return helloClients.testPathVar(var);
    }
    @GetMapping
    public String hello(){
        return helloClients.hello();
    }
    @PostMapping(value = "/form",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User testForm(@ModelAttribute User user){
        return helloClients.testForm(user);
    }
    @PostMapping
    public Map<String,String> testJson(@RequestBody Map<String,String> params){
        params.put("from","consumer");
        return helloClients.testJson(params);
    }

    @GetMapping("/testParam")
    public String testRequestParam(@RequestParam String param){
        return helloClients.testRequestParam(param);
    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
