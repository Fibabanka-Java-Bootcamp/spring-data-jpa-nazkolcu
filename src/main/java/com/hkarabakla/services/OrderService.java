package com.hkarabakla.services;

import com.hkarabakla.entities.*;
import com.hkarabakla.repositories.OrderRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class OrderService {

    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    public void orderOperations() {
        System.out.println("/////");
        User user =repo.findByUsernameContainingIgnoreCase("Naz Kolcu");
       // User user = repo.findByUserid(5);
        System.out.println(user);
        System.out.println("/////");
        System.out.println("/////");
        Book book = repo.findByBookname("Spring in Action");
        System.out.println(book);
        System.out.println("/////");
        List<Book> books = new ArrayList<>();
        books.add(book);

        Function<List, Double> function = (arr) -> {
            double total = 0;
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
                Book b1 = (Book) arr.get(i);
                total = total + b1.getPrice();
            }

            return total;
        };
        double totalBooksPrice = function.apply(books);

        Orders o = new Orders();
        o.setTotal(totalBooksPrice);
         o.setUser(user);
        o.setBooks(books);
        o.setCreated_at(LocalDate.now());

        System.out.println(o);

        repo.save(o);
        System.out.println("++++++++++++");
        System.out.println(repo.findByUser_NameContainingIgnoreCase("naz"));
       // System.out.println(repo.findAll());
        System.out.println("++++++++++++");
        /*
  List<Book> books = new ArrayList<>();

        User u = new User();
        u.setName("Naz baltaaaa");
        Address address = new Address();
        address.setStreet("Dere Caddesi");
        address.setNumber("19");
        address.setCity("Istanbul");
        u.setAddress(address);

        Orders o = new Orders();
        o.setTotal(10.8);
        o.setUser(u);
        o.setBooks(books);

        Orders o2 = new Orders();
        o2.setTotal(50.5);
        o2.setUser(u);
        o2.setBooks(books2);

        repo.save(o);
       // repo.save(o2);
        System.out.println(o);
       // System.out.println(o2);
        System.out.println(repo.findAllByUser_NameContainingIgnoreCase(u.getName()));
      //  System.out.println(repo.findOrdersByUserNameContainingIgnoreCase(u.getName()));

//        System.out.println("selammmmmm"+repo.findAllByUser(u.getName()));
        // System.out.println(u);
*/
    }

}
