package cn.practice.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * fileInputStream是InputStream抽象类的子类
 *
 */
public class fileInputStreamTest {
	public static void main(String[] args) {
		// 构造方法 事先声名对象并赋值，为了在finally关闭流
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("resources/text.txt");
			// 读一个 unicode码 一次读一个字节
//			int read = fis.read();
//			System.out.print(read);
			// 最常用
			byte[] b =new byte[20];// 用byte数组装数组
			int read=-1;
			while((read=fis.read(b))!=-1) {// 读取了一次，将读取的字节个数保存在read变量中，而数据保存在b中
				String str = new String(b,0,read);
				System.out.println("读取的数据"+str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 关闭流必须在finally中，且要非空判断，避免空指针异常
			if(fis !=null) {
				try {
					// 关流 有异常继续try
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
			 * 编码：将字符串转换为字节数组 
			 * byte[] getBytes()
			 */
			byte[] b ="不如我们在一起.mp3".getBytes();
			fos.write(b,0,b.length); // 将字节数组b中数据写出去磁盘
			System.out.println("写成成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 关闭流必须在finally中，且要非空判断，避免空指针异常
			if(fos !=null) {
				try {
					// 关流 有异常继续try
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
