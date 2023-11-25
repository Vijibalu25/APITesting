package week3Day1assignment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_CreateIncidentwithFileBody {
	
	@Test
	public void create() {
		
		RestAssured.baseURI="https://dev89025.service-now.com/api/now/table/";
		
		RestAssured.authentication = RestAssured.basic("admin", "X9%V9Aak%kdK");
		
		File file = new File("./src/test/resources/CreateIncident.json");
		
		RequestSpecification input = RestAssured.given().contentType("application/json")
		.when()
		.body(file);
		
		Response response = input.post("incident");
		
		response.prettyPrint();
		
		System.out.println("The status code is -----"+response.getStatusCode());
		System.out.println("The status code is -----"+response.getStatusLine());
			
	}

}
