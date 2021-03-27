package com.lambdaschool.backend.services;

import com.lambdaschool.backend.models.Rental;
import com.lambdaschool.backend.models.Useremail;

import java.util.List;

public interface RentalService
{
    public List<Rental> findAll();

    public Rental findRentalById(Long rentalid);

    public void delete(long rentalid);

    Rental save(long userid, String rentalname);

    void update(long rentalid);
}
