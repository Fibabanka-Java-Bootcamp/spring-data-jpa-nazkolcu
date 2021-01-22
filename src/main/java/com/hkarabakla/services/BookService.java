package com.hkarabakla.services;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.CategoryRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Component
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void bookOperations() {

        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");
        b1.setDescription("It's about the Spring Technology!");
        LocalDate publishedDate = LocalDate.of(2010, 11, 07);
        LocalDate addedDate = LocalDate.of(2020, 1, 6);
        b1.setPublishedDate(publishedDate);
        b1.setAddedDate(addedDate);
        b1.setImageUrl("huseyin.com");
        b1.setCurrency("TR");
        b1.setPrice(30.0);

        Book b2 = new Book();
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setName("Java 2");
        b2.setDescription("It's about the Java Technology!");
        LocalDate publishedDate2 = LocalDate.of(2018, 5, 20);
        LocalDate addedDate2 = LocalDate.of(2020, 2, 7);
        b2.setPublishedDate(publishedDate2);
        b2.setAddedDate(addedDate2);
        b2.setImageUrl("ugur.com");
        b2.setCurrency("TR");
        b2.setPrice(55.99);


        Author a1 = new Author();
        a1.setName("Hüseyin Karabakla");
        a1.setBooks(Collections.singletonList(b1));
        List<Author> authorList = new ArrayList<>();authorList.add(a1);
        b1.setAuthorList(authorList);

        Author a2 = new Author();
        a2.setName("Uğur Çiftçi");
        a2.setBooks(Collections.singletonList(b2));
        List<Author> authorList2 = new ArrayList<>();authorList2.add(a2);
        b2.setAuthorList(authorList2);

        Category c= bookRepo.findByCategorynameContainingIgnoreCase("Programming");

        b1.setCategory(c);
        b2.setCategory(c);

        bookRepo.save(b1);
        bookRepo.save(b2);

        System.out.println("Kitap ismine göre arama\n"+bookRepo.findAllByNameContainingIgnoreCase("Java")+"\n");

    }
}
