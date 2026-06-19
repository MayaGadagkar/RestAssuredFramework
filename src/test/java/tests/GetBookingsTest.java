package tests;

import base.BaseTest;
import config.ResponseSpecificationBuilder;
import constants.Constants;
import endpoints.APIEndPoints;
import io.restassured.RestAssured;

public class GetBookingsTest extends BaseTest {
	
	@org.testng.annotations.Test
	public void getBookingsTest()
	{
		RestAssured 
		.given()
		.when()
		.get(APIEndPoints.BOOKING +"/1")
		.then()
		.spec(ResponseSpecificationBuilder.buildResponseSpecification(200))
		.statusCode(Constants.OK_CODE);
	}

}
