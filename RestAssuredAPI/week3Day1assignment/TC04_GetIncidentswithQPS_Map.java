package week3Day1assignment;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC04_GetIncidentswithQPS_Map {
	
	
	@Test
	public void getIncidentswithQPS()
	{
		RestAssured.baseURI = "https://dev89025.service-now.com/api/now/table/";
		
		RestAssured.authentication = RestAssured.basic("admin", "X9%V9Aak%kdK");
		
		Map<String,String> queryParameters=new HashMap<String,String>();
		queryParameters.put("sysparm_fields", "short_description,description,sys_id,number");
		queryParameters.put("sysparm_limit", "5");
		
		Response response = RestAssured.given()
		.queryParams(queryParameters)
		.get("incident");
		
		response.prettyPrint();
		
		System.out.println("The status code is ------:"+response.getStatusCode());
		System.out.println("The Status line is ------:"+response.getStatusLine());
		
	}

}
