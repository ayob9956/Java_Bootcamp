package com.example.library.Controllers;

import com.example.library.Models.Book;
import com.example.library.Models.Librarian;
import com.example.library.Repostry.LibrarianRepostry;
import com.example.library.Services.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    public final LibrarianService librarianService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(librarianService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Librarian librarian){
        librarianService.addlibrarian(librarian);
        return ResponseEntity.status(200).body("librarian is add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatelibrarian(@PathVariable Integer id,@RequestBody Librarian librarian){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body("librarian is update");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("librarian is delete");

    }
    @GetMapping("/get/{id}")
    public ResponseEntity getLibrarian(@PathVariable Integer id ){
        Librarian librarians=librarianService.getLibrarian(id);


        return ResponseEntity.status(200).body(librarians);

    }

    @GetMapping("/gett/{email}")
    public ResponseEntity getAllEmail(@PathVariable String email ){
        List<Librarian> librarians=librarianService.getAllEmail(email);


        return ResponseEntity.status(200).body(librarians);

    }


    @GetMapping("/getttt/{email}/{password}")
    public ResponseEntity findLibrarian(@PathVariable String email,@PathVariable String password){
        Librarian librarians= librarianService.findLbrarian(email,password);
        return ResponseEntity.status(200).body(librarians);

    }


}
