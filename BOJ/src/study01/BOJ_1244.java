package study01;

import java.util.Scanner;

public class BOJ_1244 {
	static int N;	// 스위치 개수
	static int[] arr;	// 스위치 상태
	static int[] change = {1,0};	// 스위치 변환
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();	
		arr = new int[N+1];	
		for(int i=1; i<=N; i++) arr[i] = scan.nextInt();

		int tc = scan.nextInt();	// 학생 수
		for(int t=0; t<tc; t++) {
			int sex = scan.nextInt();	// 성별
			int switchNum = scan.nextInt();	// 받은 스위치 번호
			game(sex, switchNum);
		}
		
		StringBuilder sb = new StringBuilder();
		// 출력
		for(int i=1; i<=N; i++) {
			if(i!=1 && i%20 == 1) sb.append("\n");
			sb.append(arr[i] + " ");
		}
		System.out.print(sb);
	}
	
	static void game(int sex, int switchNum) {
		if(sex == 1) {
			// 남자
			for(int i=switchNum; i<=N; i+=switchNum) arr[i] = change[arr[i]];
		} else {
			// 여자
			int idx = switchNum;
			int count = 1;
			while(true) {
				if(idx+count>N || idx-count<1) break;
				if(arr[idx+count] == arr[idx-count]) count++;
				else break;
			}
			count--;
			for(int i=idx-count; i<=idx+count; i++) arr[i] = change[arr[i]];
		}
	}
	
}
