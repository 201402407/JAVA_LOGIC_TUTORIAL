package hashMap;

import java.util.HashMap;

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
		HashMap<A, String> aMap = new HashMap<A, String>();
		HashMap<B, String> bMap = new HashMap<B, String>();
		
		// 1) HashMap에 들어있지 않은 원소를 get한 경우 어떤 결과가 출력될까?
		System.out.println("[QUESTION 1] HashMap에 들어있지 않은 원소를 get한 경우 어떤 결과가 출력될까?");
		HashMap<Integer, Integer> q1 = new HashMap<Integer, Integer>();
		q1.put(1, 1);
		System.out.println("[ANSWER] " + q1.get(2));
		System.out.println("------------------------------------------------------------------------------");
		
		// 2) 클래스 객체를 key로 구분할 수 있을까?
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
		
		// 3) 내부 변수가 같은 클래스 객체를 key로 구분할 수 있을까?
		System.out.println("[QUESTION 3] 내부 변수가 같은 클래스 객체를 key로 구분할 수 있을까?");
		A aa1 = new A("1", "1");
		aMap.put(aa1, "aa1");
		System.out.println("key new Object(same id, same val) get : " + aMap.get(new A("1", "1")));
		System.out.println("[ANSWER] 객체의 내부 변수 값이 일치해도 객체 주소 자체가 다르기 때문에(주소를 hash한 값이 key) 꺼낼 수 없다.");
		System.out.println("------------------------------------------------------------------------------");
				
		// 4) hashCode와 equals 함수를 Overriding한 클래스 객체를 key로 했을 때, 꺼낼 수 있는 방법은?
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