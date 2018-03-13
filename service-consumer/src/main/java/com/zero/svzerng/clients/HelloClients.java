package com.zero.svzerng.clients;

import com.zero.svzerng.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author scvzerng
 * @date 2018-2018/3/13-21:44
 */
@FeignClient(value = "service-provider",path = "/test")
public interface HelloClients {
    @GetMapping
    String hello();
    @PostMapping
    Map<String,String> testJson(@RequestBody Map<String,String> params);
    @GetMapping("/{var}")
    String testPathVar(@PathVariable("var") String var);
    @PostMapping(value = "/form",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    User testForm(@ModelAttribute User user);

    @GetMapping("/testParam")
    String testRequestParam(@RequestParam("param") String param);
}
