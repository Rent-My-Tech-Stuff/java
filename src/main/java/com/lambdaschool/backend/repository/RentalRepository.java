package com.lambdaschool.backend.repository;

import com.lambdaschool.backend.models.Rental;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

//    @Query(value =
//        "select r.rentalid, r.createdby, r.createddate, r.lastmodifiedby, r.lastmodifieddate, r.category, r.description, r.image, r.name, r.price_per_day, r.rental_period, r.userid, u.username from rentals r JOIN users u on r.userid = u.userid where r.name = :name r.category = :category r.city = :city r.state = :state r.zipcode = :zipcode", nativeQuery = true
//)
    @Query(value =
            "select r.rentalid, r.createdby, r.createddate, r.lastmodifiedby, r.lastmodifieddate, r.category, r.description, r.image, r.name, r.price_per_day, r.rental_period, r.userid, u.username from rentals r JOIN users u on r.userid = u.userid where r.name like %:name% and r.category = :category" , nativeQuery = true
    )
//     List<Rental> findRentalsBySearch(@Param("name") String name, @Param("category") String category,@Param("city") String city,@Param("state") String state,@Param("zipcode") String zipcode);
    List<Rental> findRentalsBySearch(@Param("name") String name, @Param("category") String category);

}
