package cn.practice.file;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;

public class InetAddressTest {

	@Test
	public void testName1() throws Exception {
		// static InetAddress getLocalHost()��ȡ���ؼ���������ƺ�ip
		InetAddress localHost=InetAddress.getLocalHost();
		System.out.println(localHost);
		// �������ֻ�ȡip
		InetAddress Name = InetAddress.getByName("baidu.com");
		System.out.println(Name);
		//�����Ƿ�õ�ַ�ɵ���
		boolean reachable = Name.isReachable(100);
		System.out.println(reachable);
		URL url = new URL("https://www.baidu.com");
		// Object content1 = url.getContent();
		/**
		 * �õ������� ����һ������� ָ�����λ��
		 * ��ȡ������
		 */
		InputStream os = url.openStream();
		FileOutputStream fos = new FileOutputStream("resources/baidu.html");
//		byte[] b = new byte[2048];
//		int a=0;
//		while((a=os.read(b))!=-1) {
//			fos.write(b,0,a);
//		}
//		IOUtils.copy(os,fos);
		/**
		 * ���ֽ�ת��Ϊ�ַ�
		 */
		InputStream os2 = url.openStream();
		InputStreamReader isr = new InputStreamReader(os2, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s =null;
		while((s=br.readLine())!=null)
			System.out.println(s);
	}
	@Test
	public void testName2() throws Exception {
		// ���ַ�����  ������URLDecoder.decode����
		String enc = URLEncoder.encode("������", "UTF-8");
		System.out.println(enc);
	}
}
