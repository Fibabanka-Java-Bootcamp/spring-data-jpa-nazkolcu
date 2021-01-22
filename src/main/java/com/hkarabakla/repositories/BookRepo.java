package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, String> {

    @Query("select c from Category c where c.name = ?1")
    Category findByCategorynameContainingIgnoreCase(String name);

    List<Book> findAllByNameContainingIgnoreCase(String name);
}
