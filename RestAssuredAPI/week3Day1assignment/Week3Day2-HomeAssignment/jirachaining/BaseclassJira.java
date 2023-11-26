package jirachaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseclassJira {
	
	public static String issueid;
	public static String key;
		
	@BeforeMethod
	public void baseclassjira()
	{
		RestAssured.baseURI = "https://vijibalu.atlassian.net/rest/api/2/";
		
		
		
		RestAssured.authentication = RestAssured.preemptive().basic("vijibalu2225@gmail.com", "ATATT3xFfGF0EFQXtExmh_VSDx99Ef6V9sESZwu-Jz_uDorLvRuWfbr0hXqWc5U-ItTPOMtH8nuEGlcBCTz37Zsbl6c9o-f-StfZ-g3W3hKv2Fs6LWSQ6sgvlVag-Bcm1e01DPDOxg9GJ6yq4MLmKFe9soEPpERkNTAqtKtUs05louZ4RiJknPY=F8E26C96");
		
		
	}
	

}
