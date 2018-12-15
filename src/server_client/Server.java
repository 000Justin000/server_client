package server_client;

// A Java program for a Server 
import java.util.*;
import java.net.*;

public class Server 
{ 
	//initialize socket and input stream 
	private ServerSocket server = null; 

	// constructor with port 
	public Server(int port) throws Exception
	{ 
		// starts server and waits for a connection 
		server = new ServerSocket(port);
	}
	
	public void run() throws Exception
	{
		System.out.println("Server started"); 

        while (true)
        {
		    System.out.println("Waiting for a client ..."); 
		    Socket socket = server.accept(); 
		    System.out.println("Client accepted");
            new Thread(new ClientHandler(socket)).start();
        }		
		
	}

	public static void main(String args[]) 
	{ 
		try
		{
			Server server = new Server(5000);			
			server.run();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	} 
} 

class ClientHandler implements Runnable
{
    private Socket socket;
	private Scanner in = null; 

    /**
     * Create a ClientHandler instance to manage each client and to communicate
     * with that client on behalf of the server.
     */
    ClientHandler(Socket client)
    {
        socket = client;
        System.out.println("New ClientHandler created");
    }

    public void run()
    {
        System.out.println("Running ClientHandler");
    	// takes input from the client socket 
        try
        {
        	in = new Scanner(socket.getInputStream()); 

        	String line = ""; 

        	// reads message from client until "end" is sent 
        	while (!line.equals("end")) 
        	{ 
        		line = in.nextLine(); 
        		System.out.println(line); 
        	} 
        	System.out.println("Closing connection"); 

        	// close connection 
        	socket.close(); 
        	in.close();
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
    }
}