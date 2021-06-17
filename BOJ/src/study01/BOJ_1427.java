package study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		StringBuilder sb = new StringBuilder();
		for(int i=charArr.length-1; i>=0; i--) sb.append(charArr[i]);
		System.out.println(sb);
	}
}
