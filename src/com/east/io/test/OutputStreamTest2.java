package com.east.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月22日 下午3:48:06        ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class OutputStreamTest2 {
	public static void main(String[] args) throws IOException {
		File file = new File("E:\\image\\爱壁纸HD_编号_157536.jpg");
		File file2 = new File("E:\\爱壁纸HD_编号_157536.jpg");
		InputStream input = new FileInputStream(file);
		OutputStream output = new FileOutputStream(file2);
		byte[] b = new byte[1024];
		while (input.read(b) != -1) {
			output.write(b);
		}
		// d();
	}

	static void d() {
		File file = new File("E:\\");
		File[] listFiles = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return dir.equals("E:\\image") && name.endsWith(".jpg");
			}
		});
		for (File file2 : listFiles) {
			System.out.println(file2);
		}
	}
}
