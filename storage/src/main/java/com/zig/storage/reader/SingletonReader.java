/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zig.storage.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author ars66zaa
 */
public class SingletonReader extends BufferedReader{
    private static SingletonReader rdr;
	
	private SingletonReader(InputStreamReader inputStreamReader) {
		super(inputStreamReader);
	}

	public static SingletonReader getInstance() {
		if (rdr == null) {
			rdr = new SingletonReader(new InputStreamReader(System.in));
		}
		return rdr;
	}
}
