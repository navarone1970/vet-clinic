package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dog {
    private final LocalDate dateOfBirth;
    private final String breed;
    private final String name;
    private String colour;

    public Dog(String name, String breed, LocalDate dateOfBirth,String colour) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.colour = colour;
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

    public static WithBreed called(String name) {
        return new DogBreeder(name);
    }

    public String getColour() {
        return colour;
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

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate birthday) {
            return new Dog(name,breed,birthday,colour);
        }

        public DogBreeder ofColour(String colour) {
            this.colour = colour;
            return this;
        }
    }


//    public void setName(String name) {
//        this.name = name;
//    }
}
