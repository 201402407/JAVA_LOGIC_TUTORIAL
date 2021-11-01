package genericType;

public class Sample {
	public static void main(String args[]) {
		question1();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] Generic Type이란?");
		System.out.println("[ANSWER] 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 타입.");
		System.out.println("[ANSWER] 타입의 경계(*, extends 등)를 지정하고 컴파일 시 해당 타입으로 Object를 casting해주는 것.");
		System.out.println("[ANSWER] 그래서, 런타임 시 발생할 수 있는 타입에러를 컴파일 단계에서 검출할 수 있다.");
		System.out.println("------------------------------------------------------------------------------");
	}
}
