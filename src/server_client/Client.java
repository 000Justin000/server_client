package server_client;

// A Java program for a Client 
import java.util.*;
import java.net.*;
import java.io.*; 

public class Client 
{ 
	// initialize socket and input output streams 
	private Socket socket = null; 
	private Scanner input = null; 
	private PrintStream out = null; 

	// constructor to put ip address and port 
	public Client(String address, int port) throws Exception
	{ 
		// establish a connection 
		socket = new Socket(address, port); 
		System.out.println("Connected"); 
	} 

	public void run() throws Exception
	{
		// takes input from terminal 
		input = new Scanner(System.in); 

		// sends output to the socket 
		out = new PrintStream(socket.getOutputStream()); 

		// string to read message from input 
		String line = ""; 

		// keep reading until "end" is input 
		while (!line.equals("end")) 
		{ 
			line = input.nextLine(); 
			out.println(line); 
		} 

		input.close();
		out.close();
		socket.close();
	}
	
	public static void main(String args[]) 
	{
		try
		{
			Client client = new Client("127.0.0.1", 5000);
			client.run();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	} 
} 
