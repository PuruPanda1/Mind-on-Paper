package com.encora.purab.mind_on_paper.controller;

import com.encora.purab.mind_on_paper.data.model.Blog;
import com.encora.purab.mind_on_paper.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogs")
@Tag(name = "Blogs", description = "LIST ALL BLOGS")
public class BlogController {
    BlogService blogService;
    BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("")
    @Operation(summary = "Get all blogs", description = "Fetches the list of all available blogs")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved list of blogs",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Blog.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authorization issue",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    example = "{ \"error\": \"Unauthorized\", \"message\": \"You must be logged in to access this resource\" }"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Server error",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    example = "{ \"error\": \"Internal Server Error\", \"message\": \"An unexpected error occurred\" }"
                            )
                    )
            )
    })
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
