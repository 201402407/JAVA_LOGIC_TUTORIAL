package genericType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 슈퍼타입토큰을 활용한 TypeSafeMap Class
public class SuperTypeSafeMap {
	static class TypeSafeMap {
		Map<TypeReference<?>, Object> map = new HashMap<>();
		
		<T> void put(TypeReference<T> tr, T value) {
			map.put(tr, value);
		}
		
		<T> T get(TypeReference<T> tr) {
			if(tr.type instanceof Class<?>) {
				return ((Class<T>) tr.type).cast(map.get(tr));	// 단순 Class를 Type에 넣은 경우 get 후 casting
			}
			else {	// Super Class(ex. List<Integer>) 를 Type에 넣은 경우 
				return ((Class<T>) ((ParameterizedType) tr.type).getRawType()).cast(map.get(tr));
			}
		}
	}
	// super class type 획득
	static abstract class TypeReference<T> {	// 객체 생성되지 않게 추상클래스로 변경
		Type type;	// java reflection
		
		protected TypeReference() {
			Type sType = getClass().getGenericSuperclass();
			if(sType instanceof ParameterizedType) {
				this.type = ((ParameterizedType) sType).getActualTypeArguments()[0];	// Super Class Type 꺼내기
			}
			else {
				throw new RuntimeException();
			}
		}
		
		// Reflection Type을 구분짓기 위해 Overriding한 hashcode로 판별
		@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
            TypeReference<?> that = (TypeReference<?>)o;
            return type.equals(that.type);
        }
		
		// Reflection의 Type으로 구분짓기 위해 Type을 hashCode로 설정
		@Override
		public int hashCode() {
			return Objects.hash(type);
		}
	}
}
