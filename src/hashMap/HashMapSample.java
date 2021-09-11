package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import common.Utils;

/*
 * 	OUTPUT

	[QUESTION 1] HashMap에 들어있지 않은 원소를 get한 경우 어떤 결과가 출력될까?
	[ANSWER] null
	------------------------------------------------------------------------------
	[QUESTION 2] 클래스 객체를 key로 구분할 수 있을까?
	a1 객체를 key로 put.
	a2 객체를 key로 put.
	key a1 get : a1 value
	key a1's same id object(a4) get : null
	key a2 get : a2 value
	key a2's same id object(a3) get : null
	[ANSWER] 같은 객체를 get하면 객체의 주소를 hash한 값을 hash buckets에 key로 넣기 때문에 해당 object key의 value를 꺼낼 수 있다.
	------------------------------------------------------------------------------
	[QUESTION 3] 내부 변수가 같은 클래스 객체를 key로 구분할 수 있을까?
	key new Object(same id, same val) get : null
	[ANSWER] 객체의 내부 변수 값이 일치해도 객체 주소 자체가 다르기 때문에(주소를 hash한 값이 key) 꺼낼 수 없다.
	------------------------------------------------------------------------------
	[QUESTION 4] (id 변수값 기준) hashCode와 equals 함수를 Overriding한 클래스 객체를 key로 했을 때, 꺼낼 수 있는 방법은?
	b1 객체를 key로 put.
	[ANSWER] key로 넣은 객체로 get : b1
	[ANSWER] id값 일치, val값 일치 한 new 객체를 key로 get  : b1
	[ANSWER] id값 일치, val값 불일치 한 new 객체를 key로 get  : b1
	[ANSWER] id값 불일치, val값 일치 한 new 객체를 key로 get  : null
	[ANSWER] id값 불일치, val값 불일치 한 new 객체를 key로 get  : null
	------------------------------------------------------------------------------
 */
public class HashMapSample {
	public static void main(String args[]) {
		
		HashMap<B, String> bMap = new HashMap<B, String>();
		
		// 1) HashMap에 들어있지 않은 원소를 get한 경우 어떤 결과가 출력될까?
		question1();
		
		// 2) 클래스 객체를 key로 구분할 수 있을까?
		question2();
		
		// 3) 내부 변수가 같은 클래스 객체를 key로 구분할 수 있을까?
		question3();
				
		// 4) hashCode와 equals 함수를 Overriding한 클래스 객체를 key로 했을 때, 꺼낼 수 있는 방법은?
		question4();
		
		// 5) Map에 들어있는 key의 value 값을 변경시키고 싶을 때  사용하는 방법은?
		question5();
		
		// 6) HashMap for문 탐색하는 방법?
		question6();
		
		// 7) Map에 들어있지 않은 key를 get(key) 호출했을 때 결과?
		question7();
		
		// 8) map.putIfAbsent() 사용법?
		question8();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] HashMap에 들어있지 않은 원소를 get한 경우 어떤 결과가 출력될까?");
		HashMap<Integer, Integer> q1 = new HashMap<Integer, Integer>();
		q1.put(1, 1);
		System.out.println("[ANSWER] " + q1.get(2));
		System.out.println("------------------------------------------------------------------------------");	
	}
	
	static void question2() {
		HashMap<A, String> aMap = new HashMap<A, String>();
		System.out.println("[QUESTION 2] 클래스 객체를 key로 구분할 수 있을까?");
		A a1 = new A("1", "1");
		A a2 = new A("2", "2");
		A a3 = new A("2", "3");
		A a4 = new A("1", "4");
		aMap.put(a1, "a1 value");
		aMap.put(a2, "a2 value");
		System.out.println("a1 객체를 key로 put.");
		System.out.println("a2 객체를 key로 put.");
		System.out.println("key a1 get : " + aMap.get(a1));
		System.out.println("key a1's same id object(a4) get : " + aMap.get(a4));
		System.out.println("key a2 get : " + aMap.get(a2));
		System.out.println("key a2's same id object(a3) get : " + aMap.get(a3));
		System.out.println("[ANSWER] 같은 객체를 get하면 객체의 주소를 hash한 값을 hash buckets에 key로 넣기 때문에 해당 object key의 value를 꺼낼 수 있다.");
		System.out.println("------------------------------------------------------------------------------");	
	}
	
	static void question3() {
		HashMap<A, String> aMap = new HashMap<A, String>();
		System.out.println("[QUESTION 3] 내부 변수가 같은 클래스 객체를 key로 구분할 수 있을까?");
		A aa1 = new A("1", "1");
		aMap.put(aa1, "aa1");
		System.out.println("key new Object(same id, same val) get : " + aMap.get(new A("1", "1")));
		System.out.println("[ANSWER] 객체의 내부 변수 값이 일치해도 객체 주소 자체가 다르기 때문에(주소를 hash한 값이 key) 꺼낼 수 없다.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question4() {
		HashMap<B, String> bMap = new HashMap<B, String>();
		System.out.println("[QUESTION 4] (id 변수값 기준) hashCode와 equals 함수를 Overriding한 클래스 객체를 key로 했을 때, 꺼낼 수 있는 방법은?");
		B b1 = new B("11", "11");
		bMap.put(b1, "b1");
		System.out.println("b1 객체를 key로 put.");
		System.out.println("[ANSWER] key로 넣은 객체로 get : " + bMap.get(b1));
		System.out.println("[ANSWER] id값 일치, val값 일치 한 new 객체를 key로 get  : " + bMap.get(new B("11", "11")));
		System.out.println("[ANSWER] id값 일치, val값 불일치 한 new 객체를 key로 get  : " + bMap.get(new B("11", "22")));
		System.out.println("[ANSWER] id값 불일치, val값 일치 한 new 객체를 key로 get  : " + bMap.get(new B("22", "11")));
		System.out.println("[ANSWER] id값 불일치, val값 불일치 한 new 객체를 key로 get  : " + bMap.get(new B("22", "22")));
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question5() {
		System.out.println("[QUESTION 5] Map에 들어있는 key의 value 값(기본형)을 변경시키고 싶을 때  사용하는 방법은?");
		Map<String, Integer> cMap = new HashMap<String, Integer>();
		String key = "KEY";
		cMap.put(key, 1);
		System.out.println("get한 value 값 수정? -> X");
		System.out.println("[ANSWER] put(get()~) 로 꺼낸 값을 다시 put해서 갱신시킨다.");
		System.out.println("갱신 이전 value : " + cMap.get(key));
		cMap.put(key, cMap.get(key) + 1);
		System.out.println("갱신 이후 value : " + cMap.get(key));
		System.out.println("------------------------------------------------------------------------------");
		
	}
	
	static void question6() {
		System.out.println("[QUESTION 6] HashMap for문 탐색하는 방법?");
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("Lee", 1);
		hashMap.put("Beck", 5);
		hashMap.put("Sway", 2);
		hashMap.put("FULL", 2);
		System.out.println("[ANSWER] 1) Iterator를 이용한 방법");
		long startTime = Utils.startElapsed();
		Iterator<String> keys = hashMap.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println("key(iterator.next()) : " + key + " , " + "value : " + hashMap.get(key));
		}
		Utils.endElapsed(startTime);
		System.out.println("[ANSWER] 2) entrySet() => Map.Entry<Key, Value> 방법");
		startTime = Utils.startElapsed();
		for(Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.println("key : " + entry.getKey() + " , " + "value : " + entry.getValue());
		}
		Utils.endElapsed(startTime);
		System.out.println("[ANSWER] 3) keySet() 및 get(key) 방법");
		startTime = Utils.startElapsed();
		for(String key : hashMap.keySet()) {
			System.out.println("key : " + key + " , " + "value : " + hashMap.get(key));
		}
		Utils.endElapsed(startTime);
		System.out.println("[ANSWER] 4) (성능낮음) lambda forEach 방법");
		startTime = Utils.startElapsed();
		hashMap.forEach((key, value) -> {
			System.out.println("key : " + key + " , " + "value : " + value);
		});
		Utils.endElapsed(startTime);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question7() {
		System.out.println("[QUESTION 7] Map에 들어있지 않은 key를 get(key) 호출했을 때 결과?");
		Map<String, Integer> map = new HashMap<String, Integer>();
		String key = "key";
		map.put("key2", 12);
		System.out.println("[ANSWER] get(not have key) result : " + map.get(key));
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question8() {
		System.out.println("[QUESTION 8] map.putIfAbsent() 사용법?");
		Map<String, Integer> map = new HashMap<String, Integer>();
		String key = "KEY";
		String key2 = "KEY2";
		String key3 = "KEY3";
		map.put(key, 12);
		Integer valueKey = map.putIfAbsent(key, 213);
		Integer valueKey2 = map.putIfAbsent(key2, 1234);
		System.out.println("[ANSWER] (key, value) 를 parameter로 사용하는 putIfAbsent 함수는 map에 key가 존재하지 않으면 (key, value)를 put하면서 null 리턴해줍니다. 만약, key가 존재하면 value 리턴해줍니다.");
		System.out.println("(key 존재하는 경우) key's putIfAbsent result : " + valueKey);
		System.out.println("(key 존재하지 않는 경우) key's putIfAbsent(key2, 1234) result : " + valueKey2);
		System.out.println("(key 존재하지 않는 경우) get key2's value : " + map.get(key2));
		System.out.println("[?] value의 type이 Integer인데, int 변수에 return값을 할당해주면 null은 어떻게 처리될까?");
		
		try {
			int valueKey3 = map.putIfAbsent(key3, 213);
			System.out.println("[!] int type = putIfAbsent() result : " + valueKey3);
		}
		catch(Exception e) {
			System.out.println("[!] Catch Exception :: " + e);
		}
		System.out.println("------------------------------------------------------------------------------");
	}
}

class A {
	public String id;
	public String val;
	
	A(String id, String val) {
		this.id = id;
		this.val = val;
	}
}

class B {
	String id;
	String val;
	
	B(String id, String val) {
		this.id = id;
		this.val = val;
	}
	
	/* hashCode, equals 함수를 overriding하여 id값을 key로 삼는 B 객체를 활용할 수 있다. */
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		B nextB = (B) obj;	// 다운캐스팅
		return this.id.equals(nextB.id);
	}
}