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

        Category c1 = new Category();
        c1.setName("Computer Science");

        Category c2 = new Category();
        c2.setName("Programming");

        categoryRepo.save(c1);
        categoryRepo.save(c2);

    }
}
