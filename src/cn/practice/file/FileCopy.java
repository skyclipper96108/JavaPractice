package cn.practice.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 *
 */
public class FileCopy {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream("resources/text.txt");
			fos = new FileOutputStream("resources/copysong.txt");
			byte[] b =new byte[20];// ��byte����װ����
			int read=-1;
			while((read=fis.read(b))!=-1) {// ��ȡ��һ�Σ�����ȡ���ֽڸ���������read�����У������ݱ�����b��
				// һ�߶�һ��д
				fos.write(b,0,read);
				fos.flush(); //�����������ļ���д��Ӳ��
			}// �ļ����Ƴɹ�
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// �ر���������finally�У���Ҫ�ǿ��жϣ������ָ���쳣
			close(fis, fos); //��ȡ�ɷ���
		}
	}
	private static void close(FileInputStream is, FileOutputStream os) {
		try {
			if(os !=null) 
				// ���� ���쳣����try
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
		try {
				if(is !=null) 
				is.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
		}
	}
}
