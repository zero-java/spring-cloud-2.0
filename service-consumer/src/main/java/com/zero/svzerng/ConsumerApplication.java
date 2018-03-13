package com.zero.svzerng;

import com.zero.svzerng.clients.HelloClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scvzerng
 * @date 2018-2018/3/13-20:48
 */
@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/world")
public class ConsumerApplication {
    @Resource
    private HelloClients helloClients;

    @GetMapping
    public String world(){
        return helloClients.hello();
    }

    @PostMapping
    public Map<String,String> save(@RequestBody Map<String,String> params){
        params.put("from","consumer");
        return helloClients.save(params);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
