package lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = {4,4,4,3,3};
		ArrayList<Integer> list = new ArrayList<>();
		int num = arr[0];
		list.add(num);
		for (int i = 1; i < arr.length; i++) {
			if(num != arr[i]) {
				num = arr[i];
				list.add(num);
			}
		}
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
		System.out.println(Arrays.toString(answer));
 	}
}
