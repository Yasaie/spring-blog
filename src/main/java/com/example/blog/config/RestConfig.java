package com.example.blog.config;

import com.example.blog.entity.Post;
import com.example.blog.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.withEntityLookup()
            .forRepository(PostRepository.class)
            .withIdMapping(Post::getSlug)
            .withLookup(PostRepository::findBySlug);
    }
    
}
