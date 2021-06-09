package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_모의고사 {
	public static void main(String[] args) {
		int[] answer = {1,2,3,4,5};
		
		// 1번
		int[] student1 = {1,2,3,4,5};  // 5 
		int[] student2 = {2,1,2,3,2,4,2,5};
		int[] student3 = {3,3,1,1,2,2,4,4,5,5};
		int[] studentNumArr = {0,0,0};
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i] == student1[i%student1.length]) studentNumArr[0]++;
			if(answer[i] == student2[i%student2.length]) studentNumArr[1]++;
			if(answer[i] == student3[i%student3.length]) studentNumArr[2]++;
		}
		
		int max = Math.max(studentNumArr[0], Math.max(studentNumArr[1], studentNumArr[2]));
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<3; i++) if(max == studentNumArr[i]) list.add(i+1);
		
		int[] result = new int[list.size()];
		int idx = 0;
		for(int num : list) result[idx++] = num;
		
		System.out.println(Arrays.toString(result));
	}
}
