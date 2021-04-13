package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dog {
    private final LocalDate dateOfBirth;
    private final String breed;
    private final String name;

    public Dog(String name, LocalDate dateOfBirth, String poodle) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = poodle;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBreed() {
        return breed;
    }


//    public void setName(String name) {
//        this.name = name;
//    }
}
