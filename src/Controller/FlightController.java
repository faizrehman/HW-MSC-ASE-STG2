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
import Model.Carrier;
import Model.Flight;
import exception.InvalidDataException;

public class FlightController {

	public HashMap<String,Flight> PopulateAllFlight()
	{
		HashMap<String,Flight> fl = new HashMap<String,Flight>();
		
		Carrier carrierData;
		int carrierId=0;
		
		BufferedReader buff=null;
		String data []=new String[4];
		
		try {
		//	buff = new BufferedReader(new FileReader(flightfilePath));
			String inputLine = null;
			while ((inputLine = buff.readLine()) != null) {
				data = inputLine.split(",");
				/* Added by Faisal */
				int variableCount = data.length;
				if (variableCount == 6) {
					continue;
				}

				try {
					
					String FlightCode = flightReference(data[0]);
					//Date FlightDate = parseDate(data[1]);
					String CarrierName = data[2].length() == 0 ? "" : data[2];
					carrierId+=1;
					carrierData = new Carrier(carrierId,CarrierName );
					
					
					String MaxAllowedWeight = data[3].length() == 0 ? "" : data[3];	
					String ExtraChargePerKg = data[4].length() == 0 ? "" : data[4];
					
				//	Flight FlightData=new Flight(FlightCode, FlightDate, carrierData, Integer.parseInt(MaxAllowedWeight), Integer.parseInt(ExtraChargePerKg));
					
					//if (FlightData.IsValidFlightCode(FlightCode)){
						
						//flightList.put(FlightCode, FlightData);
				//	}
					
				} catch (InvalidDataException e) {
					continue;
				} 
				/*catch (ParseException e) {
					continue;
				}*/
			}

		} 
		catch(FileNotFoundException e) {System.out.println(e.getMessage());}
		catch(IllegalArgumentException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Booking found with in valid parametes","Alert", JOptionPane.ERROR_MESSAGE);
			
		}
		catch(IOException e){e.printStackTrace();}
		
		return fl;
	}
	
	private String flightReference(String bookingReference) throws  InvalidDataException {
		if(bookingReference.trim().length() == 0 ) throw new InvalidDataException("Booking Reference Cannot be blank");
		if(!bookingReference.toUpperCase().matches("^[A-Za-z]{3}[0-9]{3}\\z")) throw new InvalidDataException("Booking Reference must be 3 characters followed by 3 digits");
		
		return bookingReference;
		
	}	

	
}
