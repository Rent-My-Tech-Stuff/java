package com.lambdaschool.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "rentals")
public class Rental extends Auditable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long rentalid;

   @Column(nullable = false)
   private String name;

   private String description;

   @Column(nullable = false)
   private double price;

   public Rental() { }

   @ManyToOne
   @JoinColumn(name = "userid", nullable = false)
   @JsonIgnoreProperties(value = "rentals", allowSetters = true)
   private User user;

   public Rental(User user, String name, String description, double price)
   {
      this.user = user;
      this.name = name;
      this.description = description;
      this.price = price;
   }

   public long getRentalid()
   {
      return rentalid;
   }

   public void setRentalid(long rentalid)
   {
      this.rentalid = rentalid;
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

   public double getPrice()
   {
      return price;
   }

   public void setPrice(double price) { this.price = price; }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user) { this.user = user; }
}
