package com.asif.service;

import com.asif.entity.Comment;
import com.asif.entity.Post;
import com.asif.repository.CommentRepository;
import com.asif.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    public CommentService(  PostRepository postRepository,CommentRepository commentRepository){
        this.postRepository=postRepository;
        this.commentRepository = commentRepository;
    }


    public Comment createComment(Comment comment, Long postId) {
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);//object address of the post and Im not set id of the post
        Comment saveComment = commentRepository.save(comment);
        return saveComment;
    }


}
