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
		System.out.println("初始化");
		serverSocket = new ServerSocket(8868);
		System.out.println("成功");
	}
	public static void main(String[] args) throws IOException {
		Server server=new Server();
		server.start();
	}
	private void start() throws IOException {
		System.out.println("等待客户端链接");
		Socket socket=serverSocket.accept();
		System.out.println("链接成功");
		// 接受客户端传来的数据
		InputStream is = socket.getInputStream();
		// 转换为字符流
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
         // 转换为缓冲流
		BufferedReader br = new BufferedReader(isr);
		String readLine = br.readLine();
		System.out.println(readLine);
	}
	
}
