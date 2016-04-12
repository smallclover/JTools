package cn.jtools.test;

import cn.jtools.log.ILogger;
import cn.jtools.log.ILogger.ILevel;
import cn.jtools.log.impl.JDKLoggerFactory;

public class Test_log {
	public static ILogger iLogger = new JDKLoggerFactory().getLogger("Test_log");
	
	public static void main(String[] args) {
		iLogger.log(ILevel.WARN, "Test_log");
	}
}
