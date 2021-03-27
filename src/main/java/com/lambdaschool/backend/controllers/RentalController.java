package com.lambdaschool.backend.controllers;

import com.lambdaschool.backend.models.Rental;
import com.lambdaschool.backend.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The entry point for client to access user, email combinations
 */
@RestController
@RequestMapping("/rentals")
public class RentalController
{
    @Autowired
    RentalService rentalService;

    @GetMapping(value = "/rentals", produces = "application/json")
    public ResponseEntity<?> listAllRentals()
    {
        List<Rental> allRentals = rentalService.findAll();
        return new ResponseEntity<>(allRentals, HttpStatus.OK);
    }

    @GetMapping(value = "/rental/{rentalid}", produces = "application/json")
    public ResponseEntity<?> getRentalById( @PathVariable Long rentalid)
    {
        Rental ue = rentalService.findRentalById(rentalid);
        return new ResponseEntity<>(ue, HttpStatus.OK);
    }

    @DeleteMapping(value = "/rental/{rentalid}")
    public ResponseEntity<?> deleteRentalById( @PathVariable long rentalid)
    {
        rentalService.delete(rentalid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/rental/{rentalid}")
    public ResponseEntity<?> updateRental( @PathVariable long rentalid, @PathVariable String rentalname)
    {
        rentalService.update(rentalid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/user/{userid}/rental/{rentalname}")
    public ResponseEntity<?> addRental( @PathVariable long userid, @PathVariable String rentalname) throws URISyntaxException
    {
        Rental newRental = rentalService.save(userid, rentalname);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRentalURI = ServletUriComponentsBuilder.fromCurrentServletMapping()
            .path("/rentals/rental/{rentalid}")
            .buildAndExpand(newRental.getRentalid())
            .toUri();
        responseHeaders.setLocation(newRentalURI);

        return new ResponseEntity<>(null,
            responseHeaders,
            HttpStatus.CREATED);
    }
}
