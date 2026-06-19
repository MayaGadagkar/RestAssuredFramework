package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ResponseSpecificationBuilder;
import io.restassured.response.Response;
import payloads.BookingPayload;
import payloads.BookingTestData;
import responses.BookingData;
import services.BookingService;
import utils.TokenManager;

public class UpdateBookingTest extends BaseTest {
	
	
	BookingService bookingService = new BookingService();
	int bookingId;
	@Test(priority=0)
	//Create a booking and get the booking id
	public void createBookingTest()
	{
		
		BookingPayload bookingPayLoad = BookingTestData.createBookingPayload();
		
		Response response = bookingService.createBooking(bookingPayLoad);
		response
		.then()
		.spec(ResponseSpecificationBuilder.buildResponseSpecification(200));
		bookingId = response.path("bookingid");
	
	}
  @Test (dependsOnMethods = "createBookingTest" , priority=2)
	public void updateBookingTest()
	{
	BookingPayload bookingPayLoad = BookingTestData.updateBookingPayload();
	
	Response response = bookingService.updateBooking(bookingPayLoad, TokenManager.getToken(), bookingId);
			response
	.then()
	.spec(ResponseSpecificationBuilder.buildResponseSpecification(200));
	
	BookingData bookingdata = response.as(BookingData.class);
	System.out.println("The FirstName is :" +bookingdata.getFirstname());
	Assert.assertEquals(bookingdata.getFirstname(), bookingPayLoad.getFirstname());
	Assert.assertEquals(bookingdata.getLastname(), bookingPayLoad.getLastname());
	Assert.assertEquals(bookingdata.getBookingdates().getCheckout(), bookingPayLoad.getBookingdates().getCheckout());
	Assert.assertEquals(bookingdata.getTotalprice(), bookingPayLoad.getTotalprice());
	Assert.assertEquals(bookingdata.isDepositpaid(), bookingPayLoad.isDepositpaid());
	Assert.assertEquals(bookingdata.getAdditionalneeds(), bookingPayLoad.getAdditionalneeds());
	Assert.assertEquals(bookingdata.getBookingdates().getCheckin(), bookingPayLoad.getBookingdates().getCheckin());
	
	}
  
  @Test (dependsOnMethods = "createBookingTest", priority=1)
  public void getBookingTest()
  {
	  Response response = bookingService.getBooking(bookingId);
	  response
	  .then()
	  .spec(ResponseSpecificationBuilder.buildResponseSpecification(200));
	  
	  BookingData bookingdata = response.as(BookingData.class);
	  Assert.assertEquals(bookingdata.getFirstname(), "John");
	  Assert.assertEquals(bookingdata.getLastname(), "Smith");
	  Assert.assertEquals(bookingdata.getBookingdates().getCheckout(), "2023-01-10");
	  Assert.assertEquals(bookingdata.getTotalprice(), 111);
	  Assert.assertEquals(bookingdata.isDepositpaid(), true);
	  Assert.assertEquals(bookingdata.getAdditionalneeds(), "Breakfast");
	  Assert.assertEquals(bookingdata.getBookingdates().getCheckin(), "2023-01-01");
	  Assert.assertNotEquals(bookingdata.getFirstname(), "James");
  }
  
  @Test (dependsOnMethods = "updateBookingTest", priority=3)
  public void deleteBookingTest()
  {
	  Response response = bookingService.deleteBooking(bookingId, TokenManager.getToken());
	  response
	  .then()
	  .spec(ResponseSpecificationBuilder.DeletebuildResponseSpecification(201));
	  
	  //Verify if the booking is deleted
	  Response getResponse = bookingService.getBooking(bookingId);
	  getResponse
	  .then()
	  .spec(ResponseSpecificationBuilder.DeletebuildResponseSpecification(404));
  }
}
