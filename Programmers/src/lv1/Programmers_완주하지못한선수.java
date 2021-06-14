package lv1;

import java.util.HashMap;

public class Programmers_완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String answer = "";

		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		
		// 참가자들을 해쉬맵에 추가
		for (String string : participant) {
			if(!hashmap.containsKey(string)) hashmap.put(string, 1);
			else hashmap.put(string, hashmap.get(string)+1);
		}
		
		// 완주한 사람들을 해쉬맵의 값들을 -1씩 해준다.
		for (String string : completion) hashmap.put(string, hashmap.get(string)-1);

		// 해쉬맵을 순회하면서 값이 0이 아닌것을 찾아낸다.
		for (String key : hashmap.keySet()) if(hashmap.get(key) != 0) answer = key;
		System.out.println(answer);
	}
}
