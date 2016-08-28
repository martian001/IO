package com.east.io.work2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SummarizeWork {
	public static void main(String[] args) throws IOException {
		work1();
		// work2();
	}

	private static void work2() throws IOException, FileNotFoundException {
		File file = new File("E:\\temp\\work2temp\\system.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.println("print the system");
		printWriter.println("exception");
		printWriter.println("易通软件");
		printWriter.close();

		Scanner sc = new Scanner(new FileInputStream("E:\\temp\\work2temp\\system.txt"));
		System.setOut(new PrintStream("E:\\temp\\work2temp\\out.txt"));
		System.setErr(new PrintStream("E:\\temp\\work2temp\\err.txt"));
		String line = "";
		while (sc.hasNext()) {
			line = sc.nextLine();
			if ("exception".equalsIgnoreCase(line)) {
				try {
					throw new MyException("这是自定义异常");
				} catch (MyException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(line);
			}
		}

	}

	/**
	 * 合并多个文件内容
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void work1() throws IOException, FileNotFoundException {
		File file = new File("e:\\file.txt");
		file.createNewFile();
		PrintWriter printWriter = new PrintWriter(file);
		String path = "E:\\temp\\file00";
		String content = "";
		BufferedReader reader = null;
		for (int i = 1; i < 9; i++) {
			/**
			 * 解决中文乱码
			 */
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path + i + ".txt")), "GBK"));
			while ((content = reader.readLine()) != null) {
				System.out.println(content);
				printWriter.println(content);
			}
			reader.close();
		}
		printWriter.close();
		System.out.println("合并成功");
	}
}

class MyException extends RuntimeException {
	public MyException(String mess) {
		super(mess);
	}

	public MyException() {

	}
}
