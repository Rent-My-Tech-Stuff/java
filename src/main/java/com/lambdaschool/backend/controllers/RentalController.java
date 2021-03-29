package com.lambdaschool.backend.controllers;

import com.lambdaschool.backend.models.Rental;
import com.lambdaschool.backend.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The entry point for clients to access menu data.
 */
@RestController
@RequestMapping("/api")
public class RentalController
{
    /**
     * Using the rental service to process rental data.
     */
    @Autowired
    private RentalService rentalServices;

    /**
     * Returns a list of all rentals.
     * <br>Example: <a href="http://localhost:2019/api/rentals/rentals">http://localhost:2019/api/rentals/rental</a>.
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

    /**
     * Returns a single rental based off a rental id number
     * <br>Example: http://localhost:2019/api/rentals/rental/7
     *
     * @param rentalId The primary key of the user you seek
     * @return JSON object of the rental you seek
     * @see RentalService#getRentalById(long) RentalService.getRentalById(long)
     */
    @GetMapping(value = "/rental/{rentalId}", produces = "application/json")
    public ResponseEntity<?> getRentalById(@PathVariable Long rentalId)
    {
        Rental rental = rentalServices.getRentalById(rentalId);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    /**
     * Returns a list of rentals based off a user id number
     * <br>Example: http://localhost:2019/api/rentals/user/7
     *
     * @param userId The primary key of the user you seek
     * @return JSON object of the user you seek
     */
    @GetMapping(value = "/rentals/user/{userId}", produces = "application/json")
    public ResponseEntity<?> getRentalsByUserId(@PathVariable Long userId)
    {
        List<Rental> rentals = rentalServices.getRentalsByUserId(userId);
        return new ResponseEntity<>(rentals, HttpStatus.OK);
    }

    /**
     * Add a rental based off a user id number
     * <br>Example: http://localhost:2019/api/rentals/user/7
     *
     * @param userId The primary key of the user you seek
     * @return JSON object of the user you seek
     */
    @PostMapping(value = "/rentals/rental/user/{userId}", produces = "application/json")
    public ResponseEntity<?> addRentalsByUserId(@PathVariable Long userId, @RequestBody Rental rentalBody)
    {
        Rental rental = rentalServices.addRental(userId, rentalBody);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    /**
     * update a rental by id
     * <br>Example: http://localhost:2019/api/rental/7
     *
     * @param rentalId The primary key of the rental you seek
     * @return JSON object of the user you seek
     */
    @PutMapping(value = "/rental/{rentalId}", produces = "application/json")
    public ResponseEntity<?> updateRental(@PathVariable Long rentalId, @RequestBody Rental rentalBody)
    {
        Rental rental = rentalServices.updateRental(rentalId, rentalBody);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }
}
