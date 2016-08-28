package com.east.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月25日 上午10:45:03      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class ObjectOutputStreamTest {
	/**
	 * 要被序列化的对象要实现Serializable
	 * 不想被序列化的字段可以用transient修饰
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			/**
			 * 把对象序列化但本地文件
			 */
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("e:ob")));
			objectOutputStream.writeObject(new User(2, "martian"));
			/**
			 * 反序列化
			 */
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("e:ob")));
			User user = (User) objectInputStream.readObject();
			System.out.println(user);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class User implements Serializable {
	private int id;
	transient private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}