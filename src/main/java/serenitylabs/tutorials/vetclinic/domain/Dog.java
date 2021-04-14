package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dog {
    private final LocalDate dateOfBirth;
    private final String breed;
    private final String name;
    private final String favouriteFood;
    private final String colour;
    private final String favouriteToy;

    public Dog(String name, String breed, LocalDate dateOfBirth, String colour, String favouriteFood, String favouriteToy) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.colour = colour;
        this.favouriteFood = favouriteFood;
        this.favouriteToy = favouriteToy;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getColour() { return colour; }

    public String getFavouriteFood() { return favouriteFood; }

    public String getFavouriteToy() { return favouriteToy; }

}
