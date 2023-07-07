package Exercise_7;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;

public class RainfallDataReader_2nd {
	
	public static void main(String[] args) {
		
		
        String inFile = "rainfallData2.txt";

        try (Reader reader = new FileReader(inFile);
        		
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
            	
                System.out.println(line);
            }
            
        } catch (IOException e) {
        	
        	//error message
            System.out.println("An error occurred while reading the file.");
            
            e.printStackTrace();
        }
    }

}
