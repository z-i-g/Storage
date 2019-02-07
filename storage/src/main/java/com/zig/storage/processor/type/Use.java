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
public class Use {
    public static String process(RAM ram, String[] commandWords) {
		boolean isSelected = ram.use(commandWords[1]);
		if (isSelected) {
			return "Selected storage: " + commandWords[1];
		} else {
			return "Storage with name " + commandWords[1] + " does not exist";
		}
	}
}
