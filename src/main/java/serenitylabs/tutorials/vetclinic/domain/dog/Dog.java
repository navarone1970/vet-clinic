package serenitylabs.tutorials.vetclinic.domain.dog;

import java.time.LocalDate;

public class Dog {
    private final LocalDate dateOfBirth;
    private final String name;
    private final String breed;

    public Dog(String name, String breed, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
    }

    public static DogBreeder called(String name) {
        return new DogBreeder(name);
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


    public static class DogBreeder {

        private String name;
        private String breed;

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate birthday) {
            return new Dog(name,breed,birthday);
        }
    }
}
