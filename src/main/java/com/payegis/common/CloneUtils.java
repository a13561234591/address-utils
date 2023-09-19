package com.payegis.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloneUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(CloneUtils.class);

	/**
	 * 数据不能使用
	 *
	 * @param obj
	 * @param <T>
	 * @return
	 */
	public static <T> T cloneObject(T obj) {
		if (obj == null) {
			return null;
		} else if (obj instanceof Cloneable) {
			Class clazz = obj.getClass();

			Method m;
			try {
				m = clazz.getMethod("clone", (Class[]) null);
			} catch (NoSuchMethodException var5) {
				throw new NoSuchMethodError(var5.getMessage());
			}

			try {
				T result = (T) m.invoke(obj, (Object[]) null);
				return result;
			} catch (InvocationTargetException var6) {
				Throwable cause = var6.getCause();
				if (cause instanceof CloneNotSupportedException) {
					//					throw (CloneNotSupportedException) cause;
					LOGGER.error("cant clone!", cause);

				} else {
					throw new Error("Unexpected exception", cause);
				}
			} catch (IllegalAccessException var7) {
				throw new IllegalAccessError(var7.getMessage());
			}
		} else {
			LOGGER.error("cant clone!");
		}

		return null;
	}

	public static Object clone(Object obj) {
		return cloneObject(obj);
	}

	private CloneUtils() {
	}

	//	public static void main(String[] args) {
	//		Date date = new Date();
	//		String[] a = new String[]{"123"};
	//		byte[] aa=new byte[]{12,12,2};
	//		System.out.println(clone(date));
	//		System.out.println(Arrays.asList(aa.clone()).toString());
	//	}

}
