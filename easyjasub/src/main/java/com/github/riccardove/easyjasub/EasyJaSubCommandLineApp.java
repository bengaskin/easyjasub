package com.github.riccardove.easyjasub;

import java.io.*;

import com.github.riccardove.easyjasub.commandline.EasyJaSubCommandLine;

public class EasyJaSubCommandLineApp {
	public EasyJaSubCommandLineApp() {
		commandLine = new EasyJaSubCommandLine();
	}

	EasyJaSubCommandLine commandLine;
	
	public int run(String[] args, PrintWriter outputStream, PrintWriter errorStream) throws Exception {
		if (!commandLine.parse(args)) {
			errorStream.println("Command invocation error:");
			errorStream.println(commandLine.getMessage());
			return -1;
		}
		if (commandLine.isHelp()) {
			commandLine.printHelp(outputStream);
			return 0;
		}
		EasyJaSubInputFromCommand input = null;
		try {
			new EasyJaSubInputFromCommand(commandLine);
		}
		catch (Exception ex) {
			errorStream.println("Command error:");
			errorStream.println(ex.getMessage());
		}
		return new EasyJaSub().run(input, outputStream, errorStream);
	}
}
