package com.demo.openfeign.feign;

import com.demo.openfeign.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(value = "demo-client",
        url = "${feign.client.url}",
        configuration = ClientConfiguration.class,
        fallback = JSONPlaceHolderFallback.class)
public interface DemoClient {

    @GetMapping("/posts")
    List<Post> getPosts(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @GetMapping("/test")
    ResponseEntity<Void> getTest();
}
