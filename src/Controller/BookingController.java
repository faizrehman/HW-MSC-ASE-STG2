package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Model.Booking;
import Model.Flight;
import Model.Passenger;
import exception.InValidCheckInException;
import exception.InvalidDataException;

public class BookingController {

	
	/*Added By Faisal*/
	public void SetCheckedIn(Integer CheckedInWeight,String BaggageDimension ) throws InValidCheckInException
	{			
	

			Integer length,breadth,height;
		if(BaggageDimension.matches("\\d{2}x\\d{2}x\\d{2}"))
		{
			String[] dimension=BaggageDimension.split("x");
		 	length =Integer.parseInt(dimension[0]); // l
			breadth =Integer.parseInt(dimension[1]); // b
			height =Integer.parseInt(dimension[2]); // h 
			
			if(length > 20 || breadth > 20 || height > 20 || CheckedInWeight > 100)
			{

				throw new InValidCheckInException();
			}
			else
			{	this.CheckIn=true;
			this.CheckedInWeight=CheckedInWeight;
			this.BaggageDimension=BaggageDimension;
			}
		}
		else
		{

			throw new InValidCheckInException();
		}
			
					
				
	}
	
	public Booking IsValidBooking(String BookingReference,String PassengerLName) throws  IllegalStateException
	{		
		if(BookingReference.trim().length()==0 || !BookingReference.toUpperCase().matches("^[A-Za-z]{3}[0-9]{3}\\z"))
		{
			throw new IllegalStateException("Booking Reference must be 3 characters followed by 3 digits");
			
		}
		
			/* Modified by Amer*/
			if (this.IsCheckedIn()==false) {
				
			if(this.getPassenger().getPassengerLName().toLowerCase().equals(PassengerLName.toLowerCase()))
			{
				return this;		
			}
			else
			{
				throw new IllegalStateException("Not a valid passenger name");
			}}else
			{
				throw new IllegalStateException("passenger has already checked-in");
			}
		
		
		
	}
	/* Added by Amer*/
	public boolean  IsValidBookingReference(String BookingReference) throws  IllegalStateException
	{		
		if(BookingReference.trim().length()==0 || !BookingReference.toUpperCase().matches("^[A-Za-z]{3}[0-9]{3}\\z"))
		{
			throw new IllegalStateException("Booking Reference must be 3 characters followed by 3 digits");
			
		}
		
		
		return true;
		
	}
	
	public HashMap<String,Booking> PopulateAllBookings() {

		HashMap<String,Booking> bk = new HashMap<String,Booking>();
		int PassengerId = 0;
		BufferedReader buff = null;
		String data[] = new String[4];
		Passenger PassengerData;
		
		try {
		//	buff = new BufferedReader(new FileReader(bookingfilePath));
			String inputLine = null;
			while ((inputLine = buff.readLine()) != null) {
				data = inputLine.split(",");
				/* Added by Faisal */
				int variableCount = data.length;
				if (variableCount == 10) {
					

				try {
					String bookingReference = bookingReference(data[0]);
					//Date   bookingDate = parseDate(data[1]);

					String  PassengerFName = data[2].length() == 0 ? "" : data[2];
					String  PassengerLName = data[3].length() == 0 ? "" : data[3];
					String  Passport = data[4].length() == 0 ? "" : data[4];
					String  address= data[5].length() == 0 ? "" : data[5];
				    String  mobileNumber= data[6].length() == 0 ? "" : data[6];
				//	Date    DOB=parseDate(data[7]);
					
					
					PassengerId+=1;
					PassengerData = new Passenger(PassengerId, Passport, PassengerFName, PassengerLName, address, mobileNumber, DOB);
					
					//String FlightCode = flightReference(data[8]);
					//Date FlightDate = parseDate(data[9]);
					//Flight FlightData=new Flight(FlightCode, FlightDate);
					
					
					//Booking newBooking = new Booking(bookingReference, bookingDate,PassengerData,FlightData);
				
					//if (newBooking.IsValidBookingReference(bookingReference)){
						
					// bookingList.put(bookingReference, newBooking);
					//}
					
				} catch (InvalidDataException e) {
					continue;
				} catch (ParseException e) {
					continue;
				}
			}
				else 
				{
				continue;
			}

		} 
		} 
		catch(FileNotFoundException e) {System.out.println(e.getMessage());}
		catch(IllegalArgumentException e) 
		{

			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Booking found with in valid parametes","Alert", JOptionPane.ERROR_MESSAGE);
	
			
		}
		catch(IOException e){e.printStackTrace();}

		return bk;
		
	}

	private String bookingReference(String bookingReference) throws  InvalidDataException {
		if(bookingReference.trim().length() == 0 ) throw new InvalidDataException("Booking Reference Cannot be blank");
		if(!bookingReference.toUpperCase().matches("^[A-Za-z]{3}[0-9]{3}\\z")) throw new InvalidDataException("Booking Reference must be 3 characters followed by 3 digits");
		
		return bookingReference;
		
	}
	
}
