import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
	private static final int PORT = 9191;
	
	public static void main(String[] args) {
		try {
		
			System.out.println("Creating and connecting socket...");
			
			Socket socket = new Socket(InetAddress.getByName(null), PORT);

			System.out.println("Connected and receiving message...");

			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			String input = inputStream.readUTF();
			
			System.out.println("Received message: " + input);
			
			System.out.println("Message received, cleaning up...");

			inputStream.close();
			
			socket.close();
			
		}
		catch (IOException ex) { ex.printStackTrace(); }
		
		System.out.println("CLIENT TERMINATING");
	}

}
