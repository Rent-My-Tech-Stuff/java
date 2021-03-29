package com.lambdaschool.backend.services;

import com.lambdaschool.backend.exceptions.ResourceNotFoundException;
import com.lambdaschool.backend.models.Rental;
import com.lambdaschool.backend.models.User;
import com.lambdaschool.backend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Override
    public Rental getRentalById(long id)
    {
        return rentalrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rental with id " + id + " not found."));
    }

    @Override
    public List<Rental> getRentalsByUserId(Long userId)
    {
       return rentalrepos.findAllByUser_userid(userId);
    }

    /**
     * TODO
     * Updates the name of the role based on the given role id.
     *
     * @param uname  The username making this change
     * @param rentalid The primary key (long) of the role to change
     * @param name   The new name (String) of the role
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE roles SET name = :name, lastmodifiedby = :uname, lastmodifieddate = CURRENT_TIMESTAMP WHERE roleid = :rentalid        ", nativeQuery = true)
    void findBySearch( String uname, long rentalid, String name) { }
}
