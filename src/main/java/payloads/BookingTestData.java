package payloads;

public class BookingTestData {
	
	public static BookingPayload createBookingPayload()
	{
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2023-01-01");
		bookingdates.setCheckout("2023-01-10");
		
		BookingPayload bookingpayload = new BookingPayload();
		bookingpayload.setFirstname("John");
		bookingpayload.setLastname("Smith");
		bookingpayload.setTotalprice(111);
		bookingpayload.setDepositpaid(true);
		
		
		bookingpayload.setBookingdates(bookingdates);
		
		bookingpayload.setAdditionalneeds("Breakfast");
		return bookingpayload;
	}

	public static BookingPayload updateBookingPayload()
	{
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2024-01-01");
		bookingdates.setCheckout("2024-01-10");
		
		BookingPayload bookingpayload = new BookingPayload();
		bookingpayload.setFirstname("James");
		bookingpayload.setLastname("Smith");
		bookingpayload.setTotalprice(150);
		bookingpayload.setDepositpaid(false);
		
		
		bookingpayload.setBookingdates(bookingdates);
		
		bookingpayload.setAdditionalneeds("Lunch");
		return bookingpayload;
		
	}
}
