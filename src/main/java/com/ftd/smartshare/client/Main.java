package com.ftd.smartshare.client;

import com.ftd.smartshare.client.commands.SmartShare;
import picocli.CommandLine;

class Main {

    public static void main(String[] args) {
        CommandLine.run(new SmartShare()); // Pass cli arguments here
    }

}
