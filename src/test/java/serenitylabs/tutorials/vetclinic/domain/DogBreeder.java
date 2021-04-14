package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class DogBreeder implements WithBreed,WithColour {

    private String name;
    private String breed;
    private LocalDate dateOfBirth;
    private String colour;
    private String favouriteFood;
    private String favouriteToy;

    public static DogBreeder aDog(){
        return new DogBreeder();
    }

    public DogBreeder called(String name){
        this.name = name;
        return this;
    }

    public DogBreeder ofBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public DogBreeder ofColour(String colour) {
        this.colour = colour;
        return this;
    }

    public DogBreeder withFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
        return this;
    }

    public DogBreeder withFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
        return this;
    }

    public Dog bornOn(LocalDate birthday) {
        return new Dog(name,breed,birthday,colour,favouriteFood,favouriteToy);
    }

}

