package jirachaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssue extends BaseclassJira {
	
	@Test
	public void createissue()
	{
		
		RequestSpecification input = RestAssured.given().contentType("application/json")
		.when().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"AP\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"Test Issue -restAssured API Call\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API with Chaining request\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}");
		Response response = input.post("issue");
		response.prettyPrint();
		
		//Extract Issue ID and Key Value
		issueid = response.jsonPath().get("id");
		key = response.jsonPath().get("key");
		
		System.out.println("The Response code of POST is ---"+response.getStatusCode());
		System.out.println("Create Issue is success and the Issue id is ---"+issueid);
		System.out.println("Jira Key Number is ---"+key);
		
		response.then().assertThat().statusCode(Matchers.equalTo(201));
		response.then().assertThat().statusLine(Matchers.containsString("201"));
		response.then().assertThat().body("key", Matchers.containsString("AP"));

		
	}

}
