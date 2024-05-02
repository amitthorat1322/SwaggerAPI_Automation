package ls;

public class BookingDTO {

	private String bookingid;
	
	private BookingPojo booking;
	
    public String getBookingid ()
    {
        return bookingid;
    }

    public void setBookingid (String bookingid)
    {
        this.bookingid = bookingid;
    }

	public BookingPojo getBooking() {
		return booking;
	}

	public void setBooking(BookingPojo booking) {
		this.booking = booking;
	}
}
