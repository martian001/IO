package com.east.io.myutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月27日 下午8:59:14       ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：代码工具类                               ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class SplitCodeUtil {
	public static void main(String[] args) {
		splitCodeAndAnnotation("F:\\homework-eclipse\\IO\\src\\com\\east\\io\\work3\\CodeUtil.java", "e:\\code.txt", "e:\\annotation.txt");
	}

	/**
	 * 默认构造器
	 */
	private SplitCodeUtil() {

	}

	/**
	 * 实现java文件分割，java代码输出到一个文件，注释输出到另外一个文件。
	 * @param srcPath:进行分割的java文件路径
	 * @param codePath:分割后代码存放的路径
	 * @param annotationPath：分割后注释存放的路径
	 */
	public static void splitCodeAndAnnotation(String srcPath, String codePath, String annotationPath) {
		ArrayList<String> annotationList = new ArrayList<>();
		ArrayList<String> CodeList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(srcPath)), "UTF-8"));
			String line = "";
			while (null != (line = br.readLine())) {
				if (line.matches("[\\s]*[/]{2,}.*")) {// 判断单行注释
					annotationList.add(line);
				} else if (line.matches("[\\s]*[/][*].*[*][/]")) {// 判断特殊多行注释，如:/**/
					annotationList.add(line);
				} else if (line.matches("[\\s]*[/][*].*[*]{2}[/]")) {// 判断特殊文档注释，如:/***/
					annotationList.add(line);
				} else if (line.matches("[\\s]*[/][*][^*]*")) {// 判断正常的多行注释
					nextAnnotation(annotationList, br, line);
				} else if (line.matches("[\\s]*[/][*]{1,}.*")) {// 判断正常的文档注释
					nextAnnotation(annotationList, br, line);
				} else if (line.trim().length() != 0) {//判断是否为 有效代码，不包括空行
					CodeList.add(line);
				}
			}
			PrintList(CodeList, codePath);
			PrintList(annotationList, annotationPath);
			System.out.println("操作成功！");
		} catch (IOException e) {
			System.err.println("IO异常");
		}
	}

	/**
	 * 继续读取注释，这个方法是从printCodeAndAnnotation方法中抽取出来的，当读到单行或者文档注释结尾的时候就会结束该方法
	 * @param annotationList
	 * @param br
	 * @param line
	 * @throws IOException
	 */
	private static void nextAnnotation(ArrayList<String> annotationList, BufferedReader br, String line) throws IOException {
		annotationList.add(line);
		while (null != (line = br.readLine())) {
			annotationList.add(line);
			if (line.matches(".*[*][/][\\s]*")) {
				break;
			}
		}
	}

	/**
	 * 该方法是保存代码或者注释到磁盘指定文件用的
	 * 注意：写入文件时会在行头加上行数
	 * @param contents：内容容器
	 * @param path：文件路径
	 */
	private static void PrintList(ArrayList<String> contents, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file, true);
			for (int i = 0; i < contents.size(); i++) {
				System.out.println(i + "\t" + contents.get(i));
				fos.write(("\r\n" + i + "\t" + contents.get(i)).getBytes());
			}
			fos.close();
		} catch (IOException e) {
			System.err.println("IO异常");
		}
	}
}
