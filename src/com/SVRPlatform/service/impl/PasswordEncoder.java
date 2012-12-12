package com.SVRPlatform.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**����MD5���м���
 * @param str  �����ܵ��ַ���
 * @return  ���ܺ���ַ��� 
 */
public class PasswordEncoder{
	public static String EncoderByMd5(String input){
		byte[] source;
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };// �������ֽ�ת����16���Ʊ�ʾ���ַ�
		try {
			source = input.getBytes("utf-8");
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			md.update(source);
			
			byte tmp[] = md.digest();// MD5 �ļ�������һ�� 128 λ�ĳ�������
									// ���ֽڱ�ʾ���� 16 ���ֽ�
			char str[] = new char[16 * 2];// ÿ���ֽ��� 16 ���Ʊ�ʾ�Ļ���ʹ�������ַ������Ա�ʾ�� 16
											// ������Ҫ 32 ���ַ�
			int k = 0;// ��ʾת������ж�Ӧ���ַ�λ��
			
			for (int i = 0; i < 16; i++) {	// �ӵ�һ���ֽڿ�ʼ���� MD5 ��ÿһ���ֽ�// ת���� 16
											// �����ַ���ת��
				byte byte0 = tmp[i];// ȡ�� i ���ֽ�
				
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];// ȡ�ֽ��и� 4 λ������ת��,// >>>
														// Ϊ�߼����ƣ�������λһ������
				str[k++] = hexDigits[byte0 & 0xf];// ȡ�ֽ��е� 4 λ������ת��
			}
			
			s = new String(str);// ����Ľ��ת��Ϊ�ַ���
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
}
