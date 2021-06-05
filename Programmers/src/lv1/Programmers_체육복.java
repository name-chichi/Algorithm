package lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_체육복 {
	public static void main(String[] args) {
		int n  = 10;	// 전체 학생수
		int[] lost = {5,4,3,2,1};	// 체육복 도난당한 학생들 
		int[] reserve = {3,1,2,5,4};  // 여벌 체육복 가지고 있는 학생들
		
		int num = 0;	// 체육복 빌린 학생수
		ArrayList<Integer> lost_list = new ArrayList<Integer>();
		ArrayList<Integer> reserve_list = new ArrayList<Integer>();
	
		for(int i : lost) lost_list.add(i);
		for(int j : reserve) reserve_list.add(j);
		
		// 여벌 체육복을 가져온 학생이 본인 체육복을 도난당한 경우 -> 본인 여벌 체육복으로 메꾸기
		for(int i : lost) {
			if(reserve_list.contains(i)) {
				num++;
				lost_list.remove(lost_list.indexOf(i));
				reserve_list.remove(reserve_list.indexOf(i));
			}
		}
		
		// 친구한테 체육복 빌리기
		for(int i : lost_list) {
			if(reserve_list.contains(i-1)) {
				num++;
				reserve_list.remove(reserve_list.indexOf(i-1));
			} else if(reserve_list.contains(i+1)) {
				num++;
				reserve_list.remove(reserve_list.indexOf(i+1));
			}
		}
		
		int result = n-(lost.length-num);
		System.out.println(result);
	}
}

/*

2 3 4

3 5


*/
