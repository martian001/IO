package com.east.io.myutils;

import java.util.ArrayList;
import java.util.List;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年5月6日 下午8:22:25      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Test {
	public static void main(String[] args) {
		allFiles.add("a.第三个");
		allFiles.add("b.第一个");
		allFiles.add("c.第四个");
		allFiles.add("b.第二个");
		allFiles.add("e.第三个");
		allFiles.add("f.第四个");
		allFiles.add("g.第五个");
		allFiles.add("h.第四个");
		sortEqualFiles();
		for (String string : equalFiles) {
			System.out.println(string);
		}
	}

	public static List<String> equalFiles = new ArrayList<>();
	public static List<String> allFiles = new ArrayList<>();

	/**	 * 对equalFiles集合进行排序，这样的做法可以使得迭代出来的相同文件对象更加直观明了
	 */
	private static void sortEqualFiles() {
		String tempFile1;
		String tempFile2;
		int size = allFiles.size();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				tempFile1 = allFiles.get(i);
				tempFile2 = allFiles.get(j);
				if (tempFile1.substring(tempFile1.lastIndexOf(".") + 1).equals(tempFile2.substring(tempFile1.lastIndexOf(".") + 1))) {
					if (!equalFiles.contains(tempFile2)) {
						equalFiles.add(tempFile2);
					}
					if (!equalFiles.contains(tempFile1)) {
						equalFiles.add(tempFile1);
					}
				}
			}
		}
	}
}
