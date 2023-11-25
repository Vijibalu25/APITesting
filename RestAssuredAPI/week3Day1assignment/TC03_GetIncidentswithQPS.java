package week3Day1assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC03_GetIncidentswithQPS {
	
	@Test
	
	public void getInicdentsQPS()
	{
		RestAssured.baseURI="https://dev89025.service-now.com/api/now/table/";
		
		RestAssured.authentication = RestAssured.basic("admin", "X9%V9Aak%kdK");
		
		Response response = RestAssured.given()
		.queryParam("sysparm_fields", "short_description,description,sys_id,number")
		.queryParam("sysparm_limit", "4")
		.get("incident");
		
        response.prettyPrint();
		
		System.out.println("The status code is -----"+response.getStatusCode());
		System.out.println("The status code is -----"+response.getStatusLine());
	}

}
