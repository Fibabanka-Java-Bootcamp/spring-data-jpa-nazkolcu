package com.hkarabakla;

import com.hkarabakla.entities.Book;
import com.hkarabakla.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.hkarabakla");
        appContext.refresh();
        
        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.bookOperations();

        AuthorService authorService = (AuthorService) appContext.getBean("authorService");
        authorService.authorOperations();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

        OrderService orderService = (OrderService) appContext.getBean("orderService");
        orderService.orderOperations();

        appContext.close();
    }
}
