package StepDefinitions;

import org.testng.Assert;

import pageobject.petdetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class postmethod{
    private Scenario scenario;
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^Using POST operation to add a pet with body$")
    public void postoperationtoaddnewpet(DataTable dtPetDetails) {

        petdetails data = new petdetails(dtPetDetails);

        //Fetching pet url
        String strPetUrl = utilities.Helpermethods.getconfig("PetURL");

        //petdetails Object is converted to JSON string.
        Response postCallResponse = utilities.Helpermethods.postoperations(strPetUrl,utilities.Helpermethods.convertingpetdetails(data));
        ResponseBody bodyOfResponse=postCallResponse.getBody();
        Assert.assertTrue(Integer.toString(postCallResponse.statusCode()).equals("200"),"Pet added Successfully");

        scenario.write("Pet with ID:"+bodyOfResponse.jsonPath().getString("id")+" created.");
    }
}