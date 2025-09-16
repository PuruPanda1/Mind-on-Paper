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
@Tag(name = "Blogs", description = "LIST ALL BLOGS ENDPOINTS")
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
    @Operation(summary = "Get a blog by ID", description = "Fetches a single blog entry by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved blog",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Blog.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Blog not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Not Found\", \"message\": \"Blog with id 10 not found\" }")
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Unauthorized\", \"message\": \"Authentication required\" }")
                    )
            )
    })
    ResponseEntity<Blog> getBlogById(@PathVariable Long id){
        return blogService.getBlogById(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new blog", description = "Adds a new blog entry to the system (Admin only)")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Blog successfully created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"success\": true }")
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid blog data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Bad Request\", \"message\": \"Blog title is required\" }")
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Unauthorized\", \"message\": \"Authentication required\" }")
                    )
            )
    })
    ResponseEntity<Boolean> createBlog(@RequestBody Blog blog){
        return blogService.createBlog(blog);
    }

    @PostMapping("/update")
    @Operation(summary = "Update an existing blog", description = "Updates blog details by ID (Admin only)")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Blog successfully updated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"success\": true }")
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Blog not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Not Found\", \"message\": \"Blog with id 5 not found\" }")
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid update data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Bad Request\", \"message\": \"Blog title cannot be empty\" }")
                    )
            )
    })
    ResponseEntity<Boolean> updateBlog(@RequestBody Blog blog){
        return blogService.updateBlog(blog);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a blog by ID", description = "Deletes a blog entry from the system (Admin only)")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Blog successfully deleted",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"success\": true }")
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Blog not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Not Found\", \"message\": \"Blog with id 7 not found\" }")
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(example = "{ \"error\": \"Unauthorized\", \"message\": \"Authentication required\" }")
                    )
            )
    })
    ResponseEntity<Boolean> deleteBlog(@PathVariable Long id){
        return blogService.deleteBlog(id);
    }
}
