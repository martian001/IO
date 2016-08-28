package com.east.io.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年7月10日 下午5:07:44      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class LogWriter {

	/**
	 * 日志的配置文件
	 */
	public static final String LOG_CONFIGFILE_NAME = "log.properties";

	/**
	 * 日志文件名在配置文件中的标签
	 */
	public static final String LOGFILE_TAG_NAME = "logfile";

	/**
	 * 默认的日志文件的路径和文件名称
	 */
	private final String DEFAULT_LOG_FILE_NAME = "./logtext.log";

	/**
	 * 该类的唯一的实例
	 */
	private static LogWriter logWriter;

	/**
	 * 文件输出流
	 */
	private PrintWriter writer;

	/**
	 * 日志文件名
	 */
	private String logFileName;

	public LogWriter() throws LogException {
		init();
	}

	public LogWriter(String logFileName) throws LogException {
		this.logFileName = logFileName;
		init();
	}

	/**
	 * 获取实例
	 * @return
	 * @throws LogException
	 */
	public synchronized static LogWriter getLogWriter() throws LogException {
		if (logWriter == null) {
			logWriter = new LogWriter();
		}
		return logWriter;
	}

	/**
	 * 获取实例
	 * @return
	 * @throws LogException
	 */
	public synchronized static LogWriter getLogWriter(String logFileName) throws LogException {
		if (logWriter == null) {
			logWriter = new LogWriter(logFileName);
		}
		return logWriter;
	}

	/**
	 * 往日志文件中写入一条日志信息
	 * @param logMsg
	 */
	public synchronized void log(String logMsg) {
		writer.println(new Date() + ":" + logMsg);
	}

	/**
	 * 往日志文件中写入一条异常信息
	 * @param e
	 */
	public synchronized void log(Exception e) {
		writer.println(new Date() + ":");
		e.printStackTrace(writer);
	}

	/**
	 * 初始化logWriter
	 * @throws LogException
	 */
	private void init() throws LogException {
		if (logFileName == null) {
			logFileName = getFileNameFromConfigFile();
			if (logFileName == null) {
				logFileName = DEFAULT_LOG_FILE_NAME;
			}
		}
		File logFile = new File(logFileName);
		try {
			writer = new PrintWriter(new FileWriter(logFile, true), true);
			System.out.println("日志文件的位置：" + logFile.getPath());
		} catch (IOException e) {
			String errmsg = "无法打开日志文件" + logFile.getPath();
			throw new LogException(errmsg, e);
		}
	}

	/**
	 * 从配置文件中取日志文件名
	 * @return
	 */
	private String getFileNameFromConfigFile() {
		try {
			Properties pro = new Properties();
			InputStream fin = getClass().getResourceAsStream(LOG_CONFIGFILE_NAME);
			if (fin != null) {
				pro.load(fin);
				fin.close();
				return pro.getProperty(LOGFILE_TAG_NAME);
			} else {
				System.out.println("无法打开属性配置文件");
			}
		} catch (IOException e) {
			System.out.println("无法打开属性配置文件");
		}
		return null;
	}

	/**
	 * 关闭logWriter
	 */
	public void close() {
		logWriter = null;
		if (writer != null) {
			writer.close();
		}
	}

	public static void main(String[] args) {
		LogWriter logWriter2 = null;
		try {
			logWriter2 = LogWriter.getLogWriter("e://user.log");
			logWriter2.log("第一个日志信息");
			logWriter2.log("第二个日志信息");
			//			logWriter2.close();
			System.out.println("-----");
			throw new LogException("ffff");
		} catch (LogException e) {
			logWriter2.log(e);
			logWriter2.close();
		}
	}
}
