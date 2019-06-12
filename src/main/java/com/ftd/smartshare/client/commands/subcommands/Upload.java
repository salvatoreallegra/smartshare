package com.ftd.smartshare.client.commands.subcommands;

import com.ftd.smartshare.client.api.Api;
import com.ftd.smartshare.dto.UploadRequestDto;
import com.ftd.smartshare.utils.PasswordGenerator;
import org.apache.commons.text.RandomStringGenerator;
import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(
        description = "Uploads file using a given 'password', expiration (60 minutes by default), a max downloads (1 by default)",
        name = "upload",
        aliases = "u",
        mixinStandardHelpOptions = true
)



public class Upload implements Runnable {
	
	@CommandLine.Parameters(arity="1", index = "0", description = "The file to be uploaded")
    private File file;

    @CommandLine.Parameters(arity="0", index = "1", description = "The password for the file")
    private String password = PasswordGenerator.generate();

    private UploadRequestDto uploadDto = new UploadRequestDto();
    
    public void run() {
    	
    	uploadDto.setFileName(file.getName());
    	uploadDto.setPassword(password);
    	uploadDto.setTimeTillExpiration(60);
    	
    	Api.upload(uploadDto);
    	
        System.out.println("Uploading: " + file.getAbsolutePath());
        System.out.println("Password will be printed below");
        System.out.println(password);
        
        
    }


}
