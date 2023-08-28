package com.example.blogs.Repo;

import com.example.blogs.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {



    Blog  findBlogById(Integer id);



    List<Blog> findAllByUser(com.example.blogs.Model.User user);

    Blog findBlogByTitle(String title);
}
