package com.example.blog.entity;

import com.github.slugify.Slugify;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    public Post() {}

    public Post(String title, String content) {
        this.slug = slugify(content);
        this.title = title;
        this.content = content;
    }

    private String slugify(String text) {
        Slugify slg = Slugify.builder().build();

        return slg.slugify(text);
    }
}
