package com.hkarabakla.services;

import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.CategoryRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {
/*
        Book b1 = new Book();
       // b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");
        b1.setDescription("It's about the Spring Technology!");

        LocalDate publishedDate= LocalDate.of(2010,11,07);
        LocalDate addedDate = LocalDate.of(2020, 1, 6);


        b1.setPublishedDate(publishedDate);
        b1.setAddedDate(addedDate);
        b1.setImageUrl("nazzzzzz.com");
        b1.setCurrency("TR");


        Category c1 = new Category();
        c1.setName("Computer Science");
        c1.setBooks(Collections.singletonList(b1));

        categoryRepo.save(c1);

        System.out.println(c1);


        System.out.println("*****");
        System.out.println("*****");
        System.out.println(categoryRepo.findAll());
        System.out.println("*****");

        System.out.println(categoryRepo.findAllByBooks_NameContainingIgnoreCase(b1.getName()));
        System.out.println("*****");



 */
    }
}
