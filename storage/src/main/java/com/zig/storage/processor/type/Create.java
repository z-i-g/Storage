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
public class Create {
    public static String process(RAM ram, String[] commandWords) {
		boolean isCreated = ram.create(commandWords[1]);
		if (isCreated) {
			return "Storage " + commandWords[1] + " is created";
		} else {
			return "Storage " + commandWords[1] + " already exists";
		}
	}
}
