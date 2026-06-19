package config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {
	
	public static RequestSpecification build()
	{
		return new RequestSpecBuilder()
				.setBaseUri(ConfigReader.getBaseURI())
				.setContentType(ContentType.JSON)
				.addHeader("Accept", "application/json")
				.build();
		
			}
	

}
