package com.jamerson.estudo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jamerson.estudo.entity.Post;
import com.jamerson.estudo.repository.PostRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Post createPost(Post post) {
        this.postRepository.save(post);
        return this.postRepository.findById(post.getId()).get();
    }

    public Optional<Post> getPostById(Long id) {
        return this.postRepository.findById(id);
    }
    
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }
}
