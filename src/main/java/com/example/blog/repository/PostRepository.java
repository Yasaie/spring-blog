package com.example.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.blog.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long> {}