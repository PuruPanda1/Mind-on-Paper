package com.encora.purab.mind_on_paper;

import com.encora.purab.mind_on_paper.data.model.Blog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// Integration Testing is done at Controller + DB + Spring context
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class BlogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Blog blog;

    @BeforeEach
    void init(){
        blog = new Blog();
        blog.setBlogTitle("Integration testing");
        blog.setBlogDescription("Here we learn about integration testing!");
    }

    @Test
    void getBlogsTest() throws Exception{
        mockMvc.perform(post("/blogs/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(blog)));

        mockMvc.perform(get("/blogs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].blogTitle").value("Integration testing"));
    }

    @Test
    void getBlogByIdTest() throws Exception{
        mockMvc.perform(post("/blogs/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(blog)));

        mockMvc.perform(get("/blogs/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.blogTitle").value("Integration testing"));
    }

    @Test
    void createBlogTest() throws Exception{

        mockMvc.perform(post("/blogs/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(blog)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    void updateBlogTest() throws Exception{
        blog.setBlogTitle("Updated");
        mockMvc.perform(post("/blogs/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(blog)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    void deleteBlogTest() throws Exception{
        mockMvc.perform(delete("/blogs/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

}
