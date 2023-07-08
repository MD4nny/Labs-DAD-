package tcpserverwordcounter;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverWordCounter {
	
public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		try {
		
			//port number
			int portNo = 4221;
			
			//server socket
			serverSocket = new ServerSocket(portNo);
			
			// Generate a welcome sentence
			int wordAmount = WordCounter.countWordAmount(
					"Hello There!");
			
			// Server needs to be alive forever
			System.out.println(wordAmount);
			while (true) {

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();

				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());

				// Send current data back to the client
				outputStream.writeInt(wordAmount);

				// Close the socket
				clientSocket.close();

			}
		} catch (IOException ioe) {
			
			if(serverSocket !=null)
				
				serverSocket.close();
			
			ioe.printStackTrace();
		}
		

	}

}
