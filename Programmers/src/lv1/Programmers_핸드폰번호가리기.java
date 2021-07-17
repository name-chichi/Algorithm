package lv1;

import java.util.Arrays;

public class Programmers_핸드폰번호가리기 {
	public static void main(String[] args) {
		String phone_number = "01033334444";
		char[] secret = phone_number.toCharArray();
		String answer = "";
		for (int i = 0; i < secret.length; i++) answer += (i<secret.length-4) ? '*' : secret[i];
		System.out.println(answer);
	}
}
