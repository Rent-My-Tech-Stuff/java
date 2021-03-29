package com.lambdaschool.backend.repository;

import com.lambdaschool.backend.models.Rental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Long> {
    List<Rental> findAllByUser_userid(long id);
}
