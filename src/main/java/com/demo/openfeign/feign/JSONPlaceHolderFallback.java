package com.demo.openfeign.feign;

import com.demo.openfeign.model.Post;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JSONPlaceHolderFallback implements DemoClient {

    @Override
    public List<Post> getPosts() {
        return Collections.emptyList();
    }
}
