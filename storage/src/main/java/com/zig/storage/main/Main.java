/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zig.storage.main;

import com.zig.storage.model.RAM;
import com.zig.storage.processor.Processor;
import com.zig.storage.type.LoadStorage;
import com.zig.storage.view.Console;
import java.io.FileNotFoundException;

/**
 *
 * @author ars66zaa
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		final String source;
		if (args.length == 0) {
			source = "src//main//java//com//zig//storage//storage_files";
		} else {
			source = args[0];
		}

		RAM ram = new RAM(source);
		LoadStorage.load(ram, source);
		Processor processor = new Processor(ram);
		Console console = new Console(processor);
		console.startListen();
	}
}
