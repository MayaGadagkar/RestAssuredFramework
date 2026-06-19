package services;

import client.APIClient;
import endpoints.APIEndPoints;
import io.restassured.response.Response;
import payloads.BookingPayload;

public class BookingService  {
	
	APIClient apiClient = new APIClient();
	
	public Response createBooking(BookingPayload payload)
	
	{
		return apiClient.executePost(APIEndPoints.BOOKING.path(), payload);
				
	}

	public Response updateBooking(BookingPayload payload, String token, int bookingId)
	
	{
		return apiClient.executePut(APIEndPoints.BOOKING.path() + "/" + bookingId, payload, token);
	}
		
	public Response getBooking(int bookingId)
	{
		return apiClient.executeGet(APIEndPoints.BOOKING.path() + "/" + bookingId);
	}
	
	public Response deleteBooking(int bookingId, String token)
	{
		return apiClient.executeDelete(APIEndPoints.BOOKING.path() + "/" + bookingId, token);
	}
}
