import java.io.*;
import java.net.*;
public class test {
	public static void main(String[] args) throws IOException{
		InetAddress ip = InetAddress.getByName("169.254.97.44");
		System.out.println(ip);
		String dd = ip.getHostName();
		System.out.println(dd);
	}

}
