package tcpclientwordcounter;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientWordCounter {
	
	public static void main(String[] args)
			throws UnknownHostException, IOException {
		
		try {
	
		Socket socket = new Socket(InetAddress.getLocalHost(), 4221);
		
		
		// Read data from network
		DataInputStream dataInputStream = new DataInputStream(
				socket.getInputStream());
		
		// Display the number of words
		int wordAmount = dataInputStream.readInt();
		System.out.println("The amount of words in the sentence is: "
		+ wordAmount);
		
		
		// Close everything
		dataInputStream.close();
		
		} catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}

}
