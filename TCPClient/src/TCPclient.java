import java.io.*;
import java.net.*;

class TCPclient {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		String str2 = "";
		while (!str.equalsIgnoreCase("connect")) {
			str = br.readLine();
		}
		Socket s = new Socket("127.0.0.1", 3333);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		while (!str.equalsIgnoreCase("stop")) {
			str = br.readLine();
			dout.writeUTF(str);
			dout.flush();
			str2 = din.readUTF();
			System.out.println("Server says: " + str2);
		}
		dout.close();
		s.close();
	}
}