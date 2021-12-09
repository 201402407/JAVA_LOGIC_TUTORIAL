package genericType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import genericType.SuperTypeSafeMap.TypeReference;
import genericType.SuperTypeSafeMap.TypeSafeMap;

public class Sample {
	public static void main(String args[]) {
		question1();
		question2();
		question3();
		question4();
		question5();
		question6();
		question7();
		question8();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] Generic Type이란?");
		System.out.println("[ANSWER] 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 타입.");
		System.out.println("[ANSWER] 타입의 경계(*, extends 등)를 지정하고 컴파일 시 해당 타입으로 Object를 casting해주는 것.");
		System.out.println("[ANSWER] 그래서, 런타임 시 발생할 수 있는 타입에러를 컴파일 단계에서 검출할 수 있다.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question2() {
		System.out.println("[QUESTION 2] Generic Type을 사용한 경우와 사용하지 않은 경우");
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
		Dessert3<Orange> d3 = new Dessert3<>();
		d3.getFruitType(new Dessert<Fruit>(new Fruit()));
		System.out.println("-> T extends Comparable<? super RedBanana> : Banana의 조상인 Fruit를 Comparable 한 클래스 사용 가능");
		System.out.println("[!] '?' 와일드카드는 해당 제네릭 타입에 관심이 없고, 타입의 유무에 따른 메소드 사용에 관심이 있을 때.");
		System.out.println("[!] '?' 와일드카드는 보통 데이터보단 메소드. 보통 Object의 메소드를 사용하기 위해. <?> = <? extends Object>");
		System.out.println("[!] 그래서 List<? extends Fruit>는 가능하지만, List<T extends Fruit>는 불가능.");
		System.out.println("[!] ?는 어떤 타입이 오든 관심없기 때문이고, T는 해당 타입의 데이터에 관심이 있기 때문에 해당 타입에 대한 함수 사용 가능");
		System.out.println("ex) T에 Long 타입을 적용했을 때, Long Class의 함수 사용 가능해짐. ?는 사용 불가능(Object 함수만 사용가능)");
		List<?> list = new ArrayList<Long>();
		Dessert<Long> dessert = new Dessert(10L);
		dessert.getDessert().intValue();	// long 타입 사용 가능
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question6() {
		System.out.println("[QUESTION 6] Type Erasure란?");
		System.out.println("[ANSWER] Generic Type이 만들어지기 이전 버전(Java5 미만) 에서도 이상없이 사용하기 위해");
		System.out.println("[ANSWER] Java 컴파일 시 Generic Type 정보를 Erase(제거)하고, Object Class와 casting을 통해 Generic 로직을 실행시킨다.");
		System.out.println("[ANSWER] 그래서 byte code 에는 Generic Type 코드가 없고, 런타임 시에도 없다.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question7() {
		System.out.println("[QUESTION 7] Super Type Token이란?");
		System.out.println("[ANSWER] Generic Type을 가지는 Class를 Generic Type Class로 사용하기 위한 방법");
		System.out.println("[ANSWER] 즉, Reflection의 getGenericSuperClass 함수를 사용해 위 Type Class를 구분지을 수 있게 만드는 Super Class");
		TypeReference<String> strType1 = new TypeReference<String>() {};	// 하위 클래스임을 알리기 위해 객체 생성 시 {} 추가해야함.
		System.out.println("1) Type Created :: String, Get Type :: " + strType1.type.getTypeName());
		TypeReference<Integer> strType2 = new TypeReference<Integer>() {};
		System.out.println("2) Type Created :: Integer, Get Type :: " + strType2.type.getTypeName());
		TypeReference<List<String>> strType3 = new TypeReference<List<String>>() {};
		System.out.println("3) Type Created :: List<String>, Get Type :: " + strType3.type.getTypeName());
		TypeReference<GenericMultiClass<String, Integer>> strType4 = new TypeReference<GenericMultiClass<String, Integer>>() {};
		System.out.println("4) Type Created :: GenericMultiClass<String, Integer>, Get Type :: " + strType4.type.getTypeName());	
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question8() {
		System.out.println("[QUESTION 8] SafeTypeHashMap Class 생성 및 테스트");
		TypeSafeMap map = new TypeSafeMap();
		map.put(new TypeReference<String>() {}, "String Value");
		map.put(new TypeReference<Integer>() {}, 999);
		map.put(new TypeReference<List<String>>() {}, new ArrayList<>());
		map.put(new TypeReference<GenericMultiClass<String, Integer>>() {}, new GenericMultiClass<>("String Key", 9999));
		System.out.println("[ANSWER] String Type get :: " + map.get(new TypeReference<String> () {}));
		System.out.println("[ANSWER] Integer Type get :: " + map.get(new TypeReference<Integer> () {}));
		System.out.println("[ANSWER] List<String> Type get :: " + map.get(new TypeReference<List<String>> () {}));
		System.out.println("[ANSWER] GenericMultiClass<String, Integer> Type get :: " + map.get(new TypeReference<GenericMultiClass<String, Integer>> () {}));
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
