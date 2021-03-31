package com.lambdaschool.backend.services;

import com.lambdaschool.backend.exceptions.ResourceNotFoundException;
import com.lambdaschool.backend.models.Rental;
import com.lambdaschool.backend.models.User;
import com.lambdaschool.backend.repository.RentalRepository;
import com.lambdaschool.backend.repository.UserRepository;
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

    @Autowired
    UserRepository userrepos;

    @Autowired
    private UserAuditing userAuditing;

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

    @Override
    public Rental addRental(Long userId, Rental rental)
    {
        User user = userrepos.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User id " + userId + " not found!"));
        rental.setUser(user);

        return rentalrepos.save(rental);
    }

    @Transactional
    @Override
    public Rental updateRental(Long rentalid, Rental rental)
    {
        Rental currentRental = rentalrepos.findById(rentalid).orElseThrow(() -> new ResourceNotFoundException("Rental id " + rentalid + " not found!"));

        if (rental.getName() != null)
        {
            currentRental.setName(rental.getName());
        }

        if (rental.getDescription() != null)
        {
            currentRental.setDescription(rental.getDescription());
        }

        if (rental.getImage() != null)
        {
            currentRental.setImage(rental.getImage());
        }

        // TODO: Create a hasPrice since you cannot do a !== null against a number
        currentRental.setPrice_per_day(rental.getPrice_per_day());

        if (rental.getUser() != null)
        {
            currentRental.setUser(rental.getUser());
        }

//        rentalrepos.updateRentalInformation(userAuditing.getCurrentAuditor().get(),
//                rentalid,
//                currentRental.getName(),
//                currentRental.getDescription(),
//                currentRental.getImage(),
//                currentRental.getPrice_per_day());


        return getRentalById(rentalid);
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        rentalrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rental id " + id + " not found!"));
        rentalrepos.deleteById(id);
//        userrepos.removeUserWithNoRentals();
    }


    @Override
    public List<Rental> findRentlasBySearch(String name, String category, String city, String state, String zipcode) {
        return rentalrepos.findRentalsBySearch(name, category );
    }
}
