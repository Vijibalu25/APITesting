package jirachaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class UpdateIssue extends BaseclassJira{
	
	@Test(dependsOnMethods="jirachaining.CreateIssue.createissue")
	public void updateissue()
	{
		
		
		RequestSpecification input = RestAssured.given().contentType("application/json")
		.when().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"description\": \"Bug creation Using REST API for testing - PUT Request(Chaning Request)\"\r\n"
				+ "    }\r\n"
				+ "}");
		
		Response response = input.put("issue/"+issueid);
		
		
		String asPrettyString = response.asPrettyString();
		
		System.out.println("Update Issue is success and the Issue id is ---"+issueid);
		System.out.println("Jira Key Number is ---"+key);
	
		
		System.out.println("The Response code of PUT is ---"+response.getStatusCode());
		
		//Assertion
		response.then().assertThat().statusCode(Matchers.equalTo(204));
		
		
	}
}
