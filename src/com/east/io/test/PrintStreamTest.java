package com.east.io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月24日 上午11:18:44      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * 打印流
		 */
		PrintStream printStream = new PrintStream(new File("e:\\User.txt"));
		System.setOut(printStream);
		System.out.println("1，梁衍君，998");
		System.out.append("\r\n1，梁衍君，998");
		System.out.append("\r\n1，梁衍君，998");
		System.out.append("\r\n1，梁衍君，998");

	}
}
