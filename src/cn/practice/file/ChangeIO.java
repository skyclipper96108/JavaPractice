package cn.practice.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
/**
 * InputStreamReader&OutputStreamWriter
 *
 */
public class ChangeIO {
	public static void copyFile2(InputStream is, OutputStream os) {
		if(is==null || os==null) {
			throw new IllegalArgumentException("��������");
		}
		try(// 新版关闭流方法，将新建流操作加入到try后面小括号里
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		) {
			
			char[] c = new char[1024];
			int read=-1;
			while((read=isr.read(c))!=-1) {
				osw.write(c,0,read);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
