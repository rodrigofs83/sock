package com.gugawag.so.ipc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/**
 * Client program requesting current date from server.
 *
 * Figure 3.22
 *
 * @author Silberschatz, Gagne and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Eighth Edition
 */
import java.net.Socket;

public class DateClient {
	public static void main(String[] args)  {
		try {
			// this could be changed to an IP name or address other than the localhost
			Socket sock = new Socket("localhost",6013);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			 // Obtain the output stream
            OutputStream outStr = sock.getOutputStream();
			System.out.println("=== Cliente iniciado ===\n");

			String line = bin.readLine();
			System.out.println("O servidor me disse:" + line);
			 //   messagem para server
			 String messageToServer = "Eu sou Rodrigo F Silva";
			 outStr.write(messageToServer.getBytes());
			 outStr.flush(); 
			sock.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
