package com.example.library.Controllers;

import com.example.library.Models.Book;
import com.example.library.Services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor

public class BookController {



        private final BookService bookService;
        @GetMapping("/get")
        public ResponseEntity getAll(){
            return ResponseEntity.status(200).body(bookService.getAll());
        }
        @PostMapping("/add")
        public ResponseEntity addBook(@RequestBody @Valid Book book){
            bookService.addBook(book);
            return ResponseEntity.status(200).body("book is add");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateBook(@PathVariable Integer id,@RequestBody Book book){
            bookService.updateBook(id, book);
            return ResponseEntity.status(200).body("book is update");

        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteBook(@PathVariable Integer id){
            bookService.deleteBook(id);
            return ResponseEntity.status(200).body("book is delete");

        }
        @GetMapping("/gett/{category}")
        public ResponseEntity getAllCategory(@PathVariable String category){
            List<Book> books=bookService.getAllCategory(category);


            return ResponseEntity.status(200).body("Book is found");

        }
    @GetMapping("/get/getAllmorthan300")
    public ResponseEntity getAllmorthan300(){
        return ResponseEntity.status(200).body(bookService.getAllmorthan300());
    }
}
