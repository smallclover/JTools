package cn.jtools.log.impl;

import java.util.logging.Logger;

import cn.jtools.log.ILogFactoryInterface;
import cn.jtools.log.ILogger;

public class JDKLoggerFactory implements ILogFactoryInterface {

	@Override
	public ILogger getLogger(String name) {
		return new JDKLogger(Logger.getLogger(name));
	}

}
