package com.hkarabakla.repositories;

import com.hkarabakla.entities.Author;

import com.hkarabakla.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepo  extends CrudRepository<Author, Integer> {
    List<Author> findAllByNameContainingIgnoreCase(String name);
}
