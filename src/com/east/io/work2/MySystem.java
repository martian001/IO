package com.east.io.work2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月25日 下午2:43:02        ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class MySystem {
	public static void main(String[] args) {
		new MySystem().init();
	}

	private Scanner sc = new Scanner(System.in);
	private Computer[] computers = new Computer[3];
	private final String PATH_NAME = "e:Objects.txt";

	public void init() {
		while (true) {
			System.out.println("1.录入电脑信息      2.查看上一次录入信息  3.退出");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				enteringInfo();
				break;
			case 2:
				query();
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}

	/**
	 * 查询上次保存信息
	 */
	private void query() {
		try {
			File file = new File(PATH_NAME);
			if (!file.exists() || (file.length() == 0)) {
				System.out.println("温馨提示：无信息内容.");
				return;
			}
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			computers = (Computer[]) ois.readObject();
			for (Computer computer : computers) {
				System.out.println(computer);
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 录入电脑信息
	 */
	private void enteringInfo() {
		String cpu = "";
		String mem = "";
		String disk = "";
		String name = "";
		int age = 0;
		for (int i = 1; i < 4; i++) {
			System.out.println("录入第" + i + "台电脑信息");
			System.out.println("请输入cup型号：");
			cpu = sc.next();
			System.out.println("请输入硬盘型号：");
			disk = sc.next();
			System.out.println("请输入内存条型号：");
			mem = sc.next();
			System.out.println("请输入该电脑使用者名字：");
			name = sc.next();
			System.out.println("请输入该电脑使用者年龄：");
			age = sc.nextInt();
			computers[i - 1] = new Computer(cpu, mem, disk, new User(age, name));
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(PATH_NAME)));
			oos.writeObject(computers);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
