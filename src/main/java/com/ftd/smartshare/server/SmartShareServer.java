package com.ftd.smartshare.server;

import java.io.*;
import java.net.*;

public class SmartShareServer {

	public static void main(String[] args) {

		ServerSocket server;

		System.out.println("Server started");

		try {
			server = new ServerSocket(3000);
			while (true) {

				Socket client = server.accept();
				System.out.println("New Client Connected");
				String hostName = client.getInetAddress().getHostName();
				System.out.println(hostName);
				ClientHandler clientSocket = new ClientHandler(client);
				new Thread(clientSocket).start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
