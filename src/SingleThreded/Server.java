package SingleThreded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public void run() throws IOException
	{
		int port=8010;
		
		ServerSocket serverSocket =  new ServerSocket(port);
		serverSocket.setSoTimeout(20000);
		
		while(true)
		{
		    System.out.println("Server is listening on port: "+port);
		    Socket acceptedConnection = serverSocket.accept();
		    System.out.println("Connected to "+acceptedConnection.getRemoteSocketAddress());
		    PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(),true);
		    BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
		    toClient.println("Hello World from the server");
		    
		    toClient.close();
		    fromClient.close();
		    acceptedConnection.close();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Server server = new Server();
		
		server.run();
	}
	
	
}
