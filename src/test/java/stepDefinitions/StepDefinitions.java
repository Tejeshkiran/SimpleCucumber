package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Given("add {string} {string} {string} in AddplaceApi payload")
    public void add_in_addplace_api_payload(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("hello");

    }
    @When("call {string} with {string} http method")
    public void call_with_http_method(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("validate response has {int} status code")
    public void validate_response_has_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("validate response parameter has {string} is {string}")
    public void validate_response_parameter_has_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("validate place is madded to {string} using {string}")
    public void validate_place_is_madded_to_using(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }


}
