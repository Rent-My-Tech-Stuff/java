package com.lambdaschool.backend.repository;

import com.lambdaschool.backend.models.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Long> {}
