package lv1;

import java.util.Arrays;

public class Programmers_K번째수 {
	public static void main(String[] args) {
		// 테스트케이스
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		int[] answer = new int[commands.length];
		
		// 2차원 배열 길이만큼 반복
		for(int t=0; t<commands.length; t++) {
			int i = commands[t][0]-1;
			int j = commands[t][1];
			int k = commands[t][2];
			int[] tmpArr = new int[j-i];
			
			// array의 i번째 숫자부터 j번째 숫자까지 자르기
			int idx = 0;
			for(int n=i; n<j; n++) tmpArr[idx++] = array[n];
			// 정렬 후 K번째에 있는 수 구하기
			Arrays.sort(tmpArr);
			answer[t] = tmpArr[k-1];
		}
		System.out.println(Arrays.toString(answer));
	}
}
