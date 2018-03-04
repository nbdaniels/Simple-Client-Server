import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private static final int PORT = 9191;
	
	public static void main(String[] args) {
		try {
			
			System.out.println("Creating server socket...");
			
			ServerSocket serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName(null));
		
			System.out.println("Created, waiting for connection...");

			Socket socket = serverSocket.accept();
			
			System.out.println("Socket connected, sending message...");
			
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeUTF("Hello, Steve!");
			
			System.out.println("Message sent, cleaning up...");
			
			outputStream.flush();
			outputStream.close();
			
			socket.close();					
		}
		catch (IOException ex) { ex.printStackTrace(); }
		
		System.out.println("SERVER TERMINATING");
	}
}
