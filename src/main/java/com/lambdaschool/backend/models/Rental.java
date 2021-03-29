package com.lambdaschool.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "rentals")
public class Rental extends Auditable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long rental_id;

   @Column(nullable = false)
   private String name;

   private String category;

   @Column( length = 100000 )
   private String description;

   private String image;

   @Column
   private double price_per_day;

   @Column(nullable = false)
   private int rental_period;

   @ManyToOne
   @JoinColumn(name = "userid", nullable = false)
   @JsonIgnoreProperties(value = "rentals", allowSetters = true)
   private User user;

   public Rental() { }

   public Rental(User user, String name, String description, double price_per_day, String image)
   {
      this.user = user;
      this.name = name;
      this.description = description;
      this.price_per_day = price_per_day;
      this.image = image;
   }

   public long getRental_id()
   {
      return rental_id;
   }

   public void setRental_id(long rentalid)
   {
      this.rental_id = rentalid;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public double getPrice_per_day()
   {
      return price_per_day;
   }

   public void setPrice_per_day(double price) { this.price_per_day = price; }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user) { this.user = user; }

   public String getImage() { return image; }

   public void setImage(String image) { this.image = image; }
}
