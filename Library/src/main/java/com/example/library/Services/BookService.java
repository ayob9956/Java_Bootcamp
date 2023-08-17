package com.example.library.Services;

import com.example.library.ApiRespons.ApiException;
import com.example.library.Models.Book;
import com.example.library.Repostry.BookRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookService {





        private final BookRepostry bookRepostry;

        public List<Book> getAll(){
            return bookRepostry.findAll();
        }

        public void addBook(Book book){
            bookRepostry.save(book);
        }

        public void updateBook(Integer id,Book book){
            Book book1 = bookRepostry.findBookBy(id);

            if (book1 == null){
                throw new ApiException("id is not found");
            }
            book1.setTitle(book.getTitle());
            book1.setCategory(book.getCategory());
            book1.setAuthor(book.getAuthor());
            book1.setIsbn(book.getIsbn());

            bookRepostry.save(book1);

        }

        public Book getBook(Integer id){
            Book book=bookRepostry.findBookBy(id);

            if (book==null){
                throw new ApiException("id not found");
            }

            return book;
        }

        public List<Book> getAllCategory(String category){
            List<Book> coffees = bookRepostry.findbookByCategory(category);

            if (category.isEmpty()){
                throw new ApiException("category is empty");

            }
            return coffees;
        }

        public void deleteBook(Integer id) {

            Book book1= bookRepostry.findBookBy(id);

            if (book1==null){
                throw new ApiException("id not Found");
            }
            bookRepostry.delete(book1);
        }



        public Book getAllmorthan300(){
           Book books=  bookRepostry.findBookByNumberofpagesGreaterThan();
        return books;
    }
    }

