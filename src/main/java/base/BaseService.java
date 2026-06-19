package base;

import config.RequestSpecificationBuilder;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	protected RequestSpecification request()
	{
		return given().spec(RequestSpecificationBuilder.build());
				
	}
	
	
}
