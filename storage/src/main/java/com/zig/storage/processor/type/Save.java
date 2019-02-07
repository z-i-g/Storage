/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zig.storage.processor.type;

import com.zig.storage.model.RAM;
import java.io.IOException;

/**
 *
 * @author ars66zaa
 */
public class Save {
    public static String process(RAM ram) throws IOException {
		boolean isSaved = ram.save();
		if (isSaved) {
			return "";
		} else {
			return "There is not selected storage";
		}
	}
}
