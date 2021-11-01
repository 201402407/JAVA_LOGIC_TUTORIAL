package genericType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Sample {
	public static void main(String args[]) {
		question1();
		question2();
		question3();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] Generic Type이란?");
		System.out.println("[ANSWER] 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 타입.");
		System.out.println("[ANSWER] 타입의 경계(*, extends 등)를 지정하고 컴파일 시 해당 타입으로 Object를 casting해주는 것.");
		System.out.println("[ANSWER] 그래서, 런타임 시 발생할 수 있는 타입에러를 컴파일 단계에서 검출할 수 있다.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question2() {
		System.out.println("[QUESTION 2] Generic Type을 사용한 경우와 사용하지 않은 경우 코드");
		System.out.println("[ANSWER] Generic Type 사용한 경우");
		List<String> list = new ArrayList<String>();
		list.add("STRING");
		String temp = list.get(0);
		System.out.println("-> 별도의 Type casting 작업이 필요 없음");
		
		System.out.println("[ANSWER] Generic Type 사용하지 않은 경우");
		List list2 = new ArrayList();
		list2.add("STRING");
		String temp2 = (String) list.get(0);
		System.out.println("-> 별도의 Type casting 작업이 필요함. Generic Type 미지정 시 Object class Type으로 정의되기 때문에");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question3() {
		System.out.println("[QUESTION 3] Generic Type을 사용한 인터페이스");
		GenericInterface<String> genericInterface1 = new GenericInterface<String>() {
			// default class는 Overriding 해도되고 안해도 되니까.
			@Override
			public String getType() {
				Type superClassType = getClass().getGenericInterfaces()[0];
				Type myType = ((ParameterizedType)superClassType).getActualTypeArguments()[0];
				System.out.println("Generic Type인 T에 String을 넣으면 ?? " + myType);
				return GenericInterface.super.getType();
			}
		};
		
		GenericInterface<Integer> genericInterface2 = new GenericInterface<Integer>() {
			// default class는 Overriding 해도되고 안해도 되니까.
			@Override
			public Integer getType() {
				Type superClassType = getClass().getGenericInterfaces()[0];
				Type myType = ((ParameterizedType)superClassType).getActualTypeArguments()[0];
				System.out.println("Generic Type인 T에 Integer를 넣으면 ?? " + myType);
				return GenericInterface.super.getType();
			}
		};
		
		System.out.println("-> String Generic Type 설정한 Interface Overriding");
		genericInterface1.getType();
		System.out.println("-> Integer Generic Type 설정한 Interface Overriding");
		genericInterface2.getType();
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question4() {
		System.out.println("[QUESTION 3] Generic Type을 2개 사용한 클래스");
		System.out.println("-> String Generic Type 설정한 클래스");
//		genericInterface1.getType();
		System.out.println("-> Integer Generic Type 설정한 클래스");
//		genericInterface2.getType();
		System.out.println("------------------------------------------------------------------------------");
	}
}
