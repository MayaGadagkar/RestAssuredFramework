package config;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationBuilder {
	
	public static ResponseSpecification buildResponseSpecification(int statusCode)
	{
		return new ResponseSpecBuilder()
		.expectContentType("application/json")
				//.expectContentType("text/plain; charset=utf-8")
		.expectStatusCode(statusCode)
		.build();
	}

	public static ResponseSpecification  DeletebuildResponseSpecification(int statusCode)
	{
		return new ResponseSpecBuilder()
				.expectStatusCode(statusCode)
				.build();
	}
}
