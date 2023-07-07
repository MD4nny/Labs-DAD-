package Exercise_5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainfallDataGenerator {

	public static void main(String[] args) {
		
		//create text file
		String outFile = "rainFallData.txt";
		
		//date
		String dates[]= {"13/06/2023","14/06/2023","15/06/2023","16/06/2023",
				"17/06/2023","18/06/2023"};
		
		//rain data
		double rainfallAmount[]= {0.0,3.0,1.0,0.0,0.0,2.0};
		
		try {
			
			//Create stream to read data
			DataOutputStream dos = new DataOutputStream(
					new FileOutputStream(outFile));
			
			
			//Process data
			for (int index = 0; index < dates.length; index++) {
				
				//Write data into data stream
				dos.writeUTF(dates[index]);
				dos.writeDouble(rainfallAmount[index]);
				
				//Flush for each writing
				dos.flush();
			}
			
			//Close stream
			dos.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program
		// Appearance of message could means success
		System.out.println("End of program. Check out " + outFile); 
	}

}
