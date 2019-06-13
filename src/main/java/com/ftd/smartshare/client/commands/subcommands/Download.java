package com.ftd.smartshare.client.commands.subcommands;

import com.ftd.smartshare.client.api.Api;
import com.ftd.smartshare.dto.DownloadRequestDto;
import com.ftd.smartshare.dto.UploadRequestDto;

import picocli.CommandLine;

@CommandLine.Command(
        description = "Downloads a file",
        name = "download",
        aliases = "d",
        mixinStandardHelpOptions = true
)
public class Download implements Runnable {

    @CommandLine.Parameters(arity="1", index = "0", description = "Name of file to be downloaded")
    private String fileName;

    @CommandLine.Parameters(arity="1", index = "1", description = "The password for the file")
    private String password;
    
    private DownloadRequestDto downloadDto = new DownloadRequestDto();
    public void run() {
        System.out.println("Downloading " + fileName);
        downloadDto.setFileName("pom.xml");
        downloadDto.setPassword("1234");
        boolean response = Api.download(downloadDto);
    }

}
