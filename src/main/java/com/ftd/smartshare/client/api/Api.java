package com.ftd.smartshare.client.api;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.utils.NotImplementedException;

public final class Api {

    private static final String HOST    = "localhost";
    private static final int    PORT    = 3000;

    private Api () {
        throw new UnsupportedOperationException();
    }

    /**
     * Send download request
     *
     * @param downloadRequestDto    JAXB annotated class representing the download request
     * @return true if request was successful and false if unsuccessful
     */
    public static boolean download(DownloadRequestDto downloadRequestDto) {
    	
    	try (   Socket socket = new Socket(HOST, PORT);
				//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    			
				//FileWriter fileWriter = new FileWriter("quotes.xml");
				//PrintWriter printWriter = new PrintWriter(fileWriter);

		) {
    		
    		
    		
    	} catch(Exception e) {
    		
    	}
    	
    	return true;
        
    }

    /**
     * Send upload request
     *
     * @param uploadRequestDto      JAXB annotated class representing the upload request
     * @return true if request was successful and false if unsuccessful
     */
    public static boolean upload(UploadRequestDto uploadRequestDto) {
    	
    	try (   Socket socket = new Socket(HOST, PORT);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    			
				//FileWriter fileWriter = new FileWriter("quotes.xml");
				//PrintWriter printWriter = new PrintWriter(fileWriter);

		) {
    	JAXBContext context = JAXBContext.newInstance(UploadRequestDto.class);
		Marshaller marshaller = context.createMarshaller();

		// Marshal request to stringWriter
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(uploadRequestDto, stringWriter);

		// Write 'stringified' XML to socket
		out.println(stringWriter.toString());
		
		String success = in.readLine();
		if(success != null){
			System.out.println(success);
		}
		
		
    	} catch (JAXBException | IOException e) {
			System.out.println("Client Disconnected from Server...");
		}
    	
    	return true;
    	
    	 
    }
   

}
