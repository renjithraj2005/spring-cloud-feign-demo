package com.demo.openfeign.feign;

import com.demo.openfeign.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "demo-client",
        url = "https://jsonplaceholder.typicode.com/",
        configuration = ClientConfiguration.class,
        fallback = JSONPlaceHolderFallback.class)
public interface DemoClient {

    @GetMapping("/posts")
    List<Post> getPosts();
}
