package com.payegis.common.ipv6;

/**
 * Created by chao.guo on 2016/8/5.
 */
public class IP {

	/**
	 * write specfield bytes to a byte array start from offset
	 *
	 * @param b
	 * @param offset
	 * @param v
	 * @param bytes
	 */
	public static void write(byte[] b, int offset, long v, int bytes) {
		for (int i = 0; i < bytes; i++) {
			b[offset++] = (byte) ((v >>> (8 * i)) & 0xFF);
		}
	}

	/**
	 * write a int to a byte array
	 *
	 * @param b
	 * @param offset
	 * @param v
	 */
	public static void writeIntLong(byte[] b, int offset, long v) {
		b[offset++] = (byte) ((v >> 0) & 0xFF);
		b[offset++] = (byte) ((v >> 8) & 0xFF);
		b[offset++] = (byte) ((v >> 16) & 0xFF);
		b[offset] = (byte) ((v >> 24) & 0xFF);
	}

	/**
	 * get a int from a byte array start from the specifiled offset
	 *
	 * @param b
	 * @param offset
	 */
	public static long getIntLong(byte[] b, int offset) {
		return (((b[offset++] & 0x000000FFL)) | ((b[offset++] << 8) & 0x0000FF00L) |
				((b[offset++] << 16) & 0x00FF0000L) | ((b[offset] << 24) & 0xFF000000L));
	}

	/**
	 * string ip to long ip
	 *
	 * @param ip
	 *
	 * @return long
	 */
	public static long ip2long(String ip) {
		String[] p = ip.split("\\.");
		if (p.length != 4) {
			return 0;
		}

		int p1 = ((Integer.parseInt(p[0]) << 24) & 0xFF000000);
		int p2 = ((Integer.parseInt(p[1]) << 16) & 0x00FF0000);
		int p3 = ((Integer.parseInt(p[2]) << 8) & 0x0000FF00);
		int p4 = ((Integer.parseInt(p[3]) << 0) & 0x000000FF);

		return ((p1 | p2 | p3 | p4) & 0xFFFFFFFFL);
	}

	/**
	 * check the validate of the specifeld ip address
	 *
	 * @param ip
	 *
	 * @return boolean
	 */
	public static boolean isIpAddress(String ip) {
		String[] p = ip.split("\\.");
		if (p.length != 4) {
			return false;
		}

		for (String pp : p) {
			if (pp.length() > 3) {
				return false;
			}
			int val = Integer.parseInt(pp);
			if (val > 255) {
				return false;
			}
		}

		return true;
	}

}
