package com.east.io.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月22日 下午7:48:39       ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class CopyFileWork {
	public static void main(String[] args) throws IOException {
		CopyFileWork copyFileWork = new CopyFileWork();
		// boolean bool = copyFileWork.copyFile(new File("E:\\image\\360desktop_2014221175132421_systemp.jpg"), new
		// File("e:\\1.jpg"));
		// System.out.println(bool);
		// --------------------------------------------------------------------------
		boolean bool = copyFileWork.copyTextFile2(
				new File("F:\\homework-eclipse\\IO\\src\\com\\east\\io\\work\\CopyFileWork.java"), new File("e:\\1.txt"));
		System.out.println(bool);

	}

	/**
	 * 文件复制，此方法适合字节的操作，操作成功返回true，反则返回false
	 * @param src：源文件
	 * @param target：目标文件
	 * @return
	 * @throws IOException 
	 */
	public boolean copyFile(File src, File target) throws IOException {
		if (!src.exists()) {
			return false;
		}
		InputStream input = new FileInputStream(src);
		OutputStream output = new FileOutputStream(target);
		int temp = 0;
		while ((temp = input.read()) != -1) {
			output.write(temp);
		}
		input.close();
		output.close();
		return true;

	}

	/**
	 * 文件复制，此方法适合字节的操作，操作成功返回true，反则返回false
	 * @param src：源文件
	 * @param target：目标文件
	 * @return
	 * @throws IOException 
	 */
	public boolean copyFile2(File src, File target) throws IOException {
		if (!src.exists()) {
			return false;
		}
		InputStream input = new FileInputStream(src);
		OutputStream output = new FileOutputStream(target);
		byte[] b = new byte[1024];
		while (input.read(b) != -1) {
			output.write(b);
		}
		input.close();
		output.close();
		return true;
	}

	/**
	 * 文本文件复制，此方法适合字符的操作，操作成功返回true，反则返回false
	 * @param src：源文件
	 * @param target：目标文件
	 * @return
	 * @throws IOException 
	 */
	public boolean copyTextFile(File src, File target) throws IOException {
		if (!src.exists()) {
			return false;
		}
		Reader reader = new FileReader(src);
		Writer writer = new FileWriter(target);
		int temp = 0;
		while ((temp = reader.read()) != -1) {
			writer.write(temp);
		}
		reader.close();
		writer.close();
		return true;
	}

	/**
	 * 文本文件复制，此方法适合字符的操作，操作成功返回true，反则返回false
	 * @param src：源文件
	 * @param target：目标文件
	 * @return
	 * @throws IOException 
	 */
	public boolean copyTextFile2(File src, File target) throws IOException {
		if (!src.exists()) {
			return false;
		}
		Reader reader = new FileReader(src);
		Writer writer = new FileWriter(target);
		char[] c = new char[1024];
		while ((reader.read(c)) != -1) {
			writer.write(c);
		}
		reader.close();
		writer.close();
		return true;
	}
}
