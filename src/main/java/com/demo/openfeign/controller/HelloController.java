package com.demo.openfeign.controller;

import com.demo.openfeign.exception.ClientException;
import com.demo.openfeign.exception.ServerException;
import com.demo.openfeign.feign.DemoClient;
import com.demo.openfeign.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DemoClient demoClient;

    @GetMapping("/")
    public ResponseEntity<List<Post>> invokeHelloRemote() {
        try {
            ResponseEntity<Void> result = demoClient.getTest();
            System.out.println(result.getStatusCode());
        }catch (Exception exception){
            if(exception.getCause() instanceof ClientException){
                System.out.println("Error Code : =" + ((ClientException) exception.getCause()).getStatus());
            }
        }

        List<Post> posts = demoClient.getPosts("ASDF!@#$");
        return new ResponseEntity(posts, HttpStatus.OK);
    }
}
