package com.encora.purab.mind_on_paper.service;

import com.encora.purab.mind_on_paper.data.model.Blog;
import com.encora.purab.mind_on_paper.data.repository.BlogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    BlogRepository blogRepository;
    BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public ResponseEntity<List<Blog>> getBlogs(){
        return ResponseEntity.ok(blogRepository.findAll());
    }

    public ResponseEntity<Blog> getBlogById(Long id){
        return ResponseEntity.ok(blogRepository.findById(id).isPresent()?blogRepository.findById(id).get():new Blog());
    }

    public ResponseEntity<Boolean> createBlog(Blog blog){
        Blog isInserted = blogRepository.save(blog);
        return ResponseEntity.ok(isInserted!=null);
    }

    public ResponseEntity<Boolean> updateBlog(Blog blog){
        Blog isUpdated = blogRepository.save(blog);
        return ResponseEntity.ok(isUpdated!=null);
    }

    public ResponseEntity<Boolean> deleteBlog(Long id){
        blogRepository.deleteById(id);
        boolean isDeleted = !blogRepository.existsById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
