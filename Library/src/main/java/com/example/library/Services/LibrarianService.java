package com.example.library.Services;

import com.example.library.ApiRespons.ApiException;
import com.example.library.Models.Librarian;
import com.example.library.Repostry.LibrarianRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LibrarianService {



private final LibrarianRepostry librarianRepostry;



        public List<Librarian> getAll(){
            return librarianRepostry.findAll();
        }

        public void addlibrarian(Librarian librarian){
            librarianRepostry.save(librarian);
        }

        public void updateLibrarian(Integer id,Librarian librarian){
            Librarian librarian1 = librarianRepostry.findLibrarianById(id);

            if (librarian1 == null){
                throw new ApiException("id is not found");
            }
            librarian1.setEmail(librarian.getEmail());

            librarian1.setName(librarian.getName());
            librarian1.setPassword(librarian.getPassword());

            librarianRepostry.save(librarian1);

        }

        public Librarian getLibrarian(Integer id){
            Librarian librarian=librarianRepostry.findLibrarianById(id);

            if (librarian==null){
                throw new ApiException("id not found");
            }

            return librarian;
        }

        public List<Librarian> getAllEmail(String email){
            List<Librarian> librarians = librarianRepostry.findLibrarianByEmail(email);

            if (librarians.isEmpty()){
                throw new ApiException("Emails is empty");

            }
            return librarians;
        }

        public void deleteLibrarian(Integer id) {

            Librarian librarian= librarianRepostry.findLibrarianById(id);

            if (librarian==null){
                throw new ApiException("id not Found");
            }
            librarianRepostry.delete(librarian);
        }

    public Librarian findLbrarian(String email, String password) {

        Librarian librarian = librarianRepostry.findLibrarianByEmailAndPassword(email,password);

        if (librarian==null){
            throw new ApiException("librarian not Found");
        }
        return librarian;
    }
    }



