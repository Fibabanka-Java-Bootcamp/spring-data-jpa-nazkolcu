package com.hkarabakla.services;

import com.hkarabakla.entities.Author;
import com.hkarabakla.repositories.AuthorRepo;
import com.hkarabakla.repositories.BookRepo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.function.Predicate;

@Component
public class AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void authorOperations() {
/*
        Author a1 = new Author();
        a1.setName("Hüseyin Karabakla");

        Author a2 = new Author();
        a2.setName("Uğur Çiftçi");


        authorRepo.save(a1);
        authorRepo.save(a2);
*/
        System.out.println(authorRepo.findAll());

        System.out.println("********");
        System.out.println(authorRepo.findAllByNameContainingIgnoreCase("naz"));
        System.out.println(authorRepo.findById(1));
        System.out.println("********");

        Predicate<String> isEven = n -> !(authorRepo.findAllByNameContainingIgnoreCase(n).isEmpty());

        System.out.println("naz var mı?  : " + isEven.test("naz"));
        System.out.println("hüseyin var mı?  : " + isEven.test("hüseyin"));
        System.out.println("Uğur var mı?  : " + isEven.test("uğur"));
   }
}
