package com.example.library.Repostry;

import com.example.library.Models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepostry  extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);
    Librarian findLibrarianByName(String name);

    Librarian findLibrarianByEmailAndPassword(String email,String password);

    List<Librarian> findLibrarianByEmail(String email);


}
