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
		question4();
		question5();
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
		System.out.println("[QUESTION 4] Generic Type을 2개 사용한 클래스");
		System.out.println("-> <String, Integer> Generic Type 설정한 클래스");
		GenericMultiClass<String, Integer> g1Class = new GenericMultiClass<String, Integer>("KEY1", 1);
		System.out.println("Key : " + g1Class.getKey() + ", Type :: " + g1Class.getKey().getClass().getTypeName());
		System.out.println("Value : " + g1Class.getValue() + ", Type :: " + g1Class.getValue().getClass().getTypeName());
		System.out.println("-> <Integer, String> Generic Type 설정한 클래스");
		GenericMultiClass<Integer, String> g2Class = new GenericMultiClass<Integer, String>(2, "VALUE2");
		System.out.println("Key : " + g2Class.getKey() + ", Type :: " + g1Class.getKey().getClass().getTypeName());
		System.out.println("Value : " + g2Class.getValue() + ", Type :: " + g1Class.getValue().getClass().getTypeName());
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question5() {
		System.out.println("[QUESTION 5] 제한된 Generic Type 클래스 사용");
		System.out.println("[ANSWER] 1) 특정 타입 및 특정 타입의 자손들만 제네릭 타입으로 사용 가능");
		System.out.println("-> Dessert1<T extends Apple> : Apple 및 Apple을 상속받는 GreenApple class 또한 Type 가능");
		Dessert1<GreenApple> d1 = new Dessert1<>(new GreenApple());
		System.out.println("Dessert1<GreenApple>의 지역변수 T의 Type :: " + d1.getDessert().getClass().getTypeName());
		System.out.println("-> Dessert1<T extends Apple & Delicious> : Apple을 상속받고 Delicious 인더페이스를 구현하는 HoneyApple class 가능");
		Dessert2<HoneyApple> d2 = new Dessert2<>(new HoneyApple());
		System.out.println("Dessert2<HoneyApple>의 지역변수 T의 Type :: " + d2.getDessert().getClass().getTypeName());
		System.out.println();
		System.out.println("[ANSWER] 2) 특정 타입 및 특정 타입의 조상(부모)들만 제네릭 타입으로 사용 가능");
		System.out.println("-> Dessert<? super Banana> : Banana의 조상인 Fruit 가능");
		Dessert3 d3 = new Dessert3();
		d3.getFruitType(new Dessert<Fruit>(new Fruit()));
		System.out.println("------------------------------------------------------------------------------");
	}
	
	
	
//	public static void getKeyValueType(Class clazz) {
//		// java reflection 사용
//		ParameterizedType type;
//		try {
//			type = (ParameterizedType) clazz.getField("key").getGenericType();
//			System.out.println(type.getActualTypeArguments()[0]);
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//		
//		
////		for(Field f : clazz.getDeclaredFields()) {
////			System.out.println("Declared Field(필드 선언형) Type :: " + f.getGenericType());
//////			ParameterizedType type = (ParameterizedType) f.getGenericType();	// 파라미터화된 타입
////			System.out.println("-> Parameterized(파라미터화된 형) Type :: " + type.getTypeName());
//////			Type myType = type.getActualTypeArguments()[0];
//////			System.out.println("-> Actual Generic(실제 선언된 제네릭) Type :: " + myType);
////		}
//	}
}
