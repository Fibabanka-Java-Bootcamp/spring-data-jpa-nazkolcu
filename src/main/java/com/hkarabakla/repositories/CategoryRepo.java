package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
