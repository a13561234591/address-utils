package com.payegis.config;

/**
 * Created by user on 4/5/17.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class Prop {

	private static final Logger LOGGER = LoggerFactory.getLogger(Prop.class);
	private Properties properties;

	public Prop(String fileName) {
		this(fileName, "UTF-8");
	}

	public Prop(String fileName, String encoding) {
		this.properties = null;
		InputStream inputStream = null;
		InputStreamReader reader = null;
		try {
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			if (inputStream == null) {
				throw new IllegalArgumentException("Properties file not found in classpath: " + fileName);
			}
			this.properties = new Properties();
			reader = new InputStreamReader(inputStream, encoding);
			this.properties.load(reader);
		} catch (IOException var12) {
			throw new RuntimeException("Error loading properties file.", var12);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				LOGGER.error("关闭流失败", e);
			}
		}
	}

	public Prop(File file) {
		this(file, "UTF-8");
	}

	public Prop(File file, String encoding) {
		this.properties = null;
		if (file == null) {
			throw new IllegalArgumentException("File can not be null.");
		} else if (!file.isFile()) {
			throw new IllegalArgumentException("File not found : " + file.getName());
		} else {
			FileInputStream inputStream = null;
			InputStreamReader reader = null;
			try {
				inputStream = new FileInputStream(file);
				this.properties = new Properties();
				reader = new InputStreamReader(inputStream, encoding);
				this.properties.load(reader);
			} catch (IOException var12) {
				throw new RuntimeException("Error loading properties file.", var12);
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (IOException e) {
					LOGGER.error("关闭流失败", e);
				}
			}
		}
	}

	public String get(String key) {
		return this.properties.getProperty(key);
	}

	public String get(String key, String defaultValue) {
		return this.properties.getProperty(key, defaultValue);
	}

	public Integer getInt(String key) {
		return this.getInt(key, null);
	}

	public Integer getInt(String key, Integer defaultValue) {
		String value = this.properties.getProperty(key);
		return value != null ? Integer.valueOf(value) : defaultValue;
	}

	public Long getLong(String key) {
		return this.getLong(key, null);
	}

	public Long getLong(String key, Long defaultValue) {
		String value = this.properties.getProperty(key);
		return value != null ? Long.valueOf(value) : defaultValue;
	}

	public Boolean getBoolean(String key) {
		return this.getBoolean(key, null);
	}

	public Boolean getBoolean(String key, Boolean defaultValue) {
		String value = this.properties.getProperty(key);
		return value != null ? Boolean.valueOf(value) : defaultValue;
	}

	public boolean containsKey(String key) {
		return this.properties.containsKey(key);
	}

	public Properties getProperties() {
		return this.properties;
	}
}
