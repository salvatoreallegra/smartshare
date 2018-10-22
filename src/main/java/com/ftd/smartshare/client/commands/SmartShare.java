package com.ftd.smartshare.client.commands;

import com.ftd.smartshare.client.commands.subcommands.Download;
import com.ftd.smartshare.client.commands.subcommands.Upload;
import picocli.CommandLine;

@CommandLine.Command(
        description = "Uploads/Downloads file using a given 'password', expiration (60 minutes by default), a max downloads (1 by default)",
        name = "smartshare",
        mixinStandardHelpOptions = true,
        version = "smartshare 1.0",
        subcommands = {
            Download.class,
            Upload.class
})
public class SmartShare implements Runnable {
    public void run() {
        CommandLine cl = new CommandLine(new SmartShare());
        cl.usage(System.out);
    }
}
