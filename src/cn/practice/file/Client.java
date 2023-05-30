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
		System.out.println("初始化客户端");
		// 创建一个客户端套接字，连接对应端口的服务器
		socket=new Socket(InetAddress.getLocalHost(), 8868);
		System.out.println("成功连接");
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.start();
	}
	private void start() throws IOException {
		// 获取一个输出字节流
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter out = new OutputStreamWriter(os, "UTF-8");
		out.write("啊啊\n");
		out.flush();
		out.close();
		os.close();
		
	}
}
