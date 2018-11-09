package org.denniz.server;

import java.net.*;
import java.util.Arrays;
import java.io.*;

public class Server {
	private String[] request;
	private Socket sock;
	public Server(Socket sock) {
		this.sock = sock;
	}
	
	public Server(String request) {
		this.request = request.split("\n");
	}
	
	public String recieve() {
		String requestMassage = "";
		try {
			InputStream in = sock.getInputStream();
			DataInputStream data_in = new DataInputStream(in);
			byte[] request = new byte[1024];
			data_in.read(request, 0, request.length);
			requestMassage = new String(request);
			System.out.println(requestMassage);
			return requestMassage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestMassage;
	}
	
	public void send(byte[] data,String status,String type) {
		String Status = "HTTP/1.1 "+status+"\nDate: \nServer: \nAccept-Ranges:none\nContent-type:"+type+"\nConnection:closed\r\n";
		String blankLine ="\r\n";
		OutputStream out;
		try {
			out = sock.getOutputStream();
			DataOutputStream data_out = new DataOutputStream(out);
			String response_massage = Status+blankLine;
			byte[] response = add(response_massage.getBytes(),data);
			System.out.println(response.length);
			data_out.write(response, 0, response.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private int checkLength(byte[] s) {
		int x = 0;
		for(byte d:s) {
			if (d == 0) {
				break;
			}
			x++;
		}
		return x;
	}
	
	private byte[] add(byte[] one,byte[] two) {
		byte[] result = new byte[one.length+two.length];
		int index = 0;
		for(int i = 0;i < one.length;i++) {
			result[index] = one[i];
			index+=1;
		}
		for(int i = 0;i < two.length;i++) {
			result[index] = two[i];
			index+=1;
		}
		return result;
	}
	
	public String getRequest() {
		String file = "";
		String main = this.request[0];
		String[] temp = main.split(" ");
		System.out.println(Arrays.toString(temp));
		String tempreq = temp[1];
		System.out.println(tempreq);
		String[] hold = tempreq.split("/");
		for (int i =1;i<hold.length;i++) {
			if (i == 1) {
				file = hold[i];
				continue;
			}
			file = file + "/" + hold[i];
		}
		return file;
	}
	
	private boolean isReferer(String request) {
		boolean bool = false;
		String[] all = request.split("\n");
		for(String i:all) {
			String[] index = i.split(":");
			for(String w:index) {
				if(w.equalsIgnoreCase("Referer")) {
					bool = true;
					break;
				}
			}
			if(bool) {
				break;
			}
		}
		return bool;
	}
	
	private String getReferer(String request) {
		boolean bool = false;
		String ret = "";
		String holder = "";
		String[] all = request.split("\n");
		for(String i:all) {
			String[] index = i.split(":");
			for(int x = 0;x < 1;x++) {
				if(index[0].equalsIgnoreCase("Referer")) {
					holder = index[1];
					bool = true;
				}
			}
			if (bool ) {
				break;
			}
		}
		String[] ref = holder.split("//");
		String[] cv = ref[1].split("/");
		for(int i = 1;i< cv.length;i++) {
			ret += cv[i] + "/";
		}
		return ret;
	}
	
	public String gettype() {
		String temp = this.request[0];
		String[] requestdet = temp.split(" ");
		String[] filetype = requestdet[1].split("\\.");
		int len = filetype.length - 1;
		String actfiletype = filetype[len];
		String rets = "";
		if(actfiletype.equalsIgnoreCase("css") || actfiletype.equalsIgnoreCase("html") || actfiletype.equalsIgnoreCase("htm")) {
			rets = "text/"+actfiletype;
		}else if(actfiletype.equalsIgnoreCase("js")) {
			rets = "text/javascript";
		}else if(actfiletype.equalsIgnoreCase("png") || actfiletype.equalsIgnoreCase("jpg") || actfiletype.equalsIgnoreCase("ico")) {
			rets = "image/"+actfiletype;
		}
		return rets;
	}
	
}
