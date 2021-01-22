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

        //User'a id veya name ile ulaşılabilir
        // User user = repo.findByUserid(5);
        User user =repo.findByUsernameContainingIgnoreCase("Naz Kolcu");

        //Book'a ismi ile ulaşılabilir
        Book book = repo.findByBookname("Spring in Action");

        List<Book> books = new ArrayList<>();
        books.add(book);

        Function<List, Double> function = (arr) -> {
            double total = 0;
            for (int i = 0; i < arr.size(); i++) {

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

        repo.save(o);

        //Kullanıcının tüm siparişlerini listeleme
        System.out.println("Kullancının siparişleri detaylarıyla birlikte");
        System.out.println("\n"+repo.findByUser_NameContainingIgnoreCase("Naz Kolcu"));

    }

}
