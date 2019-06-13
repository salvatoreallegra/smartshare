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

import com.ftd.smartshare.data.dao.DownloadDao;
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

			JAXBContext context = JAXBContext.newInstance(UploadRequestDto.class, DownloadRequestDto.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			StringReader stringReader = new StringReader(bufferedReader.readLine());

			// Unmarshall stringReader to UploadRequestDto object
			// QuoteRequest quoteRequest = (QuoteRequest)
			// unmarshaller.unmarshal(stringReader);

			String successMessage; // will be set to true if we write to he database

			Object request = (Object) unmarshaller.unmarshal(stringReader);
			if (request instanceof UploadRequestDto) {

				while (!clientSocket.isClosed()) {

					JAXBContext contextUnmarshall;
					try {

						UploadDao dao = new UploadDao();
						dao.insertFile(((UploadRequestDto) request).getFileName(),
								((UploadRequestDto) request).getFileBytes(),
								((UploadRequestDto) request).getTimeTillExpiration(),
								((UploadRequestDto) request).getMaxDownloads(),
								((UploadRequestDto) request).getTotalDownloads(),
								((UploadRequestDto) request).getPassword());

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
			} // end if

			// end catch

			else if (request instanceof DownloadRequestDto) {

				while (!clientSocket.isClosed()) {

					JAXBContext contextUnmarshall;
					try {
						
//						DownloadDao dao = new DownloadDao();
//						dao.insertFile(upLoadRequest.getFileName(), upLoadRequest.getFileBytes(),
//								upLoadRequest.getTimeTillExpiration(), upLoadRequest.getMaxDownloads(),
//								upLoadRequest.getTotalDownloads(), upLoadRequest.getPassword());

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
			}

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
