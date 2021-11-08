package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sample {
	public static void main(String args[]) throws InterruptedException {
		question1();
		question2();
		question3();
		question4();
		question5();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] Optional<T> 클래스란? (Java 8)");
		System.out.println("[ANSWER] 가장 큰 이유는 NPE(NullPointerException)을 방지하기 위해 사용하는 클래스. null이 들어올 수 있는 값을 한 번 감싸는 Wrapper Class.");
		System.out.println("[ANSWER] Optional Class를 통해 null이 들어와도 NPE가 발생하지 않게 해준다.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question2() {
		System.out.println("[QUESTION 2] Optional<T> 생성");
		TempObject nullNameObj = new TempObject(null, null);
		TempObject notNullNameObj = new TempObject("Eternals", null);
		System.out.println("[ANSWER] Optional.ofNullable(param) : param이 null일 수도 있고, 아닐 수도 있다. NPE방지");
		Optional<String> optNull = Optional.ofNullable(nullNameObj.getName());	// null or Not null
		Optional<String> opt = Optional.ofNullable(notNullNameObj.getName());	// null or Not null
		System.out.println("[ANSWER] Optional<T>.orElse(param) : Optional<T>가 null인 경우 param 값 리턴");
		String nullName = optNull.orElse("NULL-NAME!");	// null인 경우 "NULL-NAME!" 리턴
		String notNullName = opt.orElse("NULL-NAME!");	// null인 경우 "NULL-NAME!" 리턴
		System.out.println("-> name(not null) : " + nullName);
		System.out.println("-> name(null) : " + notNullName);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question3() {
		System.out.println("[QUESTION 3] Optional<T> null check 방어코드 활용");
		List<Depth1> depthList = new ArrayList<Depth1>();
//		depthList.add(new Depth1(new Depth2("depth2입니다.")));
		depthList.add(new Depth1(new Depth2(null)));
		TempObject temp = new TempObject(null, depthList);
		System.out.println("[ANSWER] JAVA 8 이전 null 방어코드");
		legacyNullDefense(temp);
		System.out.println("[ANSWER] JAVA 8 Optional null 방어코드");
		optionalNullDefense(temp);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question4() {
		System.out.println("[QUESTION 4] Optional 사용 장단점");
		System.out.println("[ANSWER] 장점 : 코드의 가독성과 안정성은 높이고 코드 분석 시간은 줄일 수 있다.");
		System.out.println("1) 객체가 null이어도 NPE가 발생하지 않고 비즈니스 로직대로 흘러갈 수 있음");
		System.out.println("2) Optional 사용 시 'NULL 값을 받을 수 있다.' 라고 다른 개발자가 인지할 수 있기 때문에 분석 시간 줄일 수 있음");
		System.out.println("3) 비즈니스 코드와 null 방어코드가 뒤섞여 있지 않아 로직을 더 쉽게 파악할 수 있음");
		System.out.println();
		System.out.println("[ANSWER] 단점 : null check 및 Wrapping 시 오버헤드가 발생하여 성능이 저하될 수 있다.");
		System.out.println("-> null이 절대 나오지 않으면 Optional을 사용하지 않는 것이 성능에 더 좋다.");
		System.out.println("-> 즉, 함수 결과가 null이 될 수 있고 이를 인지해서 처리해야할 때 사용하는 것이 좋다.");
		System.out.println("------------------------------------------------------------------------------");
	}

	static void question5() {
		System.out.println("[QUESTION 5] Optional<T> 메소드");
		StringBuilder sb = new StringBuilder("of(T):Optional<T>\r\n"
				+ "-> 파라미터로 받은 객체를 Optional로 감싸 반환한다. 만약 파라미터가 null이면 NPE가 발생한다.\r\n"
				+ "ofNullable(T):Optional<T>\r\n"
				+ "-> 기본적으로 of()와 동일하나 파라미터가 null이면 빈 Optional을 반환한다.\r\n"
				+ "empty():Optional<T>\r\n"
				+ "-> 빈 Optional을 반환한다. Optional 객체의 중간 연산 중에 값이 null이 되면 내부적으로 이 메서드를 호출한다. \r\n"
				+ "\r\n"
				+ "다음으로는 Optional의 중간 연산이다. 중간 연산은 non static 메서드면서 동시에 반환 값이 Optional<T>라는 특징이 있다.\r\n"
				+ "filter(Predicate<? super T> predicate):Optional<T>\r\n"
				+ "-> Stream API의 filter()와 동일하다. predicate의 조건에 맞는 값을 필터링한다.\r\n"
				+ "map(Function<? super T, ? extends U> mapper):Optional<T>\r\n"
				+ "-> Stream API의 map()과 동일하다. Optional로 감싸진 객체를 다른 객체로 변경하도록 데이터 변경을 한다.\r\n"
				+ "flatMap(Function<? super T, Optional<U>> mapper):Optional<T>\r\n"
				+ "-> Optional안의 Optional이 있는 이중 구조일 때, 단일 구조로 변경하여 map()의 기능을 수행할 수 있다.\r\n"
				+ "\r\n"
				+ "이번에는 Optional의 종료 연산이다. 이들은 Optional에서 벗어나 값으로 반환되는 특징이 있다.\r\n"
				+ "get():T\r\n"
				+ "-> Optional의 값을 반환한다. 만약 값이 빈 값이라면 NPE가 발생한다.\r\n"
				+ "orElse(T):T\r\n"
				+ "-> get과 동일한 기능을 수행하지만, 값이 비어있다면 파라미터로 받은 값으로 반환한다.\r\n"
				+ "-> 또한, orElseGet보다 비용이 높고, Optional의 값이 null이든 아니든 항상 param이 호출된다.\r\n"
				+ "orElseGet(Supplier<? extends T> other):T\r\n"
				+ "-> get과 동일한 기능을 수행하지만, 값이 비어있다면 파라미터에서 제공하는 값을 반환한다.\r\n"
				+ "-> 또한, orElse보다 비용이 낮고, Optional의 값이 null이 아닐 경우에만 functional Interface가 호출된다.\r\n"
				+ "orElseThrow(Supplier<? extends X> exceptionSupplier):T\r\n"
				+ "-> get과 동일한 기능을 수행하지만, 값이 비어있다면 파리미터에서 생성한 exception을 발생시킨다. \r\n"
				+ " \r\n"
				+ "마지막으로 분류가 되지 않는 기타 메서드들이다.\r\n"
				+ "isPresent():boolean\r\n"
				+ "-> Optional의 값이 있다면 true, 비어있다면 false를 반환한다. 상태를 확인할 뿐 값에 어떤 영향도 미치지 않는다.\r\n"
				+ "ifPresent(Consumer<? super T> consumer):void\r\n"
				+ "-> Optional의 값이 있다면 파라미터를 실행하고, 비어있다면 false를 반환한다. ");
		System.out.println(sb.toString());
		// 출처 : https://bbubbush.tistory.com/23
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void legacyNullDefense(TempObject temp) {
		String depthStr = "";
		if(temp != null) {
			List<Depth1> tempList = temp.getList();
			if(tempList != null) {
				Depth1 depth1 = tempList.get(0);
				if(depth1 != null) {
					Depth2 depth2 = depth1.getDepth2();
					if(depth2 != null) {
						if(depth2.getDepth() != null) {
							depthStr = depth2.getDepth();
							System.out.println("-> depth의 깊이는 :: " + depthStr);
							return;
						}
					}
				}
			}
		}
		
		depthStr = "값이 없습니다.";
		System.out.println("-> depth의 깊이는 :: " + depthStr);
	}
	
	static void optionalNullDefense(TempObject temp) {
		Optional<TempObject> tempOpt = Optional.ofNullable(temp);
		Optional<List<Depth1>> tempListOpt = tempOpt.map(TempObject::getList);
		Optional<Depth1> depth1Opt = tempListOpt.map(tempList -> tempList.get(0));
		Optional<Depth2> depth2Opt = depth1Opt.map(Depth1::getDepth2);
		Optional<String> depthStrOpt = depth2Opt.map(Depth2::getDepth);
		String depthStr = depthStrOpt.orElseGet(() -> notHaveValue());	// arrow function. functional interface인데, null인 경우만 호출
		System.out.println("-> depth의 깊이는 :: " + depthStr);
		
		System.out.println("[ANSWER] JAVA 8 Optional null 방어코드 -> 파이프라이닝");
		String depth2Str = tempOpt.map(TempObject::getList)
				.map(tempList -> tempList.get(0))
				.map(Depth1::getDepth2)
				.map(Depth2::getDepth).orElse("값이 없습니다.");
		System.out.println("-> depth의 깊이는 :: " + depth2Str);
	}
	
	private static String notHaveValue() {
		return "값이 없습니다.";
	}
}

class TempObject {
	String name;
	List<Depth1> list;
	
	TempObject(String name, List<Depth1> list) {
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public List<Depth1> getList() {
		return list;
	}
}

class Depth1 {
	Depth2 depth2;
	
	Depth1(Depth2 depth2) {
		this.depth2 = depth2;
	}

	public Depth2 getDepth2() {
		return depth2;
	}
}

class Depth2 {
	String depth;
	
	Depth2(String depth) {
		this.depth = depth;
	}
	
	public String getDepth() {
		return depth;
	}
}