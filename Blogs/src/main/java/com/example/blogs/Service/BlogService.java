package com.example.blogs.Service;

import com.example.blogs.Apis.ApiException;
import com.example.blogs.Model.Blog;
import com.example.blogs.Model.User;
import com.example.blogs.Repo.BlogRepo;
import com.example.blogs.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {


    private final BlogRepo blogRepository;
    private final UserRepo userRepository;

    public List<Blog> findAll(String username){
        User user = userRepository.findUserByUsername(username);
        return blogRepository.findAllByUser(user);
    }

    public void addBlog(Blog blog,Integer UserId) {
        User user = userRepository.findUserById(UserId);

        blog.setUser(user);
        blogRepository.save(blog);
    }

    public void removeBlog(Integer id,Integer Userid) {
        User user = userRepository.findUserById(Userid);
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null || blog.getUser() != user) {
            throw new ApiException("Blog not found: " + id +" user id not found: " + id);
        }
        blogRepository.delete(blog);
    }

    public void updateBlog(Integer id, Blog blog,Integer UserId) {
        Blog blog1 = blogRepository.findBlogById(id);
        User user = userRepository.findUserById(UserId);
        if (blog1 == null || blog1.getUser() != user) {
            throw new ApiException("Blog not found: " + id +" user id not found: " + UserId);
        }
        blog1.setTitle(blog.getTitle());
        blog1.setBody(blog.getBody());
        blogRepository.save(blog1);
    }

    public Blog findBlogByTitle(String title) {
        Blog blog = blogRepository.findBlogByTitle(title);
        if (blog == null) {
            throw new ApiException("Todo not found: " + title);
        }
        return blog;
    }

    public Blog findBlogById(Integer id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("Todo not found: " + id);
        }
        return blog;
    }
}
