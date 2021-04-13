package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WhenWeCreateANewDog {
    @Test
    public void a_new_dog_should_have_a_name(){
        LocalDate birthday = LocalDate.now();
        Dog fido = new Dog("Fido",birthday,"Poodle");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals(LocalDate.now(),fido.getDateOfBirth());
        Assert.assertEquals("Poodle",fido.getBreed());
    }
}
