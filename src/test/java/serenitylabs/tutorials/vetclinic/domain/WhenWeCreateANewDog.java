package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class WhenWeCreateANewDog {
    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
    }

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour_returned_as_a_string() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.toString(),is(equalTo("Fido the black labrador")));
        assertThat(fido.toString(),startsWith("Fido"));
        assertThat(fido.toString(),endsWith("labrador"));
    }

    @Test
    public void a_dog_can_have_several_colours(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black","White");

        assertThat(fido.getColour(),contains("Black","White"));
        assertThat(fido.getColour(),hasItem("Black"));

    }

}
