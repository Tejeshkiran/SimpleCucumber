package StepDefinitions;

import GoogleApisSerializationPayload.DataSetter;
import Payloads.GoogleApispayloads;
import Resourses.ResourseApis;
import Resourses.Utilitis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class Stepdefinitions extends Utilitis {
    RequestSpecification req;
    Response resp;
    static String place_id;
    ResourseApis rApis;

    @Given("add {string} {string} {string} in AddplaceApi payload")
    public void add_in_addplace_api_payload(String name, String address, String language) throws IOException {

        req = given().spec(Utilitis.getRequestSpecification())
                .body(DataSetter.getAddPlaceApiPayload(name, address, language));

    }

    @When("send the {string} httprequest using {string}")
    public void send_the_httprequest_using(String httpMethod, String resourse) {
        rApis = ResourseApis.valueOf(resourse);
        if (httpMethod.equalsIgnoreCase("Post")) {
            resp = req.when().post(rApis.getPath()).then().spec(Utilitis.getResponseSpecification(200))
                    .assertThat().time(lessThan(3000l))
                    .extract().response();
        } else if (httpMethod.equalsIgnoreCase("Get")) {
            resp = req.when().get(rApis.getPath()).then().spec(Utilitis.getResponseSpecification(200))
                    .assertThat().time(lessThan(3000l))
                    .extract().response();
        } else if (httpMethod.equalsIgnoreCase("Delete")) {
            resp = req.when().delete(rApis.getPath()).then().spec(Utilitis.getResponseSpecification(200))
                    .extract().response();
        }

    }

    @Then("validate the status code has {int}")
    public void validate_the_status_code_has(Integer statusCode) {
        Assert.assertEquals(resp.getStatusCode(), statusCode.intValue());
    }

    @Then("validate response Attribute {string} is {string}")
    public void validate_response_attribute_is(String key, String ExpectedValue) {
        String Actualvalue = Utilitis.JsonParse(resp, key);
        Assert.assertEquals(Actualvalue, ExpectedValue);
    }

    @Then("validate address is mapped to {string} using {string}")
    public void validate_address_is_mapped_to_using(String ExpectedName, String resourse) throws IOException {
        place_id = Utilitis.JsonParse(resp, "place_id");
        req = given().spec(Utilitis.getRequestSpecification())
                .queryParam("place_id", place_id);
        send_the_httprequest_using("Get", resourse);
        String ActualName = Utilitis.JsonParse(resp,"name");
        Assert.assertEquals(ActualName, ExpectedName);
    }

    @Given("add placeid in body as payload")
    public void add_placeid_in_body_as_payload() throws IOException {
        req = given().spec(Utilitis.getRequestSpecification())
                .body(GoogleApispayloads.getdeletePayload(place_id));
    }

}
