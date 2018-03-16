package Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import exception.InvalidDataException;


public class DataLoad {
	private HashMap<String,Booking> bookingList;
	private HashMap<String,Flight> flightList;
	
	private String bookingfilePath;
	private String flightfilePath;
	
	public DataLoad(String bookingfilePath,String flightfilePath) {
		super();
		if(bookingfilePath.trim().length() == 0 || flightfilePath.trim().length() == 0) 
		{
			
			throw new IllegalArgumentException("the files path Cannot be blank");
		}
		this.bookingfilePath=bookingfilePath;
		this.flightfilePath=flightfilePath;
	}
	
	public HashMap<String,Booking> getBookingList()
	{
		return this.bookingList;
	}
	
	public void setBookingList(HashMap<String,Booking> bookingList)
	{
		this.bookingList = bookingList;
		
	}
	
	public HashMap<String,Flight>  getFlightList()
	{
		return this.flightList;
	}
	
	public void setFlightList(HashMap<String,Flight> flightList)
	{
		this.flightList = flightList;
		
	}
		
}
