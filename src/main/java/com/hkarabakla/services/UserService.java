package com.hkarabakla.services;

import com.hkarabakla.entities.Address;
import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void userOperations() {

        User u = new User();
        u.setName("Naz Kolcu");
        Address address = new Address();
        address.setStreet("Dere Caddesi");
        address.setNumber("19");
        address.setCity("Istanbul");
        address.setZipcode(9684);
        u.setAddress(address);

        User u2 = new User();
        u2.setName("Ümit Balta");
        Address address2 = new Address();
        address2.setStreet("Ali Tümkaya Caddesi");
        address2.setNumber("73");
        address2.setCity("Hatay");
        address2.setZipcode(654);
        u2.setAddress(address2);

        User u3 = new User();
        u3.setName("Hüseyin Karabakla");
        Address address3 = new Address();
        address3.setStreet("Gazi Caddesi");
        address3.setNumber("7");
        address3.setCity("Istanbul");
        address3.setZipcode(123);
        u3.setAddress(address3);

        repo.save(u);
        repo.save(u2);
        repo.save(u3);

    }

}
