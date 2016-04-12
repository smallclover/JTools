package cn.jtools.log.impl;

import java.util.logging.Logger;
import java.util.logging.Level;

import cn.jtools.log.ILogger;

/**
 * JDKLogger
 * @author smallclover
 *
 */
public class JDKLogger implements ILogger {
	
	private final Logger logger;
	
	public JDKLogger(Logger logger){
		this.logger = logger;
	}
	
	/**
	 * 将自定义的ILevel转换为JDK自带的Level
	 * @param iLevel
	 * @return
	 */
	private Level jtools2JDK(ILevel iLevel){
		switch(iLevel){
			case TRACE: return Level.FINER;
			case DEBUG: return Level.FINE;
			case INFO:  return Level.INFO;
			case WARN:  return Level.WARNING;
			case ERROR: return Level.SEVERE;
			default:
				throw new IllegalArgumentException();
		}
	}

	@Override
	public String getName() {
		return logger.getName();
	}

	@Override
	public boolean isEnabled(ILevel iLevel) {
		return logger.isLoggable(jtools2JDK(iLevel));
	}

	@Override
	public void log(ILevel iLevel, String message) {		
		logger.log(jtools2JDK(iLevel), message);
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isLoggable(Level.FINER);
	}

	@Override
	public void trace(String message) {
		logger.log(Level.FINER, message);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isLoggable(Level.FINE);
	}

	@Override
	public void debug(String message) {
		logger.log(Level.FINE, message);
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isLoggable(Level.INFO);
	}

	@Override
	public void info(String message) {
		logger.log(Level.INFO, message);
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isLoggable(Level.WARNING);
	}

	@Override
	public void warn(String message) {
		logger.log(Level.SEVERE, message);
	}

	@Override
	public void warn(String message, Throwable throwable) {
		logger.log(Level.WARNING, message, throwable);
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isLoggable(Level.SEVERE);
	}

	@Override
	public void error(String message) {
		logger.log(Level.SEVERE, message);
	}

	@Override
	public void error(String message, Throwable throwable) {
		logger.log(Level.SEVERE, message, throwable);
	}
}
