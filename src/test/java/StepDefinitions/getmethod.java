package StepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class getmethod {

    private Scenario scenario;
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Then("Using GET operation with pet ID to verify the details are added correctly")
    public void getoperationtoverifydetails(DataTable dtPetDetails) {

        List<Map<String,String>> petDetails = dtPetDetails.asMaps(String.class,String.class);
        Map<String,String> pathParam = new HashMap<>();
        pathParam.put("id",petDetails.get(0).get("Id"));

        //Fetching pet url 
        String strPetUrl = utilities.Helpermethods.getconfig("PetURL");

        Response getCallResponse = utilities.Helpermethods.Getoperation("id",pathParam,strPetUrl);
        ResponseBody bodyOfResponse=getCallResponse.getBody();

        //Verifying details returned from GET operation.
        Assert.assertEquals(bodyOfResponse.jsonPath().getString("name"),petDetails.get(0).get("Name"));
        Assert.assertEquals(bodyOfResponse.jsonPath().getString("status"),petDetails.get(0).get("Status"));

        scenario.write("Verified id:" +petDetails.get(0).get("Id")+ " is updated with values, name:"+ petDetails.get(0).get("Name") +" ,status:" +petDetails.get(0).get("Status"));
    }
    
    @Given("^Using GET operation to check status of pet.$")
    public void getoperationtocheckstatus(DataTable dtPetDetails) {
    	
    	List<Map<String,String>> petDetails = dtPetDetails.asMaps(String.class,String.class);
        Map<String,String> pathParam = new HashMap<>();
        pathParam.put("status",petDetails.get(0).get("status"));
    	String strPetUrl = utilities.Helpermethods.getconfig("PetStatus");
    	Response getCallResponse = utilities.Helpermethods.Getoperationbystatus("status",pathParam,strPetUrl);
        ResponseBody bodyOfResponse=getCallResponse.getBody();
        
        scenario.write("Verified Response of status:" +petDetails.get(0).get("status"));

     }
    

    @Then("^To verify the pet ID and to check data is removed.$")
    public void idtocheckdataisremoved(DataTable dtPetDetails) {
        List<Map<String,String>> petDetails = dtPetDetails.asMaps(String.class,String.class);
        Map<String,String> pathParam = new HashMap<>();
        pathParam.put("id",petDetails.get(0).get("Id"));

        //Fetching pet url 
        String strPetUrl = utilities.Helpermethods.getconfig("PetURL");

        Response myResponse = utilities.Helpermethods.Getoperationnotfound(pathParam,strPetUrl);

        //404 returned when no records fetched.
        Assert.assertTrue(Integer.toString(myResponse.statusCode()).equals("404"),"Pet not exists.");
        scenario.write("Pet with ID:"+petDetails.get(0).get("Id")+" is not present.");
    }
}
    