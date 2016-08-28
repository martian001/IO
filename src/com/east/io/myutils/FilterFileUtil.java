package com.east.io.myutils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年5月6日 上午10:57:22      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：文件工具类，查找相同的文件☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class FilterFileUtil {
	public static void main(String[] args) {
		List<File> files = FilterFileUtil.getEqualsFiles(new File("F:\\homework-eclipse"), ".+[.]java");
		int i = 1;
		for (File file : files) {
			System.out.println((i++) + "   " + file);
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}
		System.out.println("相同文件总数：" + files.size());
	}

	/**
	 * 保存符合正则表达式的文件对象的集合
	 */
	public static List<File> allFiles = new ArrayList<>();

	/**
	 * 保存相同的文件对象的集合
	 */
	public static List<File> equalFiles = new ArrayList<>();

	/**
	 * 根据正则表达式和File对象（File为一个目录的对象）进行收集相同的文件，返回一个List集合
	 * 本方法中所指的相同文件：1.文件名相同          2.文件大小相同
	 * 大概步骤：
	 *       1.收集符合正则表达式的文件对象到allFiles集合 中
	 *       2.对收集的文件对象进行判断，把相同的文件对象添加到equalFiles集合中
	 * @param file:一个目录的File对象
	 */
	public static List<File> getEqualsFiles(File file, String regex) {
		filterFileByName(file, regex);
		File tempFile1;
		File tempFile2;
		int size = allFiles.size();
		//从自己跟往后的所有的对象进行比较，如果相同则会添加到集合，所以在集合中相同（文件名字和大小相同）的文件则会在一起
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				tempFile1 = allFiles.get(i);
				tempFile2 = allFiles.get(j);
				//比较两个文件名字和大小是否相同
				if (tempFile1.getName().equals(tempFile2.getName()) && (tempFile1.length() == tempFile2.length())) {
					if (!equalFiles.contains(tempFile1)) {//如集合已经包含该对象，则不保存
						equalFiles.add(tempFile1);
					}
					if (!equalFiles.contains(tempFile2)) {//如集合已经包含该对象，则不保存
						equalFiles.add(tempFile2);
					}
				}
			}
		}
		return equalFiles;
	}

	/**
	 * 根据正则表达式收集（过滤）文件对象，不包括文件夹
	 * @param file：文件对象（File为一个目录的对象）
	 * @param regex：正则表达式
	 */
	public static void filterFileByName(File file, String regex) {
		if (!file.exists()) {
			return;
		}
		File[] listFiles = file.listFiles();
		if (listFiles == null) {
			return;
		}
		for (File f : listFiles) {
			if (f.isDirectory()) {
				filterFileByName(f, regex);
			} else if (f.getName().matches(regex)) {
				allFiles.add(f);
			}
		}
	}
}
