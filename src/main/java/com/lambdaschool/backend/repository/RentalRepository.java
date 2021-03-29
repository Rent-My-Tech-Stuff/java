package com.lambdaschool.backend.repository;

import com.lambdaschool.backend.models.Rental;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Long> {
    List<Rental> findAllByUser_userid(long id);


//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE products SET name = :name, price_per_day = :price_per_day, description = :description, last_modified_by = :uname, last_modified_date = CURRENT_TIMESTAMP where rentalid = :rentalid", nativeQuery = true)
//    void updateRentalInformation(
//            String uname,
//            Long rentalId,
//            String name,
//            String description,
//            String image,
//            double price_per_day
//    );
}
