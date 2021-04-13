package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WhenWeCreateANewDog {
    @Test
    public void a_new_dog_should_have_a_name(){
        LocalDate birthday = LocalDate.of(2015,10,13);

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("Black")
                .bornOn(birthday);

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals(LocalDate.of(2015,10,13),fido.getDateOfBirth());
        Assert.assertEquals("Labrador",fido.getBreed());
        Assert.assertEquals("Black",fido.getColour());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_food(){
        LocalDate birthday = LocalDate.of(2015,10,13);

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("Black")
                .withFavouriteFood("Beef")
                .bornOn(birthday);

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals(LocalDate.of(2015,10,13),fido.getDateOfBirth());
        Assert.assertEquals("Labrador",fido.getBreed());
        Assert.assertEquals("Black",fido.getColour());
        Assert.assertEquals("Beef",fido.getFavouriteFood());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_toy(){
        LocalDate birthday = LocalDate.of(2015,10,13);

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("Black")
                .withFavouriteToy("Ball")
                .bornOn(birthday);

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals(LocalDate.of(2015,10,13),fido.getDateOfBirth());
        Assert.assertEquals("Labrador",fido.getBreed());
        Assert.assertEquals("Black",fido.getColour());
        Assert.assertEquals("Ball",fido.getFavouriteToy());
    }

}
