package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.Pet;
import io.restassured.response.Response;

import java.io.File;

public class PetClient extends BaseClient {

    private static final String PET_URL = BASE_URL + "/pet/";

    public Response getPetsByStatus(final String status) {
        return RestAssured.given()
                .when()
                .queryParams(Pet.Fields.status, status)
                .get(PET_URL + "findByStatus");
    }

    public Response getPetById(final long petId) {
        return RestAssured.given()
                .when()
                .get(PET_URL + petId);
    }

    public Response postPet(final Pet pet) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(PET_URL);
    }

    public Response postPetUploadImage(final long petId, final File file) {
        return RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("file", file)
                .when()
                .post(PET_URL + petId + "/uploadImage");
    }

    public Response putPet(final Pet pet) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(PET_URL);
    }

    public Response deletePet(final long petId) {
        return RestAssured.given()
                .when()
                .delete(PET_URL + petId);
    }
}