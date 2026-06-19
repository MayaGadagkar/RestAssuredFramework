
  package tests;
  
  import org.testng.Assert; import org.testng.annotations.Test;
  
  import base.BaseTest; import config.ResponseSpecificationBuilder; import
  io.restassured.response.Response; import payloads.BookingPayload; import
  payloads.BookingTestData; import responses.BookingResponse; import
  services.BookingService;
  
  public class CreateBookingTest extends BaseTest {
  
  BookingService bookingService = new BookingService(); BookingPayload
  bookingPayLoad = new BookingPayload();
  
  @Test public void createBookingTest() {
  
  BookingPayload bookingPayLoad = BookingTestData.createBookingPayload();
  
  Response response = bookingService.createBooking(bookingPayLoad);
  response.then()
  .spec(ResponseSpecificationBuilder.buildResponseSpecification(200))
  .extract() .response(); BookingResponse bookingresponse=
  response.as(BookingResponse.class); System.out.println("Booking id is :" +
  bookingresponse.getBookingid()); System.out.println("First name is :" +
  bookingresponse.getBooking().getFirstname());
  Assert.assertEquals(bookingresponse.getBooking().getFirstname(),
  bookingPayLoad.getFirstname());
  Assert.assertEquals(bookingresponse.getBooking().getLastname(),
  bookingPayLoad.getLastname()); } }
 