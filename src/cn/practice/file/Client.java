package cn.practice.file;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
Socket socket;
	public Client() throws UnknownHostException, IOException {
		System.out.println("��ʼ���ͻ���");
		// ����һ���ͻ����׽��֣����Ӷ�Ӧ�˿ڵķ�����
		socket=new Socket(InetAddress.getLocalHost(), 8868);
		System.out.println("�ɹ�����");
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.start();
	}
	private void start() throws IOException {
		// ��ȡһ������ֽ���
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter out = new OutputStreamWriter(os, "UTF-8");
		out.write("����\n");
		out.flush();
		out.close();
		os.close();
		
	}
}
