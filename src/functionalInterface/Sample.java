package functionalInterface;

import java.util.function.Consumer;

// 함수형 인터페이스(JAVA 8 이상)
public class Sample {
	public static void main(String args[]) {
		System.out.println("[QUESTION 1] Functional Interface란?");
		System.out.println("[ANSWER] 1) 함수를 마치 1급 객체처럼 활용할 수 있게 만드는 인터페이스");
		System.out.println("[ANSWER] 2) 단일 추상 메소드를 가지는 인터페이스. 추후, 인터페이스를 구현하여 순수 함수 및 익명 함수, 람다식으로 활용하기 위함");
		System.out.println("------------------------------------------------------------------------------");
		
		// 일반적인 인터페이스 구현 클래스와 함수형 인터페이스로 구현한 클래스의 코드 차이는?
		question2();
		
		// Consumer 함수형 인터페이스 설명 및 예제
		question3();
	}
	
	static void question2() {
		System.out.println("[QUESTION 2] 일반적인 인터페이스 구현 클래스와 함수형 인터페이스로 구현한 클래스의 코드 차이는?");
		System.out.println("[ANSWER] (일반적인 경우) SaltIdSetter 인터페이스를 구현한 LoginSaltIdSetter, 이를 생성자 내에서 활용한 LoginHashIdLegacy class 참고");
		String id = "LEEHAEWON";
		System.out.println("parameter id : " + id);
		System.out.println("loginHashid : " + new LoginHashIdLegacy(id).loginHashId);
		System.out.println("[ANSWER] (함수형 인터페이스 활용한 경우) @FunctionalInterface SaltIdSetter 인터페이스를 구현한 LoginHashId class 참고");
		System.out.println("parameter id : " + id);
		System.out.println("loginHashid : " + new LoginHashId(id).loginHashId);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question3() {
		System.out.println("[QUESTION 3] Consumer 함수형 인터페이스 설명 및 예제");
		System.out.println("[ANSWER] Parameter O, Return X. accept 추상 메소드를 통해 함수형 인터페이스 호출가능");
		String code = "Consumer<String> consumer = (str) -> System.out.println('이거슨 Consumer, parameter: ' + str);";
		System.out.println(code);
		System.out.print("Consumer.accept('consumer') \n-> ");
		Consumer<String> consumer = (str) -> System.out.println("이거슨 Consumer, parameter: " + str);
		consumer.accept("consumer");
		System.out.println("------------------------------------------------------------------------------");
	}
}

/* 일반적인 인터페이스 구현 로직 */
//인터페이스 구현한 클래스
class LoginSaltIdSetter implements SaltIdSetter {
	@Override
	public String setSaltId(String str) {
		return "SALT_" + str;
	}
}
class LoginHashIdLegacy  {
	String id;
	String loginHashId;
	
	LoginHashIdLegacy(String id) {
		this.id = id;
		loginHashId = getLoginHashId(new LoginSaltIdSetter()); // 인터페이스를 파라미터로 구현한 함수
	}
	
	public String getLoginHashId(SaltIdSetter saltId) {
		System.out.println("saltId : " + saltId.setSaltId(this.id));
		String loginHashId = String.valueOf(saltId.setSaltId(this.id).hashCode());
		return loginHashId;
	}
}

// 함수형 인터페이스 구현한 클래스 코드
class LoginHashId {
	String id;
	String loginHashId;
	
	LoginHashId(String id) {
		this.id = id;
		
		// 1) 익명 inner class를 사용한 함수형 인터페이스 활용 로직
		loginHashId = getLoginHashId(new SaltIdSetter() {
			
			@Override
			public String setSaltId(String str) {	// 이 클래스에서는 이렇게 id에 소금을 친다.(=해당 클래스에서 여기서만 활용, 불변)
				return "SALT_" + str;
			}
		});
		
		// 2) 람다 표현식을 활용한 함수형 인터페이스 활용 로직
		loginHashId = getLoginHashId((str) -> "SALT_" + str);
	}
	
	// 어차피 해당 인터페이스는 여기서만 일급 객체로 함수를 parameter로 받기 때문에
	public String getLoginHashId(SaltIdSetter saltId) {
		System.out.println("saltId : " + saltId.setSaltId(this.id));
		String loginHashId = String.valueOf(saltId.setSaltId(this.id).hashCode());
		return loginHashId;
	}
}