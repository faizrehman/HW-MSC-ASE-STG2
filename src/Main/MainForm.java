package Main;
import java.awt.EventQueue;
import Controller.BookingController;
import Controller.FlightController;
import Model.DataLoad;
import View.CounterGUI;

public class MainForm {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				//	Passenger model = new Passenger();

					ClassLoader classLoader = getClass().getClassLoader();	
					String bookingsPath = classLoader.getResource("Bookings.txt").getPath();
					String flightsPath  = classLoader.getResource("FlightsInfo.txt").getPath();					
					
					BookingController bController = new BookingController();
					FlightController fController = new FlightController();
					DataLoad dModel = new DataLoad(bookingsPath,flightsPath);					
					CounterGUI frame = new CounterGUI();				
					
					dModel.setBookingList(bController.PopulateAllBookings());
					dModel.setFlightList(fController.PopulateAllFlight());				
					frame.setVisible(true); 
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
