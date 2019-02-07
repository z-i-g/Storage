/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zig.storage.model;

import com.zig.storage.type.MapStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 *
 * @author ars66zaa
 */
public class RAM {
    public Map<String, MapStorage> map;
	public MapStorage currentStorage = null;
	public String source;

	public RAM(String source) {
		map = new HashMap<>();
		this.source = source;
	}

	// вывод на экран всех сохраненных хранилищ
	public String display() {
		return map.keySet().toString();
	}

	// создание хранилища
	public boolean create(String name) {
		if (map.containsKey(name)) {
			return false;
		} else {
			map.put(name, new MapStorage(name));
			return true;
		}
	}

	// удаление хранилища с данным именем
	public void delete(String name) {
		MapStorage deleted = map.remove(name);
		if (deleted.equals(currentStorage)) {
			currentStorage = null;
		}
	}

	// команда выбора хранилища для дальнейшего использования
	public boolean use(String name) {
		MapStorage mapStorage = map.get(name);
		if (mapStorage != null) {
			currentStorage = mapStorage;
			return true;
		} else {
			return false;
		}
	}

	// добавление данных в выбранное хранилище
	public boolean add(String[] data) {
		if (currentStorage != null) {
			return currentStorage.add(data);
		} else {
			return false;
		}
	}

	// вывод на экран содержимого хранилища
	public String list() {
		if (currentStorage != null) {
			return currentStorage.hashMap.entrySet().toString();
		} else {
			return "Please select the Storage";
		}
	}

	// сохранение хранилища в виде файла с расширением .storage
	public boolean save() throws IOException {
		if (currentStorage != null) {

			File f = new File(source, currentStorage.name + ".storage");
			PrintWriter out = new PrintWriter(f);

			for (Entry <String, String> entry: currentStorage.hashMap.entrySet()) { 
				String key = entry.getKey(); 
				String value = entry.getValue(); 
				out.println(key);
				out.println(value);

			}
			out.close();

			return true;			
		}
		return false;
	}
}
