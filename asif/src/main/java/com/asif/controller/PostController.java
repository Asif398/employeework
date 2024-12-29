package com.asif.controller;

import com.asif.entity.Post;
import com.asif.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService =postService;

    }
    @PostMapping("/add")
    public ResponseEntity<Post> createPost(
          @RequestBody Post post
    ){
        Post post1 = postService.createPost(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }


//    http://localhost:8080/api/v1/post?id=1
    @DeleteMapping
    public ResponseEntity<String > deletePost(
        @RequestParam Long id
    ){
             postService.deletePost(id);
        return new ResponseEntity<>("Record Deleted",HttpStatus.OK);
    }
}
