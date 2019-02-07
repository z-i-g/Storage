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
public class Add {
    public static String process(RAM ram, String[] commandWords) {
		boolean isAdded = ram.add(new String[]{commandWords[1], commandWords[2]});
		if (isAdded) {
			return "Data added";
		} else {
			return "There is no selected storage";
		}
	}
}
