package com.asif.controller;


import com.asif.entity.Comment;
import com.asif.repository.PostRepository;
import com.asif.service.CommentService;
import com.asif.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService) {

        this.commentService = commentService;

    }

    @PostMapping("/addComment")
    public ResponseEntity<Comment> createComment(
            @RequestBody Comment comment,
            @RequestParam Long postId
    ) {
        Comment comment1 = commentService.createComment(comment, postId);
        return new ResponseEntity<>(comment1, HttpStatus.CREATED);
    }
}
