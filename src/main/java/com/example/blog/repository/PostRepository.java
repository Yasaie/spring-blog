package com.example.blog.repository;

import com.example.blog.entity.Post;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


public interface PostRepository extends JpaRepository<Post, Long> {

    @RestResource(exported = false)
    Optional<Post> findBySlug(String slug);

}
