package Exercise_5;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class RainfallDataReader {

	public static void main(String[] args) {
		
		//Declare Output File
		String sourceFile = "rainfallData.txt";
		System.out.println("Reading the data from " + sourceFile + " file " 
		+ "\n");
		
		try {
			
			//Create stream to read data
			DataInputStream dis = new DataInputStream(
					new FileInputStream(sourceFile));
			
			//Create variables for processing byte data
			double rainFallAmount = 0;
			double totalrainFall = 0;
			int recordsNo = 0;
			String date = "";
			
			//Process data until end-of-file
			while (dis.available()>0) {
				
				//Read data
				date = dis.readUTF();
				rainFallAmount = dis.readDouble();
				System.out.print(date + "\t" + rainFallAmount + "\n");
				
				//Calculate the total utilization
				totalrainFall += rainFallAmount;
				recordsNo ++;
			}
			
			//Close stream
			dis.close();
			
			//Calculate the average of utilization
			double averageRainfall = totalrainFall / recordsNo;
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.print("\nAverage rainfall for " + recordsNo 
					+ " date: " + formattedAverage);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program
		// Appearance of message means success
		System.out.println("\nEnd of program. "); 
	}
}
