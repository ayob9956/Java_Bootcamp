package com.example.library.Repostry;

import com.example.library.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepostry extends JpaRepository<Book,Integer> {

    Book findBookBy(Integer id);

    List<Book> findbookByCategory(String category);

    List<Book> findBookByAuthor(String author);

    @Query(" select b from Book b  where b.title=?1")
    Book getBooksdsdBy(String title);

    @Query("select b from Book b where b.numberofpages > 300")
    Book findBookByNumberofpagesGreaterThan();

    @Query(" select b from Book b  where b.author=?1")
    Book getBooksByauthors(String author);
}
