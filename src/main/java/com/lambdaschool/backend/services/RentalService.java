package com.lambdaschool.backend.services;

import com.lambdaschool.backend.models.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> findAllRentals();
}
