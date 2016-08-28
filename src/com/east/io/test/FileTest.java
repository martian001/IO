package com.east.io.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月21日 上午10:16:27      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class FileTest {
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\学习资料\\新建文件夹");
		File file2 = new File("F:\\学习资料");
		// for (String file3 : file2.list()) {
		// System.out.println(file3);
		// }
		// for (File file3 : file2.listFiles()) {
		// System.out.println(file3 + "======" + ((file3.length() / 1024)));
		// }
		for (File file3 : file2.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.toString().endsWith(".java");
			}
		})) {
			System.out.println(file3 + "======" + ((file3.length())));
		}
		// file2.createNewFile();
		// if (file2.exists()) {
		// System.out.println(file2.delete());
		// }
		// System.out.println(file2.isHidden());
		// System.out.println(file.getAbsoluteFile());
		// file2.createNewFile();
		// System.out.println(file.getName());
		// System.out.println(file2.getName());
		// System.out.println(file.getParent());
		// System.out.println(file2.getParent());
		// System.out.println(file.getPath());
		// System.out.println(file2.getPath());
		// System.out.println(file.renameTo(new File("F:\\学习资料\\a.txt")));
		// File.createTempFile("aaa", ".zip", file);
	}
}
