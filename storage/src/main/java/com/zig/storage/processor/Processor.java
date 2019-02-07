/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zig.storage.processor;

import com.zig.storage.commands.Commands;
import com.zig.storage.model.RAM;
import com.zig.storage.processor.type.Add;
import com.zig.storage.processor.type.Create;
import com.zig.storage.processor.type.Display;
import com.zig.storage.processor.type.List;
import com.zig.storage.processor.type.Save;
import com.zig.storage.processor.type.Use;
import com.zig.storage.reader.SingletonReader;
import java.io.IOException;

/**
 *
 * @author ars66zaa
 */
public class Processor {
    public RAM ram;

	public Processor(RAM ram) {
		this.ram = ram;
	}
	public String process(String commandString) throws IOException {
		String[] commandWords = commandString.trim().split("\\s+");
		if (commandWords.length != 0) {
			for (String s : commandWords) {
				System.out.println(s);
			}

			String result = "";
			switch (commandWords[0]) {
			case Commands.DISPLAY:
				result = Display.process(ram);
				break;

			case Commands.USE:
				if (commandWords.length > 1) {
					result = Use.process(ram, commandWords);
				} else {
					result = "Storage name does not specified";
				}
				break;

			case Commands.CREATE:
				if (commandWords.length > 1) {
					result = Create.process(ram, commandWords);
				} else {
					result = "Storage name does not specified";
				}
				break;

			case Commands.ADD:
				if (commandWords.length > 2) {
					result = Add.process(ram, commandWords);					
				} else {
					result = "Data for storage does not specified correctly";
				}
				break;

			case Commands.LIST:
				if (commandWords.length == 1) {
					result = List.process(ram);
				} else {
					result = "Storage name does not specified";
				}
				break;

			case Commands.SAVE:
				if (commandWords.length == 1) {
					result = Save.process(ram);
				} else {
					result = "Storage name does not specified";
				}
				break;

			case Commands.SHUTDOWN:
				SingletonReader readerLine = SingletonReader.getInstance();
				System.out.println("Saved storage (y/n)?");
				String otvet = null; 
				try {
					otvet = readerLine.readLine().trim();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (otvet.equals("y"))
					Save.process(ram);
				System.out.println("Good bye!");
				System.exit(0);
			}
			return result;
		} else {
			return "You do not entered any comand";
		}
	}
}
