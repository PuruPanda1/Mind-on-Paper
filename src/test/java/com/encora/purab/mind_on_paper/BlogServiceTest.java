package com.encora.purab.mind_on_paper;

import com.encora.purab.mind_on_paper.data.model.Blog;
import com.encora.purab.mind_on_paper.data.repository.BlogRepository;
import com.encora.purab.mind_on_paper.service.BlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    Blog blog1;
    Blog blog2;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        blog1 = new Blog();
        blog1.setBlogTitle("This is title");
        blog1.setBlogDescription("I am description");

        blog2 = new Blog();
        blog2.setBlogTitle("Second title");
        blog2.setBlogDescription("Second description");
    }

    @Test
    void getBlogsTest(){
        List<Blog> blogList = Arrays.asList(blog1, blog2);

        when(blogRepository.findAll()).thenReturn(blogList);

        ResponseEntity<List<Blog>> response = blogService.getBlogs();

        assertTrue(response.getBody().size()==2);
        assertTrue(response.getBody().get(0).equals(blog1));
    }

    @Test
    void getBlogsByIdTest(){
        List<Blog> blogList = Arrays.asList(blog1, blog2);

        when(blogRepository.findById(1L)).thenReturn(Optional.of(blog1));

        ResponseEntity<Blog> response = blogService.getBlogById(1L);

        assertTrue(response.getBody().equals(blog1));
    }

    @Test
    void createBlogTest(){

        when(blogRepository.save(blog1)).thenReturn(blog1);

        ResponseEntity<Boolean> response = blogService.createBlog(blog1);

        assertTrue(response.getBody());
        verify(blogRepository, times(1)).save(blog1);
    }

    @Test
    void updateBlogTest(){

        when(blogRepository.save(blog1)).thenReturn(blog1);

        ResponseEntity<Boolean> response = blogService.updateBlog(blog1);

        assertTrue(response.getBody());
        verify(blogRepository, times(1)).save(blog1);
    }

    @Test
    void deleteBlogTest(){

        doNothing().when(blogRepository).deleteById(blog1.getBlogId());

        ResponseEntity<Boolean> response = blogService.deleteBlog(blog1);

        assertTrue(response.getBody());
        assertTrue(response.getBody().equals(true));
    }

}
