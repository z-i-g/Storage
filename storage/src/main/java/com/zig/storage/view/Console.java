/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zig.storage.view;

import com.zig.storage.processor.Processor;
import com.zig.storage.reader.SingletonReader;
import java.io.IOException;

/**
 *
 * @author ars66zaa
 */
public class Console {
    public Processor processor;
	public SingletonReader rdr = SingletonReader.getInstance(); 
	
	public Console(Processor processor) {
		this.processor = processor;
	}
	
	
	// считывание данных с консоли
	public void startListen() {
		while(true) {
			try {
				String commandString = rdr.readLine();
				String result = processor.process(commandString);
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
