package com.asif.service;

import com.asif.entity.Comment;
import com.asif.entity.Post;
import com.asif.repository.CommentRepository;
import com.asif.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;

    }


    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
