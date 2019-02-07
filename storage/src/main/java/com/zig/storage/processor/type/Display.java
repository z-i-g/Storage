/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zig.storage.processor.type;

import com.zig.storage.model.RAM;

/**
 *
 * @author ars66zaa
 */
public class Display {
    	public static String process(RAM ram) {
		return ram.display();
	}
}
