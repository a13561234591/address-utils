package com.payegis.common;

import com.alibaba.fastjson.JSON;

import java.io.*;

public class DeepCopy {

	/**
	 * 深层拷贝
	 *
	 * @param <T>
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static <T> T copy(T obj) {
		//是否实现了序列化接口，即使该类实现了，他拥有的对象未必也有...
		if (Serializable.class.isAssignableFrom(obj.getClass())) {
			//如果子类没有继承该接口，这一步会报错
			//			try {
			return copyImplSerializable(obj);
			//			} catch (Exception e) {
			//这里不处理，会运行到下面的尝试json
			//			}
		}
		//如果序列化失败，尝试json序列化方式
		if (hasJson()) {
			try {
				return copyByJson(obj);
			} catch (Exception e) {
				//这里不处理，下面返回null
			}
		}
		return null;
	}

	/**
	 * 深层拷贝 - 需要类继承序列化接口
	 *
	 * @param <T>
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T copyImplSerializable(T obj) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;

		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;

		Object o = null;
		//如果子类没有继承该接口，这一步会报错
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			bais = new ByteArrayInputStream(baos.toByteArray());
			ois = new ObjectInputStream(bais);

			o = ois.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != baos) {
					baos.close();
				}
				if (null != oos) {
					oos.close();
				}
				if (null != bais) {
					bais.close();
				}
				if (null != ois) {
					ois.close();
				}
			} catch (Exception e2) {
				//这里报错不需要处理
			}
		}
		return (T) o;
	}

	/**
	 * 是否可以使用json
	 *
	 * @return
	 */
	private static boolean hasJson() {
		try {
			Class.forName("com.alibaba.fastjson.JSON");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 深层拷贝
	 *
	 * @param <T>
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T copyByJson(T obj) {
		return (T) JSON.parseObject(JSON.toJSONString(obj), obj.getClass());
	}
} 
