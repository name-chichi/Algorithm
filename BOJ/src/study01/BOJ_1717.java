package study01;

import java.util.Scanner;

public class BOJ_1717 {
	static int[] parents = new int[1000001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		// 초기화
		for(int i=1; i<=N; i++) parents[i] = i;
		
		for(int i=0; i<M; i++) {
			int command = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			switch (command) {
			case 0:
				// union
				unionParent(a, b);
				break;
			case 1:
				// find
				String answer = (findParent(a) == findParent(b)) ? "YES" : "NO";
				System.out.println(answer);
				break;
			}
		}
	}
	
	// 두 원소가 속한 집합 찾기
	static int findParent(int x) {
		// 루트 노드가 아니라면, 루트 노드를 찾을 때 까지 재귀적으로 호출
		if(parents[x] == x) return x;
		return parents[x] = findParent(parents[x]);	// 경로 압축(path compression)
	}
	
	// 두 원소가 속한 집합 합치기
	static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a<b) parents[b] = a;
		else parents[a] = b;
	}
}