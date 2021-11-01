package genericType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

interface Delicious {}

public class Dessert<T> {
	T myDessert;
	
	Dessert(T t) {
		this.myDessert = t;
	}
	
	public T getDessert() {
		return this.myDessert;
	}
	
	public void setDessert(T t) {
		this.myDessert = t;
	}
}

//Apple Class 상속한 클래스 Type 가능
//Dessert class를 상속받은 Dessert1 class 
class Dessert1<T extends Apple> extends Dessert<T> {
	T myDessert1;
	
	Dessert1(T t) {
		super(t);
		this.myDessert1 = t;
	}
}

// Apple Class 상속, Delicious 구현한 Type 가능
// Dessert class를 상속받은 Dessert2 class 
class Dessert2<T extends Apple & Delicious> extends Dessert<T> {
	T myDessert2;
	
	Dessert2(T t) {
		super(t);
		this.myDessert2 = t;
	}
}

// (RedBanana 포함) RedBanana의 부모 및 조상 클래스와 Comparable 하는 인터페이스를 구현한 Class를 Generic Type으로 사용 가능
class Dessert3<T extends Comparable<? super RedBanana>> {
	public static void getFruitType(Dessert<? super Banana> dessert) {
		// reflection 활용
		Type superTypeClass = dessert.getClass().getClass();
		if (!(superTypeClass instanceof ParameterizedType)) {  // sanity check
            throw new IllegalArgumentException("TypeReference는 항상 실제 타입 파라미터 정보와 함께 생성되어야 합니다.");
        }
		Type superType = ((ParameterizedType) superTypeClass).getActualTypeArguments()[0];
		System.out.println("Dessert<? super Banana> parameter 객체 타입 :: " + superType);
	}
}