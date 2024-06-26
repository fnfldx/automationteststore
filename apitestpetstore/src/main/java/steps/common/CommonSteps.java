package steps.common;

import clients.PetClient;
import model.ResponseDetails;
import steps.BaseSteps;
import io.cucumber.java.en.Then;

public class CommonSteps extends BaseSteps {

    public CommonSteps(ResponseDetails response, PetClient petClient) {
        super(response, petClient);
    }

    @Then("The response with status code {int} is returned")
    public void the_response_with_status_code_is_returned(Integer statusCode) {
        response.getResponse()
                .then().log().all()
                .statusCode(statusCode);
    }
}
