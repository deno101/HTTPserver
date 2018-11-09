package org.denniz.server.filereader;

import java.io.*;
import java.net.*;

import org.denniz.server.*;

public class Reader {
	
	public Reader(String file) {
		this.file = file;
	}
	
	private String file;
	public String getStatus() {
		String ret = "";
		try {
			FileInputStream in = new FileInputStream(new File(file));
			ret = "200 ok";
		}catch(IOException e) {
			ret = "404 NOT FOUND";
		}
		return ret;
	}
	
	public byte[] getdata() {
		File html = new File(file);
		int size = (int)html.length();
		byte[] data = new byte[size];
		FileInputStream file_out;
		try {
			file_out = new FileInputStream(html);
			file_out.read(data, 0, size);
		} catch (IOException e) {
			data = getnotfound();
		}
		return data;
	}
	private byte[] getnotfound() {
		File html = new File("notfound.html");
		int size = (int)html.length();
		byte[] data = new byte[size];
		FileInputStream file_out;
		try {
			file_out = new FileInputStream(html);
			file_out.read(data, 0, size);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
