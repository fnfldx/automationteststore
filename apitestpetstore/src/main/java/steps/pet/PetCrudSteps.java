package steps.pet;

import clients.PetClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import model.Pet;
import model.PetUtils;
import model.ResponseDetails;
import org.assertj.core.api.Assertions;
import steps.BaseSteps;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PetCrudSteps extends BaseSteps {

    private static final Pet newPet = PetUtils.generatePetWithRandomTestData();
    private static Pet updatedPet;

    public PetCrudSteps(ResponseDetails response, PetClient petClient) {
        super(response, petClient);
    }

    @When("Add a new pet to the store")
    public void add_a_new_pet_to_the_store() {
        response.setResponse(petClient.postPet(newPet));
    }

    @When("Update an existing pet")
    public void update_an_existing_pet() {
        add_a_new_pet_to_the_store();
        updatedPet = PetUtils.generatePetWithRandomTestData(newPet.getId());

        response.setResponse(petClient.putPet(updatedPet));
    }

    @When("Delete an existing pet")
    public void delete_an_existing_pet() {
        add_a_new_pet_to_the_store();

        response.setResponse(petClient.deletePet(newPet.getId()));
    }

    @When("Find pet by id")
    public void find_pet_by_id() {
        add_a_new_pet_to_the_store();

        response.setResponse(petClient.getPetById(newPet.getId()));
    }

    @When("Finds Pets by status {string}")
    public void finds_pets_by_status(String status) {
        response.setResponse(petClient.getPetsByStatus(status));
    }

    @When("Upload an image for a pet")
    public void upload_an_image_for_a_pet() {
        add_a_new_pet_to_the_store();
        final var imageFile = new File("src/test/resources/cucumber/features/pet/test_image.jpg");

        response.setResponse(petClient.postPetUploadImage(newPet.getId(), imageFile));
    }

    @And("Check if status {string} is returned")
    public void check_if_status_is_returned(String expectedStatus) {
        final List<Pet> pets = Arrays.asList(response.getResponse().getBody().as(Pet[].class, ObjectMapperType.GSON));

        final List<String> statuses = pets.stream().map(Pet::getStatus).toList();

        Assertions.assertThat(statuses).containsOnly(expectedStatus);
    }

    @And("Check the response body of created pet is correct")
    public void check_the_response_body_of_created_pet_is_correct() {
        final Pet createdPet = response.getResponse().getBody().as(Pet.class);

        Assertions.assertThat(createdPet).isEqualToComparingFieldByFieldRecursively(newPet);
    }

    @And("Check the response body of updated pet is correct")
    public void check_the_response_body_of_updated_pet_is_correct() {
        final var updatedPetFromResponse = response.getResponse().getBody().as(Pet.class);

        assertThat(updatedPetFromResponse).isEqualToComparingFieldByFieldRecursively(updatedPet);
    }

    @And("Check the response body of found pet is correct")
    public void check_the_response_body_of_found_pet_is_correct() {
        final var foundPet = response.getResponse().getBody().as(Pet.class);

        assertThat(foundPet).isEqualToComparingFieldByFieldRecursively(newPet);
    }

    @And("Check if pet is not found")
    public void check_if_pet_is_not_found() {
        final var petId = newPet.getId();
        final var response = petClient.getPetById(petId);
        final var message = response.jsonPath().getString("message");

        assertThat(message).isEqualTo("Pet not found");
        assertThat(response.getStatusCode()).isEqualTo(404);
    }
}