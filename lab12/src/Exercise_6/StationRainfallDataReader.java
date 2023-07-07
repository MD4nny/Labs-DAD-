package Exercise_6;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class StationRainfallDataReader {
	
	public static void main(String[] args) {
		
		
		//districts
		String districts[]= {"Alor Gajah","Durian Tunggal","Melaka Tengah"};
		
		//stations
		String stations[]= {"Durian Tunggal","Melaka Pindah","Telok Rimba",
				"Chohong","Klebang Besar","Batu Hampar"};
		
		int districtsNo=0;
		int totalRecordsNo=0;
		
		for(String station: stations)
		try {
			
			String fileName = station + ".txt";
			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(
					new FileInputStream(fileName));

			// Variables for processing byte-based data
			double rainfallAmount = 0;
			double totalRainfall = 0;

			int noOfRecords = 0;
			String date = "";
			System.out.println("District: "+districts[districtsNo]);
			System.out.println("Station: "+station);
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				date = dis.readUTF();
				rainfallAmount = dis.readDouble();
				System.out.println( date + "\t" + rainfallAmount);
				
				// Calculate total rainfall
				totalRainfall += rainfallAmount;
				noOfRecords ++;
				totalRecordsNo ++;
				if(totalRecordsNo%12==0) {
					districtsNo++;
				}
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate average rainfall
			double averageRainfall = totalRainfall / 6;
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.println("Average rainfall for " + noOfRecords 
					+ " Days: " + formattedAverage + "\n\n");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program
		// Appearance of message could means success
		System.out.println("\nEnd of program.");
		}

}
