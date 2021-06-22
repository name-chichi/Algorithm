package study01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_9872 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int result = Integer.MIN_VALUE;

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String[] strArr = new String[3];
		
		for(int t=0; t<N; t++) {
			for(int i=0; i<3; i++) strArr[i] = scan.next();
			Arrays.sort(strArr);
			String tmpStr = "";
			for (String string : strArr) tmpStr += (string + " ");
			
			if(hm.containsKey(tmpStr)) {
				int value = hm.get(tmpStr)+1;
				hm.put(tmpStr, value);
				result = Math.max(result, value);
			} else {
				int value = 1;
				hm.put(tmpStr, value);
				result = Math.max(result, value);
			}
		}
		System.out.println(result);
	}
}
