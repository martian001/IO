package com.east.io.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年7月11日 上午9:39:04       ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Mapped {
	private static int javaCount = 0;

	public static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		StatisticsJavaFile(new File("F:\\homework-eclipse"));
		System.out.println("该目录java文件总数：" + javaCount);
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

	public static void StatisticsJavaFile(File file) throws IOException {
		if (!file.exists()) {
			return;
		}
		File[] listFiles = file.listFiles();
		if (null == listFiles) {
			return;
		}
		for (File f : listFiles) {
			if (f.isDirectory()) {
				StatisticsJavaFile(f);
			} else if (f.toString().endsWith(".txt")) {
				System.out.println(f);
				javaCount++;
				buffer(f.getPath());
			}
		}
	}

	/**
	 * 内存映射
	 * @param path
	 * @throws IOException
	 */
	public static void StatisticsAnnotationAndCode12(String path) throws IOException {
		File file = new File(path);
		FileChannel fin = new FileInputStream(file).getChannel();
		MappedByteBuffer buffer = fin.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		byte[] b = new byte[(int) file.length()];
		int i = 0;
		while (buffer.hasRemaining()) {
			b[i++] = buffer.get();
		}
		char[] array = new String(b, 0, b.length).toCharArray();
		char[] temp = new char[1024 * 2];
		int index = 0;
		for (char c : array) {
			temp[index++] = c;
			if (c == '\n') {
				System.out.print(new String(temp, 0, index));
				temp = null;
				temp = new char[1024 * 2];
				index = 0;
			}
		}
	}

	/**
	 * BufferedReader
	 * @param path
	 * @throws IOException
	 */
	public static void buffer(String path) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));
		String line = "";
		while (null != (line = br.readLine())) {
			System.out.println(line);
		}
	}

	public static void input() throws IOException {
		File file = new File("E:\\log.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		fileInputStream.read(b);
		System.out.println(new String(b, 0, b.length));
	}

	public static void StatisticsAnnotationAndCode1(String path) throws IOException {
		File file = new File(path);
		FileChannel fin = new FileInputStream(file).getChannel();
		MappedByteBuffer buffer = fin.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		byte[] b = new byte[(int) file.length()];
		int i = 0;
		while (buffer.hasRemaining()) {
			b[i++] = buffer.get();
		}
		System.out.println(new String(b, 0, b.length));
		char[] array = new String(b, 0, b.length).toCharArray();
		StringBuffer buf = new StringBuffer();
		for (char c : array) {
			buf = buf.append(c);
			if (c == '\n') {
				System.out.println(buf.toString());

			}
		}

	}
}
