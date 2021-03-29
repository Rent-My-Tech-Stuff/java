package com.lambdaschool.backend.controllers;

import com.lambdaschool.backend.models.Rental;
import com.lambdaschool.backend.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The entry point for clients to access menu data.
 */
@RestController
@RequestMapping("/rentals")
public class RentalController
{
    /**
     * Using the rental service to process rental data.
     */
    @Autowired
    private RentalService rentalServices;

    /**
     * Returns a list of all rentals.
     * <br>Example: <a href="http://localhost:2019/rentals/rentals">http://localhost:2019/rentals/rentals</a>.
     *
     * @return JSON list of all rentals with a status of OK.
     * @see RentalService#findAllRentals() RentalServices.findAllRentals()
     */
    @GetMapping(value = "/rentals", produces = "application/json")
    public ResponseEntity<?> listAllRentals()
    {
        List<Rental> myRentals = rentalServices.findAllRentals();
        return new ResponseEntity<>(myRentals, HttpStatus.OK);
    }
}
