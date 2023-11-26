package jirachaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue extends BaseclassJira {
	
	@Test(dependsOnMethods="jirachaining.UpdateIssue.updateissue")
	
	public void deleteissue()
	{
		Response response = RestAssured.delete("issue/"+issueid);
		
		System.out.println("The Response code of DELETE is ---"+response.getStatusCode());
		System.out.println(issueid);
	}

}
