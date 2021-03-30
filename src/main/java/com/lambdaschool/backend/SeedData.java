package com.lambdaschool.backend;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.lambdaschool.backend.models.*;
import com.lambdaschool.backend.services.RentalService;
import com.lambdaschool.backend.services.RoleService;
import com.lambdaschool.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Random;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@ConditionalOnProperty(
        prefix = "command.line.runner",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = true)
@Component
public class SeedData implements CommandLineRunner

{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    @Autowired
    RentalService rentalService;

    /**
     * A Random generator is needed to randomly generate faker data.
     */
    private Random random = new Random();

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws
            Exception
    {
        userService.deleteAll();
        roleService.deleteAll();
        Role r1 = new Role("owner");
        Role r2 = new Role("renter");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);

        // admin, data, user
        User u1 = new User(
                "admin",
                "password",
                "admin@lambdaschool.local",
                "Admin",
                "Admin",
                "221B Baker Street",
                "221B Baker Street",
                "London",
                "London",
                "88888"
                );
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));
        u1.getUseremails().add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails().add(new Useremail(u1, "admin@mymail.local"));

        userService.save(u1);

        // data, user
        User u2 = new User(
                "cinnamon",
                "1234567",
                "cinnamon@lambdaschool.local",
                "Cinnamon",
                "Buns",
                "1234567 Street",
                "1234567 Street",
                "Cinncinati",
                "Ohio",
                "1234567"
        );
        u2.getRoles().add(new UserRoles(u2, r2));
        u2.getUseremails().add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails().add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails().add(new Useremail(u2, "bunny@email.local"));
        userService.save(u2);

        // user
        User u3 = new User(
                "barnbarn",
                "ILuvM4th!",
                "barnbarn@lambdaschool.local",
                "Barn",
                "Barn",
                "324 Barn St.",
                "324 Barn St",
                "Chicago",
                "IL",
                "60601"
        );
        u3.getRoles().add(new UserRoles(u3, r2));
        u3.getUseremails().add(new Useremail(u3, "barnbarn@email.local"));
        userService.save(u3);

        if (true)
        {
            // using JavaFaker create a bunch of regular users
            // https://www.baeldung.com/java-faker
            // https://www.baeldung.com/regular-expressions-java

            // fake users

            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());
            Faker nameFaker = new Faker(new Locale("en-US"));

            for (int i = 0; i < 5; i++)
            {
                new User();
                new Rental();

                User fakeUser;
                Rental fakeRental;

                int randomNumber = random.nextInt(10) + 1; // random number 1 through 10

                fakeUser = new User(
                        nameFaker.name().username(),
                        "password",
                        nameFaker.internet().emailAddress(),
                        nameFaker.name().firstName(),
                        nameFaker.name().lastName(),
                        nameFaker.address().streetAddress(),
                        nameFaker.address().streetAddress(),
                        nameFaker.address().city(),
                        nameFaker.address().state(),
                        nameFaker.address().zipCode()
                        );
                fakeUser.getRoles().add(new UserRoles(fakeUser, r2));
                fakeUser.getUseremails().add(new Useremail(fakeUser, fakeValuesService.bothify("????##@gmail.com")));

                for (int j = 0; j < randomNumber; j++)
                {
                    String name = nameFaker.commerce().productName();
                    String trimmedName = name.replaceAll("\\s", "");
                    fakeUser.getRentals().add(new Rental(
                            fakeUser,
                            name,
                            nameFaker.lorem().paragraph(),
                            nameFaker.number().randomDouble(2, 1, 100),
                            "https://source.unsplash.com//200x200?sig=incrementingIdentifier"
                    ));
                }

                //  another pic source: https://picsum.photos/seed/picsum/200/300
                userService.save(fakeUser);

            }
        }
    }
}