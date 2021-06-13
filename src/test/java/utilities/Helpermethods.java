package utilities;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageobject.petdetails;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jodd.props.Props;


public class Helpermethods {
	public static Response operationResponse;
    public static RequestSpecification Request;
    
    // POST Operations
    public static Response postoperations(String url,String strBody){
        operationResponse = given()
                .contentType(ContentType.JSON)
                .with()
                .body(strBody)
                .when()
                .post(url);
        System.out.println("Post operation performed with Status Code:"+operationResponse.statusCode());
        Assert.assertTrue(Integer.toString(operationResponse.statusCode()).equals("200"),"Verifying post request returns status code 200");
        System.out.println("Post operation performed with Status Line:"+operationResponse.statusLine());
        Assert.assertTrue(operationResponse.statusLine().equals("HTTP/1.1 200 OK"),"Verifying post request returns status Line HTTP/1.1 200 OK");
        return operationResponse;
    }
    
    //GET operations
    public static Response Getoperation(String strParam,Map<String,String> pathParam,String strUrl){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(strUrl);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec=builder.build();

        Request = RestAssured.given().spec(requestSpec);
        Request.pathParams(pathParam);
        operationResponse = Request.get("/{"+strParam+"}");

        System.out.println("Get operation performed with Status Code:"+operationResponse.statusCode());
        Assert.assertTrue(Integer.toString(operationResponse.statusCode()).equals("200"),"Verifying the request returns status code 200");
        System.out.println("Get operation performed with Status Line:"+operationResponse.statusLine());
        Assert.assertTrue(operationResponse.statusLine().equals("HTTP/1.1 200 OK"),"Verifying the request returns status Line HTTP/1.1 200 OK");
        return operationResponse;
    }

    public static Response Getoperationnotfound(Map<String,String> pathParam,String strUrl){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(strUrl);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec=builder.build();

        Request = RestAssured.given().spec(requestSpec);
        Request.pathParams(pathParam);
        operationResponse = Request.get("/{id}");

        System.out.println("Get operation performed with Status Code:"+operationResponse.statusCode());
        Assert.assertTrue(Integer.toString(operationResponse.statusCode()).equals("404"),"Verifying the request returns status code 404");
        System.out.println("Get operation performed with Status Line:"+operationResponse.statusLine());
        Assert.assertTrue(operationResponse.statusLine().equals("HTTP/1.1 404 Not Found"),"Verifying the request returns status Line HTTP/1.1 404 Not Found");
        return operationResponse;
    }
    
    // Converting Petdeatils to Json
    public static String convertingpetdetails(petdetails petDetailsObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String convert = mapper.writeValueAsString(petDetailsObject);
            convert=convert.replaceAll("strId","id");
            convert=convert.replaceAll("strName","name");
            convert=convert.replaceAll("strStatus","status");
            convert=convert.replaceAll("strPhoto_Url","photoUrls");
            convert=convert.replaceAll("arrTagDetails","tags");
            convert=convert.replaceAll("strTagId","id");
            convert=convert.replaceAll("strTagName","name");
            convert=convert.replaceAll("objCategoryDetails","category");
            convert=convert.replaceAll("strCategoryId","id");
            convert=convert.replaceAll("strCategoryName","name");
            return convert;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getconfig(String PropertyName) {
        Props p = new Props();
        File configFile = new File("src\\test\\java\\Configuration\\Config.properties");
        try {
            p.load(new File(configFile.getAbsolutePath()));
        }
        catch(Exception e) {
         e.printStackTrace();
        }
        return p.getValue(PropertyName);
    }
    
    //Delete operation.
    public static Response deleteoperation(Map<String,String> pathParam,String strUrl){

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(strUrl);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec=builder.build();

        Request = RestAssured.given().spec(requestSpec);
        Request.pathParams(pathParam);
        operationResponse = Request.delete("/{id}");

        System.out.println("Delete operation performed with Status Code:"+operationResponse.statusCode());
        Assert.assertTrue(Integer.toString(operationResponse.statusCode()).equals("200"),"Verifying delete request returns status code 200");
        System.out.println("Delete operation performed with Status Line:"+operationResponse.statusLine());
        Assert.assertTrue(operationResponse.statusLine().equals("HTTP/1.1 200 OK"),"Verifying delete request returns status Line HTTP/1.1 200 OK");
        return operationResponse;
    }
    
    public static Response Getoperationbystatus(String strParam,Map<String,String> pathParam,String strUrl){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(strUrl);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec=builder.build();

        Request = RestAssured.given().spec(requestSpec);
        Request.pathParams(pathParam); 
        operationResponse = Request.get("?status={"+strParam+"}");

        System.out.println("Get operation performed with Status Code:"+operationResponse.statusCode());
        Assert.assertTrue(Integer.toString(operationResponse.statusCode()).equals("200"),"Verifying get request returns status code 200");
        System.out.println("Get operation performed with Status Line:"+operationResponse.statusLine());
        Assert.assertTrue(operationResponse.statusLine().equals("HTTP/1.1 200 OK"),"Verifying get request returns status Line HTTP/1.1 200 OK");
        return operationResponse;
    }



}
