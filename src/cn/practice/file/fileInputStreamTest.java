package cn.practice.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * fileInputStream��InputStream�����������
 *
 */
public class fileInputStreamTest {
	public static void main(String[] args) {
		// ���췽�� �����������󲢸�ֵ��Ϊ����finally�ر���
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("resources/text.txt");
			// ��һ�� unicode�� һ�ζ�һ���ֽ�
//			int read = fis.read();
//			System.out.print(read);
			// ���
			byte[] b =new byte[20];// ��byte����װ����
			int read=-1;
			while((read=fis.read(b))!=-1) {// ��ȡ��һ�Σ�����ȡ���ֽڸ���������read�����У������ݱ�����b��
				String str = new String(b,0,read);
				System.out.println("��ȡ������"+str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// �ر���������finally�У���Ҫ�ǿ��жϣ������ָ���쳣
			if(fis !=null) {
				try {
					// ���� ���쳣����try
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("resources/copy.txt");
			/**
			 * ���룺���ַ���ת��Ϊ�ֽ����� 
			 * byte[] getBytes()
			 */
			byte[] b ="����������һ��.mp3".getBytes();
			fos.write(b,0,b.length); // ���ֽ�����b������д��ȥ����
			System.out.println("д�ɳɹ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// �ر���������finally�У���Ҫ�ǿ��жϣ������ָ���쳣
			if(fos !=null) {
				try {
					// ���� ���쳣����try
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
