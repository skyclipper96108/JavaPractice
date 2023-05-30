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
			byte[] b =new byte[20];// 用byte数组装数组
			int read=-1;
			while((read=fis.read(b))!=-1) {// 读取了一次，将读取的字节个数保存在read变量中，而数据保存在b中
				// 一边读一边写
				fos.write(b,0,read);
				fos.flush(); //将缓存区的文件按写入硬盘
			}// 文件复制成功
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 关闭流必须在finally中，且要非空判断，避免空指针异常
			close(fis, fos); //抽取成方法
		}
	}
	private static void close(FileInputStream is, FileOutputStream os) {
		try {
			if(os !=null) 
				// 关流 有异常继续try
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
