package client;

import base.BaseService;
import io.restassured.response.Response;

public class APIClient extends BaseService {

	public Response executePost(String endpoint, Object payload)
	{
		return request()
				.body(payload)
				.when()
				.post(endpoint);
	}
	
	public Response executePut(String endpoint, Object payload, String token)
	{
		return request()
				.body(payload)
				.cookie("token", token)
				.when()
				.put(endpoint);
	}
	
	public Response executeGet(String endpoint)
	{
		return request()
				.when()
				.get(endpoint);
	}
	
	public Response executeDelete(String endpoint, String token)
	{
		return request()
				.cookie("token", token)
				.when()
				.delete(endpoint);
	}
}
