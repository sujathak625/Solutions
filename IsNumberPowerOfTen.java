package com.sujatha;

public class IsNumberPowerOfTen {

	public static void main(String[] args) {
		IsNumberPowerOfTen pOf10 = new IsNumberPowerOfTen();

		int input = 7001;

		int len = Integer.toString(input).length();
		StringBuilder str = new StringBuilder();
		str.append("1");
		for (int c = 0; c < len-1; c++) {
			str.append("0");
		}
	//	str.append("L");
		Long l = Long.parseLong(str.toString());
		if (input == l) {
			System.out.println(" Input " + input + " is power of 10");
		} else {
			System.out.println(" Input " + input + " is not power of 10");
		}
		
		if(input%10==0) {
			System.out.println(" but multiple of 10");
		} else {
			System.out.println(" and not multiple of 10");
		}

	}

}
