package org.denniz.server;

import org.denniz.server.filereader.Reader;

import java.io.*;
import java.net.*;

public class MainServer {

	public static void main(String[] args) {
		try {

			ServerSocket serv = new ServerSocket(80);

			while (true) {
				Socket sock = serv.accept();
				Thread subprocess = new Thread(new SubThread(sock));
				subprocess.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class SubThread implements Runnable {
	private Socket sock;

	public SubThread(Socket sock) {
		this.sock = sock;
	}

	public void run() {
		Server server = new Server(sock);
		String request = server.recieve();
		Server sv = new Server(request);
		Reader read  = new Reader(sv.getRequest());
		byte[] data = read.getdata();
		String type = sv.gettype();
		server.send(data,read.getStatus(),type);
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
