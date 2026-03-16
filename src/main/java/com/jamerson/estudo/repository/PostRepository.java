package com.jamerson.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamerson.estudo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
