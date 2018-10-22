package com.ftd.smartshare;

import com.ftd.smartshare.commands.SmartShare;
import picocli.CommandLine;

class Main {

    public static void main(String[] args) throws Exception {
        CommandLine.run(new SmartShare(), "u", "./pom.xml"); // Pass cli arguments here
    }

}
