package com.east.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月21日 下午8:12:20       ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class OutputStreamTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		// out1();
		// out2();
		copy();
		// copy2();//25662
	}

	private static void copy2() throws FileNotFoundException, IOException, InterruptedException {
		File file1 = new File("E:\\movie\\[www.66e.cc]300勇士.rmvb");
		File file2 = new File("E:\\1.rmvb");
		InputStream input = new FileInputStream(file1);
		OutputStream output = new FileOutputStream(file2);
		long begin = System.currentTimeMillis();
		int tem = 0;
		while ((tem = input.read()) != -1) {
			output.write(tem);
		}
		long end = System.currentTimeMillis();
		input.close();
		output.close();
		System.out.println("复制成功,所用时间shuzu：" + (end - begin));
	}

	private static void copy() throws FileNotFoundException, IOException {
		File file1 = new File("E:\\movie\\[www.66e.cc]300勇士.rmvb");
		File file2 = new File("E:\\2.rmvb");
		InputStream input = new FileInputStream(file1);
		OutputStream output = new FileOutputStream(file2);
		long begin = System.currentTimeMillis();
		byte[] b = new byte[1024];
		while (input.read(b) != -1) {
			output.write(b);
		}
		long end = System.currentTimeMillis();
		input.close();
		output.close();
		System.out.println("复制成功,所用时间：" + (end - begin));
	}

	private static void out2() throws FileNotFoundException, IOException {
		File file = new File("E:\\a.txt");
		OutputStream outputStream = new FileOutputStream(file);
		byte[] b = "sssssssssssssssssssssssssssssssccccccccccccccccvvvv".getBytes();
		for (int i = 0; i < b.length; i++) {
			outputStream.write(b[i]);
		}
	}

	private static void out1() throws FileNotFoundException, IOException {
		File file = new File("E:\\a.txt");
		OutputStream outputStream = new FileOutputStream(file);
		String str = "sssssssssssssssssssssssssssssssccccccccccccccccvvvv";
		outputStream.write(str.getBytes());
		outputStream.close();
	}
}
