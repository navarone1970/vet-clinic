package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.domain.dog.Dog;

import java.time.LocalDate;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name(){

        LocalDate birthday = LocalDate.now();
        Dog fido = new Dog("Fido","Labrador",birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals(LocalDate.now(),fido.getDateOfBirth());
        Assert.assertEquals("Labrador",fido.getBreed());
    }
}
