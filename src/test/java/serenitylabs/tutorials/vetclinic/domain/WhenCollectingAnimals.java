package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenCollectingAnimals {

    @Test
    public void a_list_of_animals_can_contain_cats_and_dogs(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");

        List<Animal> animals = new ArrayList<>();

        animals.add(fido);
        animals.add(felix);

        assertThat(animals,hasItems(fido,felix));

    }

    @Test
    public void a_dog_complains_by_growling(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.complaint(), is(equalTo("Grrrr")));

    }

    @Test
    public void a_cat_complains_by_meowing(){
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");

        assertThat(felix.complaint(), is(equalTo("Meow")));

    }

    @Test
    public void cats_and_dogs_complain_to_the_assistant(){
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant assistant = new VetAssistant(complaintRegister);

        assistant.recordComplainFrom(fido);
        assistant.recordComplainFrom(felix);
        assertThat(complaintRegister.getComplains(), hasItems("Grrrr", "Meow"));

    }

    @Test
    public void the_vet_should_know_when_a_pet_vaccination_is_due(){
        NeedsVaccination felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");
        NeedsVaccination fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);
        LocalDate nextHalfYear = today.plusMonths(6);

        felix.wasVaccinatedOn(today);
        fido.wasVaccinatedOn(today);

        assertThat(felix.nextVaccinationDate(),is(equalTo(nextYear)));
        assertThat(fido.nextVaccinationDate(),is(equalTo(nextHalfYear)));
    }

}
