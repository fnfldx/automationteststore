package clients;

import endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pet;

import java.io.File;

public class PetClient extends BaseClient {

    private static final String PET_URL = BASE_URL + "/pet/";

    public Response getPetsByStatus(final String status) {
        return RestAssured.given()
                .when()
                .queryParams(Pet.Fields.status, status)
                .get(Routes.PET_FIND_BY_STATUS);
    }

    public Response getPetById(final long petId) {
        return RestAssured.given()
                .pathParam("petId", petId)
                .when()
                .get(Routes.PET_FIND_BY_ID);
    }

    public Response postPet(final Pet pet) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(Routes.PET_ADD);
    }

    public Response postPetUploadImage(final long petId, final File file) {
        return RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .pathParam("petId", petId)
                .multiPart("file", file)
                .when()
                .post(Routes.PET_UPLOAD_IMAGE);
    }

    public Response putPet(final Pet pet) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(Routes.PET_UPDATE);
    }

    public Response deletePet(final long petId) {
        return RestAssured.given()
                .pathParam("petId", petId)
                .when()
                .delete(Routes.PET_DELETE);
    }
}