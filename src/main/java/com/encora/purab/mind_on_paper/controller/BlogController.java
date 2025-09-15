package com.encora.purab.mind_on_paper.controller;

import com.encora.purab.mind_on_paper.data.model.Blog;
import com.encora.purab.mind_on_paper.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    BlogService blogService;
    BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("")
    ResponseEntity<List<Blog>> getBlogs(){
        return blogService.getBlogs();
    }

    @GetMapping("/{id}")
    ResponseEntity<Blog> getBlogById(@PathVariable Long id){
        return blogService.getBlogById(id);
    }

    @PostMapping("/create")
    ResponseEntity<Boolean> createBlog(@RequestBody Blog blog){
        return blogService.createBlog(blog);
    }

    @PostMapping("/update")
    ResponseEntity<Boolean> updateBlog(@RequestBody Blog blog){
        return blogService.updateBlog(blog);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteBlog(@PathVariable Long id){
        return deleteBlog(id);
    }
}
