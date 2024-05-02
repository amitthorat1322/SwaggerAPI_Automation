package ls;


public class BookingPojo {
	
	
	 	private String firstname;
	    private String additionalneeds;
	    private BookingDetails bookingdates;
		private int totalprice;
	    private boolean depositpaid;
	    private String lastname;


	
	    public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getAdditionalneeds() {
			return additionalneeds;
		}
		public void setAdditionalneeds(String additionalneeds) {
			this.additionalneeds = additionalneeds;
		}
		public BookingDetails getBookingdates() {
			return bookingdates;
		}
		public void setBookingdates(BookingDetails bookingdates) {
			this.bookingdates = bookingdates;
		}
		public int getTotalprice() {
			return totalprice;
		}
		public void setTotalprice(int tprice) {
			this.totalprice = tprice;
		}
		public boolean getDepositpaid() {
			return depositpaid;
		}
		public void setDepositpaid(boolean dpaid) {
			this.depositpaid = dpaid;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		/*
		 * public BookingPojo (String fname,String lname,String aneeds, int
		 * tprice,boolean dpaid,BookingDetails bdates) {
		 * 
		 * setFirstname(fname); setLastname(lname); setAdditionalneeds(aneeds);
		 * setTotalprice(tprice); setDepositpaid(dpaid); setBookingdates(bdates); }
		 */
}
