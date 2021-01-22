package com.hkarabakla.repositories;

import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import com.hkarabakla.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Orders, Integer>{
//User findAllByUserContainingOrderByUser(String User);
//List<Orders> findAllByUser(String User);

//List<Orders> findAllByUseridContainingIgnoreCase(String name);
    Orders findByUser_NameContainingIgnoreCase(String name);

    @Query("select u from User u where u.name = ?1")
    User findByUsernameContainingIgnoreCase(String name);
    @Query("select u from User u where u.id = ?1")
    User findByUserid(int id);

    @Query("select b from Book b where b.name = ?1")
    Book findByBookname(String name);
}
