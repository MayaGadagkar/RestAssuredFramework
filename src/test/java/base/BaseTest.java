package base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import config.RequestSpecificationBuilder;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	protected RequestSpecification requestspec;
	
	@BeforeClass
	public void setup()
	{
		requestspec = RequestSpecificationBuilder.build();
		RestAssured.requestSpecification = requestspec;
	}

	@AfterClass
	public void tearDown()
	{
		requestspec = null;
	}
}
