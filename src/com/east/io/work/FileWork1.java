package com.east.io.work;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月21日 下午4:43:24        ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class FileWork1 {
	public static void main(String[] args) {
		FileWork1 fileList = new FileWork1();
		// fileList.list("F:\\新建文件夹");
		// fileList.showFileList("F:\\");
		// System.out.println("文件总数：" + fileList.count + "    大小：" + ((fileList.length / 1024.0) / 1024.0) + "GB");
		// fileList.filter("F:\\学习资料");
		fileList.filterFileList2("F:\\");
	}

	private int count = 0;
	private double length = 0;

	/**
	 * 打印传入目录下的全子文件和目录
	 * @param path
	 */
	public void showFileList(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		File[] listFiles = file.listFiles();
		if (listFiles == null) {
			return;
		}
		for (File f : listFiles) {
			System.out.println("文件名:" + f.getName() + "\n路径：" + f.getPath() + "  大小：" + ((f.length() / 1024) / 1024) + "MB  最后修改时间："
					+ new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(new Date(f.lastModified())) + "\n");
			System.out
					.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			if (f.isDirectory()) {
				showFileList(f.getPath());
			}
			count++;
			length = length + (f.length() / 1024);
		}
	}

	/**
	 * 根据传入的路径，查询后缀为java的文件
	 * @param path
	 */
	public void filterFileList2(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		File[] listFiles = file.listFiles();
		if (listFiles == null) {
			return;
		}
		for (File f : listFiles) {
			if (f.toString().endsWith(".java")) {
				System.out.println(f);
			}
			if (f.isDirectory()) {
				filterFileList2(f.getPath());
			}
		}
	}

	/**
	 * 根据传入的路径，查询后缀为java的文件
	 * @param path
	 */
	public void filterFileList(String path) {
		File file = new File(path);
		File[] listFiles = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.toString().endsWith(".java");
			}
		});
		for (File file2 : listFiles) {
			System.out.println(file2);
		}

	}
}
