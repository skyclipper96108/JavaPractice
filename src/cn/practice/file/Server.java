package cn.practice.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket serverSocket;
	public Server()throws IOException{
		System.out.println("��ʼ��");
		serverSocket = new ServerSocket(8868);
		System.out.println("�ɹ�");
	}
	public static void main(String[] args) throws IOException {
		Server server=new Server();
		server.start();
	}
	private void start() throws IOException {
		System.out.println("�ȴ��ͻ�������");
		Socket socket=serverSocket.accept();
		System.out.println("���ӳɹ�");
		// ���ܿͻ��˴���������
		InputStream is = socket.getInputStream();
		// ת��Ϊ�ַ���
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
         // ת��Ϊ������
		BufferedReader br = new BufferedReader(isr);
		String readLine = br.readLine();
		System.out.println(readLine);
	}
	
}
