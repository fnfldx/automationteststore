package runner.pet;

import io.cucumber.junit.CucumberOptions;
import runner.BaseRunnerTest;

@CucumberOptions(
        features = "src/test/resources/cucumber/features/pet/pet_crud.feature")
public class PetCrudRunnerTest extends BaseRunnerTest {
}
