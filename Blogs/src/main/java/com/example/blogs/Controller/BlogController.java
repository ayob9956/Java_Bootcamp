package com.example.blogs.Controller;

import com.example.blogs.Apis.ApiResponse;
import com.example.blogs.Model.Blog;
import com.example.blogs.Model.User;
import com.example.blogs.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {



private final BlogService blogService;




        @GetMapping("/get")
        public ResponseEntity getBlog(@AuthenticationPrincipal User user) {
            List<Blog> blogs = blogService.findAll(user.getUsername());
            return ResponseEntity.status(200).body(blogs);
        }

        @PostMapping("/add")
        public ResponseEntity addBlog(@RequestBody @Valid Blog blog, @AuthenticationPrincipal User user) {
            blogService.addBlog(blog, user.getId());
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("added successfully"));
        }

        @PutMapping("/update/{blog_id}")
        public ResponseEntity updateBlog(@PathVariable Integer blog_id, @RequestBody @Valid Blog blog,@AuthenticationPrincipal User user) {
            blogService.updateBlog(blog_id, blog, user.getId() );
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("updated successfully"));
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteBlog(@PathVariable Integer id,@AuthenticationPrincipal User user) {
            blogService.removeBlog(id,user.getId()  );
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("deleted successfully"));
        }

        @GetMapping("/search/{title}")
        public ResponseEntity findTodoByTitle(@PathVariable String title) {
            return ResponseEntity.status(HttpStatus.OK).body(blogService.findBlogByTitle(title));


        }

    @GetMapping("/search/id/{id}")
    public ResponseEntity findTodoByTitle(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.findBlogById(id));


    }
}



