package utils;

import endpoints.APIEndPoints;
import io.restassured.RestAssured;

public class TokenManager {

	public static String getToken()
	{
		//code to generate token
		String token = RestAssured
				.given()
				.body("""
						{
							"username": "admin",
							"password": "password123"
						}
						""")
				.when()
				.post(APIEndPoints.AUTH.path())
				.then()
				.extract()
				.path("token");
		return token;
}
}