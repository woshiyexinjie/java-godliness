package com.helloxin.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * get md5 hash string
 *
 * @author wenming.hong
 * @since 2012-6-23
 */
public class HashUtil {
    private static Logger logger = Logger.getLogger("HashUtil");


    private static char hexDigits[] = {'0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};

    private static char charDigits[] = {
            '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};


    public static String convertToHashStr(long hid, int len) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < len; i++) {
            char c = charDigits[(int) ((hid & 0xff) % charDigits.length)];
            sb.append(c);
            hid = hid >> 6;
        }

        return sb.toString();
    }


    public static String getFileMd5(InputStream input) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            byte buffer[] = new byte[1024];
            int len = 0;
            try {
                while ((len = input.read(buffer)) > 0) {
                    mdInst.update(buffer, 0, len);
                }
            } catch (IOException e1) {
            }
            input.close();

            byte[] digests = mdInst.digest();

            int j = digests.length;
            char str[] = new char[j * 2];

            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = digests[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
        }

        return "";
    }


    public static String getMd5(byte[] bytes) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(bytes);
            byte[] digests = mdInst.digest();

            int j = digests.length;
            char str[] = new char[j * 2];

            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = digests[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
        }

        return "";
    }

//    public static String getMd5Base64(byte[] bytes) {
//        MessageDigest mdInst;
//		try {
//			mdInst = MessageDigest.getInstance("MD5");
//			mdInst.update(bytes);
//			byte[] digests = mdInst.digest();
//
//			return new String(Base64.encode(digests));
//		} catch (Exception e) {
//		}
//
//    	
//    	return null;
//    }

    public static String getSHA1(String str) {
        return getSHA1(str.getBytes());
    }

    public static String getSHA1(byte[] bytes) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("SHA-1");
            mdInst.update(bytes);
            byte[] digests = mdInst.digest();

            int j = digests.length;
            char str[] = new char[j * 2];

            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = digests[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
        }

        return "";
    }

    public static String getMd5(String str) {
        return getMd5(str.getBytes());
    }

    public static long convertStringToLong(String str) {
        long l = 0;
        for (int i = 0; i < 16; i++) {
            int c = Character.digit(str.charAt(i), 16);
            l = (l << 4 | (long) (c & 0xf));
        }

        return l;
    }

    public static String convertLongToString(long l) {
        char str[] = new char[16];
        for (int i = 0; i < 16; i++) {
            int idx = (int) (l & 0xf);
            l = l >>> 4;
            str[15 - i] = hexDigits[idx];
        }
        return new String(str);
    }


}
