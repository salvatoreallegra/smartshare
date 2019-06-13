package com.ftd.smartshare.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ftd.smartshare.data.dao.UploadDao;
import com.ftd.smartshare.dto.*;

public class ClientHandler implements Runnable {

	private final Socket clientSocket;

	public ClientHandler(Socket socket) {
		this.clientSocket = socket;
	}

	@Override
	public void run() {

		try {

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			
			JAXBContext context = JAXBContext.newInstance(UploadRequestDto.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			StringReader stringReader = new StringReader(bufferedReader.readLine());

			// Unmarshall stringReader to UploadRequestDto object
			UploadRequestDto upLoadRequest;
			String successMessage; // will be set to true if we write to the database

			upLoadRequest = (UploadRequestDto) unmarshaller.unmarshal(stringReader);

			while (!clientSocket.isClosed()) {

				JAXBContext contextUnmarshall;
				try {
//					contextUnmarshall = JAXBContext.newInstance(UploadRequestDto.class);
//					Marshaller marshaller = contextUnmarshall.createMarshaller();
//					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					// marshaller.marshal(upLoadRequest,out);
//					System.out.println(upLoadRequest.getFileName());
//					System.out.println(upLoadRequest.getPassword());

					UploadDao dao = new UploadDao();
					dao.insertFile(upLoadRequest.getFileName(), upLoadRequest.getFileBytes(),
							upLoadRequest.getTimeTillExpiration(), upLoadRequest.getMaxDownloads(),
							upLoadRequest.getTotalDownloads(), upLoadRequest.getPassword());

					successMessage = "true";
					out.write(successMessage);
					out.flush();
					clientSocket.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					clientSocket.close();
					System.out.println("Lost connection to the client");
				} finally {

				}

			} // end while loop

		} catch (IOException | JAXBException e) {
			e.printStackTrace();
			try {
				clientSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showInputDialog("Client Terminated");
			}

		} // end catch

	} // end run method

} // end class
