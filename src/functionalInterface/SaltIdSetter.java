package functionalInterface;

// 함수형 인터페이스 : 단일 추상 메소드를 가지는 인터페이스. 추후, 인터페이스를 구현하여 순수 함수 및 익명 함수, 람다식으로 활용하기 위함
@FunctionalInterface
public interface SaltIdSetter {
	// string 값에 salt Id 값 추가(구현 클래스가 알아서 구현)
	String setSaltId(String str);
}
