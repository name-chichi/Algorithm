package lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programmers_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		int[] rank = {6,6,5,4,3,2,1}; // 순위 : 0 1 2 3 4 5 6
		
		// 테스트케이스
		int[] lottos = {45, 4, 35, 20, 3, 9};	// 구매한 로또 번호
		int[] win_nums = {20, 9, 3, 45, 4, 35};	// 당첨 번호
		
		int minNum = 0, maxNum = 0;	// 최저, 최고
		// 당청번호를 set에 넣고 구매한 로또를 순회하면서 당첨번호, 지워진 번호를 찾는다.
		Set<Integer> set = new HashSet<>();
		for(int i : win_nums) set.add(i);
		for(int j : lottos) {
			if(set.contains(j)) minNum++;
			else if(j == 0) maxNum++;
		}
		int[] result = {rank[(minNum+maxNum)], rank[minNum]};
		System.out.println(Arrays.toString(result));
	}
}
