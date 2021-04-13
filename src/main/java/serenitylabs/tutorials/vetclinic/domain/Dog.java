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

    public static WithBreed called(String name) {
        return new DogBreeder(name);
    }

    interface WithBreed {
        WithColour ofBreed(String breed);
    }

    interface WithColour {
        DogBreeder ofColour(String colour);
    }

    public static class DogBreeder implements WithBreed,WithColour {

        private String name;
        private String breed;
        private LocalDate dateOfBirth;
        private String colour;
        private String favouriteFood;
        private String favouriteToy;

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate birthday) {
            return new Dog(name,breed,birthday,colour,favouriteFood,favouriteToy);
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
    }


//    public void setName(String name) {
//        this.name = name;
//    }
}
