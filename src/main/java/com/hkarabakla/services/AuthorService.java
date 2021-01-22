package com.hkarabakla.services;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import com.hkarabakla.repositories.AuthorRepo;
import com.hkarabakla.repositories.BookRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void authorOperations() {

        Author author = authorRepo.findByNameContainingIgnoreCase("Hüseyin Karabakla");
        List<Book> books = author.getBooks();

        System.out.println("Yazar adına göre arama\n");
        System.out.println("Yazar: " + author);
        System.out.println("Kitapları: + " + books);

    /*    Predicate<String> isEven = n -> !(authorRepo.findAllByNameContainingIgnoreCase(n).isEmpty());

        //Örnek veri üzerinde uygulanışı
        System.out.println("\n"+"Naz var mı? : " + isEven.test("naz"));
        System.out.println("Hüseyin var mı? : " + isEven.test("hüseyin"));
        System.out.println("Uğur var mı? : " + isEven.test("uğur"));*/
    }
}
