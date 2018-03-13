package com.zero.svzerng.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author scvzerng
 * @date 2018-2018/3/13-21:44
 */
@FeignClient(value = "service-provider",path = "/hello")
public interface HelloClients {
    @GetMapping
    String hello();
    @PostMapping
    Map<String,String> save(@RequestBody Map<String,String> params);
}
