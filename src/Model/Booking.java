package Model;

import java.util.Date;

import exception.*;
public class Booking {
	
	
	private String  BookingReference;
	private Date    BookingDate;
    private Passenger passenger;
	private Flight  flight;
	
	
	private boolean CheckIn;
	private Date  CheckInTime;

	private Integer CheckedInWeight;
	private String  BaggageDimension;
	
	
	
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}
	public boolean isCheckIn() {
		return CheckIn;
	}
	public void setCheckIn(boolean checkIn) {
		CheckIn = checkIn;
	}
	
	public Date getCheckInTime() {
		return CheckInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		CheckInTime = checkInTime;
	}
	public void setBookingReference(String bookingReference) {
		BookingReference = bookingReference;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	


	public Booking(String BookingReference,Date BookingDate, Passenger PassengerData,
			Flight flight) throws IllegalArgumentException
	{
		
		/* Added by Faisal*/
		if(BookingReference.trim().length() == 0 || PassengerData == null
				|| flight == null) 
		{			
			throw new IllegalArgumentException("Booking Reference, Passenger Name & Flight Code Cannot be blank");
		}	
		
		this.BookingReference = BookingReference;
		this.BookingDate = BookingDate;
		this.passenger = PassengerData;
		this.flight = flight;
		
				
	}
	public boolean IsCheckedIn() {		
		return CheckIn;
		
	}
	
	
	


	
	public String getBookingReference() {		
		return BookingReference;
		
	}
	public Passenger getPassenger() {		
		return passenger;
		
	}
	
	
	public Integer getCheckedInWeight() {
		return CheckedInWeight;
	}
/*Added By Faisal*/
	public void setCheckedInWeight(Integer checkedInWeight) throws InValidCheckInException {
		
			if(checkedInWeight == 0)
			{
				throw new InValidCheckInException();
			}			
			else
			{
				CheckedInWeight = checkedInWeight;
			
			}
	}

	public String getBaggageDimension() {
		return BaggageDimension;
	}

	public void setBaggageDimension(String baggageDimension) {
		
		BaggageDimension = baggageDimension;
	}
	
	

	

}
