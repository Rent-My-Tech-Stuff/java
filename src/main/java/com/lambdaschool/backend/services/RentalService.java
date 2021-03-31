package com.lambdaschool.backend.services;

import com.lambdaschool.backend.models.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> findAllRentals();

    Rental getRentalById(long id);

    List<Rental> getRentalsByUserId(Long userId);

    Rental addRental(Long userId, Rental rental);

    Rental updateRental(Long rentalId, Rental rentalBody);

    List<Rental> findRentlasBySearch(String name, String category, String city, String state, String zipcode);

    void delete(Long id);
}
