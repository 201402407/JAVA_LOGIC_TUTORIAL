package reference;

public class Sample {
	public static void main(String args[]) {
		question1();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] 순환참조의 정의와 예시");
		System.out.println("[ANSWER] 순환참조는 서로가 서로의 객체를 참조하여 그 메소드를 호출하게 될 때 무한루프로 동작하여 오류를 발생하는 것");
		System.out.println("[ANSWER] Spring에서는 보통 A클래스 내 객체 변수에 B클래스 Bean을 주입하고, B클래스 내 객체 변수에 A클래스 Bean을 주입하는 경우에 발생");
		System.out.println("Example : Chicken class <-> Egg class(닭과 달걀의 관계)");
		/* 여기서는 이렇게만 표현했지만, Spring에서는 Bean 객체를 생성자주입하기 때문에 Call Stack에 무한정 쌓인다. */
//		Chicken myChicken = new Chicken();
//		Egg myEgg = new Egg(myChicken);
//		myEgg.growUp();
		System.out.println("------------------------------------------------------------------------------");
	}
}

class Chicken {
	Egg egg;
	
	Chicken() {
		
	}
	
	Chicken(Egg egg) {
		this.egg = egg;
	}
	
	void layEgg() {
			egg.growUp();	// 닭이 달걀을 낳기 위해선 	달걀이 성장해서 닭으로 되야 한다.
	}
}

class Egg {
	Chicken chicken;
	
	Egg(Chicken chicken) {
		this.chicken = chicken;
	}
	
	void growUp() {
		chicken.layEgg();	// 달걀이 자라기 위해선 닭이 달걀을 낳아야 한다.
	}
}
