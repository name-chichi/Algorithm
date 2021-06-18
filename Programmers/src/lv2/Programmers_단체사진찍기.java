package lv2;

import java.util.HashMap;

public class Programmers_단체사진찍기 {
	static int result = 0;
	public static void main(String[] args) {
		char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
		boolean[] visited = new boolean[8];
		char[] sel = new char[8];
		String[] tc = {"N~F=0", "R~T>2"};
		perm(arr, visited, sel, 0, tc);
		System.out.println(result);
	}
	
	// 순열
	static void perm(char[] arr, boolean[] visited, char[] sel, int idx, String[] data) {
		if(idx == sel.length) {
			HashMap<Character, Integer> hm = new HashMap<Character, Integer>();	// {이름: 서있는 위치}
			for(int i=0; i<sel.length; i++) hm.put(sel[i], i);
			
			boolean flag = true;
			for(int i=0; i<data.length; i++) {
				if(!isPicture(hm, data[i])) {	// 원하는 조건이 하나라도 틀리면 false
					flag = false;
					break;
				}
			}
			if(flag) result++;	// 모든 조건이 만족하면 result 하나 추가
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[idx] = arr[i];
				perm(arr, visited, sel, idx+1, data);
				visited[i] = false;
			}
		}
	}
	
	static boolean isPicture(HashMap<Character, Integer> hm, String data) {
		boolean chk = false;
		char[] pictureRule = data.toCharArray();	// N~F=0
		switch (pictureRule[3]) {
		case '=':
				chk = (Math.abs(hm.get(pictureRule[0]) - hm.get(pictureRule[2]))-1) == pictureRule[4]-'0'? true : false;
				break;
		case '>':
			chk = (Math.abs(hm.get(pictureRule[0]) - hm.get(pictureRule[2]))-1) > pictureRule[4]-'0' ? true : false;
			break;
		case '<':
			chk = (Math.abs(hm.get(pictureRule[0]) - hm.get(pictureRule[2]))-1) < pictureRule[4]-'0' ? true : false;
			break;
		}
		return chk;
	}
}
