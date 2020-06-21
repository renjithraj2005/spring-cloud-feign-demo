package com.demo.openfeign.feign;

import com.demo.openfeign.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JSONPlaceHolderFallback implements DemoClient {

    @Override
    public List<Post> getPosts(String header) {
        return Collections.emptyList();
    }

    @Override
    public ResponseEntity<Void> getTest() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
