package com.rto.util;

import java.util.Random;

public class RandomGenerators {
	
	public static  String getRegNumber() {
		String str=	generateThreeCharRandom()+" "+randomInt()+" "+generateTwoCharRandom();
		return str;
	}
	private static int randomInt() {
		Random rd=new Random();
		int nextInt=0;
		while(true) {
			nextInt= rd.nextInt(99);
			if(nextInt>10) 
				break;
		}
		return nextInt;
	}	

	
	public static String generateTwoCharRandom() {
		String charaters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length=2;
		Random rand=new Random();
		String randomString="";
		char[] text=new char[length];
		for (int i = 0; i < length; i++) {
			text[i]=charaters.charAt(rand.nextInt(charaters.length()));
		}
		for (int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		return randomString;
	}
	
	public static String generateThreeCharRandom() {
		String charaters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length=3;
		Random rand=new Random();
		String randomString="";
		char[] text=new char[length];
		for (int i = 0; i < length; i++) {
			text[i]=charaters.charAt(rand.nextInt(charaters.length()));
		}
		for (int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		return randomString;
	}

}
