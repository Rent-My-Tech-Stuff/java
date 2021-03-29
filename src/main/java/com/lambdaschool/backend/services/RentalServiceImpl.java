package com.lambdaschool.backend.services;

import com.lambdaschool.backend.exceptions.ResourceNotFoundException;
import com.lambdaschool.backend.models.Rental;
import com.lambdaschool.backend.models.User;
import com.lambdaschool.backend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "rentalService")
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalRepository rentalrepos;

    @Override
    public List<Rental> findAllRentals()
    {
        List<Rental> list = new ArrayList<>();
        rentalrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
