## 자바의 기본기를 다지는 가이드 및 튜토리얼

    [!] 자바의 기초 문법과 지식이 부족하다면?

    [!] 자바 코딩 중 헷갈리는 부분이 있다면?

    [!] 자바를 좀 더 DEEP하게 파고싶다면?

    [!] 자바의 NEW TECH LOGIC을 공부하고싶다면?

## 1. Tutorial Init

-   ### IDE
    -   Eclipse IDE(2020-06 (4.16.0))
    -   VS Code
-   ### Language
    -   Java 17

## 2. Tutorial List

### ** Interface와 Implement Class 활용 **

<br>
<details>
  <summary>  [QUESTION 1] 인터페이스 객체에 구현한 클래스 인스턴스 주입 가능?</summary>
  <br>
  <p>[ANSWER] 가능!</p>
</details>
<details>
  <summary>  [QUESTION 2] 인터페이스 객체의 getClass는?</summary>
    <br>
  <p>[ANSWER] samsungPhone 객체는 class interfaceSample.Samsung 클래스 입니다. <br>
[ANSWER] iPhone 객체는 class interfaceSample.IPhone 클래스 입니다.</p>
</details>
<details>
  <summary>  [QUESTION 3] 인터페이스 객체지만 구현 클래스 인스턴스가 들어가있으면, 구현 클래스의 메소드가 호출하는지?</summary>
    <br>
  <p>RESULT(samsung) : class interfaceSample.Samsung의 전화 메소드 호출!<br>
RESULT(ihpone) : class interfaceSample.IPhone의 전화 메소드 호출!
[ANSWER] 정상 호출됨!<br>
[ANSWER] iPhone 객체는 class interfaceSample.IPhone 클래스 입니다.</p>
</details>
<details>
  <summary>  [QUESTION 4] 어떠한 구현 클래스간에 인스턴스의 상수와 static 메소드 호출 가능?</summary>
    <br>
  <p>[!] 상수 호출<br>
samsung's TYPE : ELECTRONIC<br>
iPhone's TYPE : ELECTRONIC<br>
[!] static 메소드 호출<br>
samsung's telNo : X<br>
iPhone's telNo :  X<br>
SmartPhone's telNo : 010-1111-2222<br>
[ANSWER] 인터페이스 클래스로만 호출 가능(static 이니까)<br>
RESULT(ihpone) : class interfaceSample.IPhone의 전화 메소드 호출!<br>
[ANSWER] 정상 호출됨!<br>
[ANSWER] iPhone 객체는 class interfaceSample.IPhone 클래스 입니다.</p>
</details>
<details>
  <summary>  [QUESTION 5] Overriding한 default 메소드와 안한 default 메소드 호출 결과?</summary>
    <br>
  <p>[ANSWER] samsungPhone(Overriding) serialId : Samsung의 hashCode : 106642798<br>
[ANSWER] iPhone(Not Overriding) serialId : 106642798</p>
</details>
<details>
  <summary>  [QUESTION 6] 구현 클래스에서 생성한 메소드를 구현 클래스를 주입한 인터페이스 객체에서 사용할 수 있을까?</summary>
    <br>
  <p>[ANSWER] 인터페이스에서 정의되지 않았기 때문에 사용할 수 없다. 대신, downCasting을 통해 활용할 수 있다.<br>
(samsung) whoIsMyBestLeader : 이재용<br>
(iPhone) whoIsMyBestLeader : Steve Jobs</p>
</details>

<br/>

### ** Functional Interface **

<br>
<details>
  <summary>  [QUESTION 1] Functional Interface(함수형 인터페이스)란?</summary>
  <br>
  <p>[ANSWER] 1) 함수를 마치 1급 객체처럼 활용할 수 있게 만드는 인터페이스<br>
[ANSWER] 2) 단일 추상 메소드를 가지는 인터페이스. 추후, 인터페이스를 구현하여 순수 함수 및 익명 함수, 람다식으로 활용하기 위함</p>
</details>
<details>
  <summary>  [QUESTION 2] 일반적인 인터페이스 구현 클래스와 함수형 인터페이스로 구현한 클래스의 코드 차이는?</summary>
  <br>
  <p>[ANSWER] (일반적인 경우) SaltIdSetter 인터페이스를 구현한 LoginSaltIdSetter, 이를 생성자 내에서 활용한 LoginHashIdLegacy class 참고<br>
parameter id : LEEHAEWON<br>
saltId : SALT_LEEHAEWON<br>
loginHashid : 1507284685<br>
[ANSWER] (함수형 인터페이스 활용한 경우) @FunctionalInterface SaltIdSetter 인터페이스를 구현한 LoginHashId class 참고<br>
parameter id : LEEHAEWON<br>
saltId : SALT_LEEHAEWON<br>
saltId : SALT_LEEHAEWON<br>
loginHashid : 1507284685</p>
</details>
<details>
  <summary>  [QUESTION 3] Consumer 함수형 인터페이스 설명 및 예제</summary>
  <br>
  <p>[ANSWER] Parameter O, Return X. accept 추상 메소드를 통해 함수형 인터페이스 호출가능<br>
[ANSWER] T -> void<br>
Consumer<String> consumer = (str) -> System.out.println('이거슨 Consumer, parameter: ' + str);<br>
Consumer.accept('consumer') <br>
-> 이거슨 Consumer, parameter: consumer</p>
</details>
<details>
  <summary>  [QUESTION 4] Predicate 함수형 인터페이스 설명 및 예제</summary>
  <br>
  <p>[ANSWER] return type이 boolean(True / False). test 추상 메소드를 통해 함수형 인터페이스 호출가능<br>
[ANSWER] T -> boolean<br>
Predicate<String> predicate = (str) -> str.equals('True');<br>
Predicate.test('False') -> false</p>
</details>
<details>
  <summary>  [QUESTION 5] Supplier 함수형 인터페이스 설명 및 예제</summary>
  <br>
  <p>[ANSWER] 공급자. parameter는 없고, return 값만 존재. get 추상 메소드를 통해 함수형 인터페이스 호출가능. 대괄호 안에 return 필수<br>
[ANSWER] () -> T<br>
Supplier<String> supplier = () -> { return supplierStr + ' Supplier !! '; }<br>
Supplier.get() -> This is Supplier !! </p>
</details>
<details>
  <summary>  [QUESTION 6] BiConsumer 함수형 인터페이스 설명 및 예제</summary>
  <br>
  <p>[ANSWER] parameter는 2개가 존재하고, Return X. accept(param1, param2) 추상 메소드를 통해 함수형 인터페이스 호출가능.<br>
[ANSWER] Supplier 만 제외한 나머지엔 Bi가 존재<br>
BiConsumer<String, String> biConsumer = (param1, param2) -> { System.out.print(param1 + param2); }<br>
BiConsumer.get(param1, param2) -> This is(param1) BiConsumer !!(param2)</p>
</details>

<br/>

### ** HashMap Java Collection **

<br>
<details>
  <summary>  [QUESTION 1] HashMap에 들어있지 않은 원소를 get한 경우 어떤 결과가 출력될까?</summary>
  <br>
  <p>[ANSWER] null</p>
</details>
<details>
  <summary>  [QUESTION 2] 클래스 객체를 key로 구분할 수 있을까?</summary>
  <br>
  <p>a1 객체를 key로 put.<br>
a2 객체를 key로 put.<br>
key a1 get : a1 value<br>
key a1's same id object(a4) get : null<br>
key a2 get : a2 value<br>
key a2's same id object(a3) get : null<br>
[ANSWER] 같은 객체를 get하면 객체의 주소를 hash한 값을 hash buckets에 key로 넣기 때문에 해당 object key의 value를 꺼낼 수 있다.</p>
</details>
<details>
  <summary>  [QUESTION 3] 내부 변수가 같은 클래스 객체를 key로 구분할 수 있을까?</summary>
  <br>
  <p>key new Object(same id, same val) get : null<br>
[ANSWER] 객체의 내부 변수 값이 일치해도 객체 주소 자체가 다르기 때문에(주소를 hash한 값이 key) 꺼낼 수 없다.</p>
</details>
<details>
  <summary>  [QUESTION 4] (id 변수값 기준) hashCode와 equals 함수를 Overriding한 클래스 객체를 key로 했을 때, 꺼낼 수 있는 방법은?</summary>
  <br>
  <p>b1 객체를 key로 put.<br>
[ANSWER] key로 넣은 객체로 get : b1<br>
[ANSWER] id값 일치, val값 일치 한 new 객체를 key로 get  : b1<br>
[ANSWER] id값 일치, val값 불일치 한 new 객체를 key로 get  : b1<br>
[ANSWER] id값 불일치, val값 일치 한 new 객체를 key로 get  : null<br>
[ANSWER] id값 불일치, val값 불일치 한 new 객체를 key로 get  : null</p>
</details>
<details>
  <summary>  [QUESTION 5] Map에 들어있는 key의 value 값(기본형)을 변경시키고 싶을 때 사용하는 방법은?</summary>
  <br>
  <p>get한 value 값 수정? -> X<br>
[ANSWER] put(get()~) 로 꺼낸 값을 다시 put해서 갱신시킨다.<br>
갱신 이전 value : 1<br>
갱신 이후 value : 2</p>
</details>
<details>
  <summary>  [QUESTION 6] HashMap for문 탐색하는 방법?</summary>
  <br>
  <p>[ANSWER] 1) Iterator를 이용한 방법  <br>
[ELAPSED] CHECK START!<br>
key(iterator.next()) : Beck , value : 5<br>
key(iterator.next()) : Sway , value : 2<br>
key(iterator.next()) : Lee , value : 1<br>
key(iterator.next()) : FULL , value : 2<br>
[ELAPSED] 0(ms) FINISHED.<br>
[ANSWER] 2) entrySet() => Map.Entry<Key, Value> 방법<br>
[ELAPSED] CHECK START! (이하 생략)<br>
[ELAPSED] 0(ms) FINISHED.<br>
[ANSWER] 3) keySet() 및 get(key) 방법<br>
[ELAPSED] CHECK START! (이하 생략)<br>
[ELAPSED] 0(ms) FINISHED.<br>
[ANSWER] 4) (성능낮음) lambda forEach 방법<br>
[ELAPSED] CHECK START! (이하 생략)<br>
[ELAPSED] 24(ms) FINISHED.</p>
</details>
<details>
  <summary>  [QUESTION 7] Map에 들어있지 않은 key를 get(key) 호출했을 때 결과?</summary>
  <br>
  <p>[ANSWER] get(not have key) result : null</p>
</details>
<details>
  <summary>  [QUESTION 8] map.putIfAbsent() 사용법?</summary>
  <br>
  <p>[ANSWER] (key, value) 를 parameter로 사용하는 putIfAbsent 함수는 map에 key가 존재하지 않으면 (key, value)를 put하면서 null 리턴해줍니다. 만약, key가 존재하면 value 리턴해줍니다.<br>
(key 존재하는 경우) key's putIfAbsent result : 12<br>
(key 존재하지 않는 경우) key's putIfAbsent(key2, 1234) result : null<br>
(key 존재하지 않는 경우) get key2's value : 1234<br>
[?] value의 type이 Integer인데, int 변수에 return값을 할당해주면 null은 어떻게 처리될까?<br>
[!] Catch Exception :: java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "java.util.Map.putIfAbsent(Object, Object)" is null</p>
</details>
<details>
  <summary>  [QUESTION 9] computeIfAbsent와 computeIfPresent의 차이는?</summary>
  <br>
  <p>[ANSWER] computeIfAbsent(key, function) : key의 값이 없을 경우에만 parameter로 받은 함수(람다식) 실행<br>
key의 값이 존재하지 않으면, 해당 key에 해당하는 value 200인 값을 map에 put ::: 200<br>
[ANSWER] computeIfPresent(key, function) : key의 값이 있을 경우에만 parameter로 받은 함수(람다식) 실행<br>
key의 값이 존재하면, value * value 값을 리턴 ::: 40000</p>
</details>

<br/>

### ** Reference(참조) **

<br>
<details>
  <summary>  [QUESTION 1] 순환참조의 정의와 예시</summary>
  <br>
  <p>[ANSWER] 순환참조는 서로가 서로의 객체를 참조하여 그 메소드를 호출하게 될 때 무한루프로 동작하여 오류를 발생하는 것<br>
[ANSWER] Spring에서는 보통 A클래스 내 객체 변수에 B클래스 Bean을 주입하고, B클래스 내 객체 변수에 A클래스 Bean을 주입하는 경우에 발생<br>
Example : Chicken class <-> Egg class(닭과 달걀의 관계)</p>
</details>

<br/>

### ** Generic Type(제네릭 타입) **

<br>
<details>
  <summary>  [QUESTION 1] Generic Type이란?</summary>
  <br>
  <p>[ANSWER] 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 타입.<br>
[ANSWER] 타입의 경계(*, extends 등)를 지정하고 컴파일 시 해당 타입으로 Object를 casting해주는 것.<br>
[ANSWER] 그래서, 런타임 시 발생할 수 있는 타입에러를 컴파일 단계에서 검출할 수 있다.</p>
</details>
<details>
  <summary>  [QUESTION 2] Generic Type을 사용한 경우와 사용하지 않은 경우</summary>
  <br>
  <p>[ANSWER] Generic Type 사용한 경우<br>
-> 별도의 Type casting 작업이 필요 없음<br>
[ANSWER] Generic Type 사용하지 않은 경우<br>
-> 별도의 Type casting 작업이 필요함. Generic Type 미지정 시 Object class Type으로 정의되기 때문에</p>
</details>
<details>
  <summary>  [QUESTION 3] Generic Type을 사용한 인터페이스</summary>
  <br>
  <p>-> String Generic Type 설정한 Interface Overriding
Generic Type인 T에 String을 넣으면 ?? class java.lang.String
-> Integer Generic Type 설정한 Interface Overriding
Generic Type인 T에 Integer를 넣으면 ?? class java.lang.Integer</p>
</details>
<details>
  <summary>  [QUESTION 4] Generic Type을 2개 사용한 클래스</summary>
  <br>
  <p>-> <String, Integer> Generic Type 설정한 클래스<br>
Key : KEY1, Type :: java.lang.String<br>
Value : 1, Type :: java.lang.Integer<br>
-> <Integer, String> Generic Type 설정한 클래스<br>
Key : 2, Type :: java.lang.String<br>
Value : VALUE2, Type :: java.lang.Integer</p>
</details>
<details>
  <summary>  [QUESTION 5] Generic Type을 사용한 인터페이스</summary>
  <br>
  <p>
[ANSWER] 1) 특정 타입 및 특정 타입의 자손들만 제네릭 타입으로 사용 가능<br>
-> Dessert1<T extends Apple> : Apple 및 Apple을 상속받는 GreenApple class 또한 Type 가능<br>
Dessert1<GreenApple>의 지역변수 T의 Type :: genericType.GreenApple<br>
-> Dessert1<T extends Apple & Delicious> : Apple을 상속받고 Delicious 인더페이스를 구현하는 HoneyApple class 가능<br>
Dessert2<HoneyApple>의 지역변수 T의 Type :: genericType.HoneyApple<br>
<br>
[ANSWER] 2) 특정 타입 및 특정 타입의 조상(부모)들만 제네릭 타입으로 사용 가능<br>
-> Dessert<? super Banana> : Banana의 조상인 Fruit 가능<br>
Dessert<? super Banana> parameter 객체 타입 :: genericType.Fruit<br>
-> T extends Comparable<? super RedBanana> : Banana의 조상인 Fruit를 Comparable 한 클래스 사용 가능<br>
[!] '?' 와일드카드는 해당 제네릭 타입에 관심이 없고, 타입의 유무에 따른 메소드 사용에 관심이 있을 때.</p>
</details>

<br/>

### ** ThreadLocal **

<br>
<details>
  <summary>  [QUESTION 1] ThreadLocal이란?</summary>
  <br>
  <p>[ANSWER] 일종의 쓰레드 지역변수. 오직 하나의 쓰레드에 의해 읽고 쓸 수 있는 변수로서, 다른 각각의 쓰레드가 하나의 ThreadLocal을 호출해도 서로 다른 값을 바라본다.<br>
[ANSWER] Thread의 정보를 Key로 하는 Map 형식으로 데이터를 저장해두고 사용하는 자료구조.<br>
[ANSWER] ThreadPool 사용하여 Thread 재활용 시 이전에 저장된 ThreadLocal을 호출하게 되므로 모든 ThreadLocal 사용 후 remove 필수.</p>
</details>
<details>
  <summary>  [QUESTION 2] ThreadLocal은 보통 언제 사용하는지?</summary>
  <br>
  <p>[ANSWER] 1) 사용자 인증정보 - Spring Security에서 사용자마다 다른 사용자 인증 정보 세션을 사용할 때.<br>
[ANSWER] 2) 트랜잭션 컨텍스트 - 트랜잭션 매니저가 트랜잭션 컨텍스트를 전파할 때.</p>
</details>
<details>
  <summary>  [QUESTION 3] ThreadLocal 사용법</summary>
  <br>
  <p>[ANSWER] 1) ThreadLocal 객체 생성<br>
[?] ThreadLocal Generic Type 사용 가능할까?<br>
-> ThreadLocal Generic Type 사용 가능(<>로 사용방법 동일)<br>
[?] ThreadLocal Class의 Default 초기값 설정 방법?<br>
-> ThreadLocal에서 initialValue method를 Override 하면 이 ThreadLocal 변수를 사용하는 모든 쓰레드의 default값이 존재한다.<br>
-> 즉, 별도의 set 함수로 값 설정하기 전에도 get으로 동일한 default값을 꺼내 사용할 수 있다.<br>
[ANSWER] 2) 현재 ThreadLocal에 값 저장(.set())<br>
[ANSWER] 3) 현재 ThreadLocal에 값 불러오기(.get())<br>
[ANSWER] 4) 사용 완료 후 ThreadLocal 값 삭제(.remove())</p>
</details>
<details>
  <summary>  [QUESTION 4] ThreadLocal 사용 예시</summary>
  <br>
  <p>[ANSWER] 1) Runnable 인터페이스 구현(MyRunnable) -> threadLocal에 랜덤 값 저장<br>
[ANSWER] 2) 하나의 Runnable 객체를 2개의 쓰레드에 담기<br>
[ANSWER] 3) 각 쓰레드 run 시 두 쓰레드에 다른 값이 담기는지 확인(쓰레드 별 ThreadLocal에 랜덤 값이 담기기 때문에 다르다.)<br>
thread1 get 결과 :: 37<br>
thread2 get 결과 :: 87</p>
</details>
<details>
  <summary>  [QUESTION 5] InheritableThreadLocal이란?</summary>
  <br>
  <p>[ANSWER] 부모 쓰레드에서 생성된 ThreadLocal을 자식 쓰레드에서도 동일한 값으로 사용할 수 있는 ThreadLocal Class.<br>
-> Servlet에서는 사용하면 안되는데,<br>
-> 1) Request가 ThreadPool에서 처리된다는 점<br>
-> 2) 메모리 누수(Memory Leak) 발생 => 자식 쓰레드도 사용하기 때문에 매 순간의 remove가 발생하지 않기 때문에<br>
[ANSWER] Thread 생성자 또는 Runnable 구현 시 함수 내부에서 inheritableThreadLocal.set()을 통해 값을 저장하면 해당 쓰레드의 자식 쓰레드도 사용 가능<br>
========== [Thread-2] START ==========<br>
threadLocal get :: [Thread-2] ThreadLocal Value<br>
inheritableThreadLocal get :: [Thread-2] InheritableThreadLocal Value<br>
========== [Thread-4 - ChildThread] START ==========<br>
threadLocal get :: null<br>
inheritableThreadLocal get :: [Thread-2] InheritableThreadLocal Value<br>
========== [Thread-3] START ==========<br>
threadLocal get :: null<br>
inheritableThreadLocal get :: null</p>
</details>

<br/>

### ** Thread-Safety **

<br>
<details>
  <summary>  [QUESTION 1] Thread-Safety 하다는 것은 어떤 의미인지?</summary>
  <br>
  <p>[ANSWER] 멀티 쓰레딩 프로그래밍에서 여러 쓰레드가 어떤 객체, 함수, 변수에 접근하게 되도 동작 결과에 아무런 문제가 발생하지 않는 것(= 어디서든 수행 결과가 올바른 것)</p>
</details>
<details>
  <summary>  [QUESTION 2] Thread-Safety를 구현할 수 있는 방법은?</summary>
  <br>
  <p>[ANSWER] 1) Re-entrancy 방법<br>
-> 어떤 쓰레드가 함수를 호출해 실행중일 때 다른 쓰레드가 함수를 호출해도 두 결과가 올바르게 나와야 한다.<br>
-> 즉, 여러 쓰레드가 동시에 함수를 호출해도 올바른 결과가 나와야 한다.<br>
-> 공유하는 자원 없이 독립적으로 실행가능한 코드를 설계하기<br>
[ANSWER] 2) Thread-local Storage 방법<br>
-> 공유 자원 사용을 줄이기 위해 각각 스레드에서만 접근 가능한 ThreadLocal을 사용한다.<br>
[ANSWER] 3) Mutual Exclusion(상호 배제) 방법<br>
-> Semaphore(세마포어)나 Synchronize, lock 등 공유 자원의 접근을 통제한다.<br>
[ANSWER] 4) Atomic operations 방법<br>
-> 데이터의 상태 변경 전/후 에만 접근이 가능하다.<br>
-> 데이터를 변경하는 순간에는 다른 변경 접근이 불가능하다.<br>
-> ex) ++, +=와 같이 +와 =이 한 코드에 있는 것</p>
</details>
<details>
  <summary>  [QUESTION 3] Not Thread-safe 한 경우(동기화X)</summary>
  <br>
  <p>[ANSWER] not thread-safety 하기 때문에 매 번 잔액 결과가 다르다. (동작 결과는 생략!)</p>
</details>
<details>
  <summary>  [QUESTION 4] Synchronized 방법 중 synchronized 함수를 만들어 사용</summary>
  <br>
  <p>[ANSWER] thread-safety 하기 때문에 잔액 결과가 같다.(Thread1, 2 실행 시간에 따라 누가 어떤 잔액을 가지는지는 달라지지만, 결과는 동일하다)<br>
[ANSWER] Synchronized는 객체 내부 전체에 lock을 걸기 때문에, 다른 쓰레드는 객체 자체를 사용하려면 기다려야 한다. (동작 결과는 생략!)</p>
</details>
<details>
  <summary>  [QUESTION 5] Synchronized 방법 중 synchronized lock을 만들어 사용</summary>
  <br>
  <p>[ANSWER] thread-safety 하기 때문에 잔액 결과가 같다.(Thread1, 2 실행 시간에 따라 누가 어떤 잔액을 가지는지는 달라지지만, 결과는 동일하다)<br>
[ANSWER] 함수 내부에 별도 객체를 만들어 lock을 걸기 때문에, 다른 쓰레드는 해당 함수 내부에서 객체 종료를 기다려야 한다. (동작 결과는 생략!)</p>
</details>
<details>
  <summary>  [QUESTION 6] Semaphore 사용(작성중!)</summary>
  <br>
  <p></p>
</details>

<br/>

### ** Sorting(정렬) **

<br>
<p>수행시간(느린 순) : 버블정렬 > 선택정렬 >= 삽입정렬 > 병합정렬 >= 퀵정렬 >= 기수정렬</p>
<details>
  <summary>  [QUESTION] Bubble Sort(버블정렬)</summary>
  <br>
  <p>[ANSWER] 1) 인접한 두 개의 원소를 비교<br>
[ANSWER] 2) 인덱스를 하나씩 증가시키면서, 끝까지 인접한 두 개의 원소를 비교<br>
[ANSWER] 3) 1~2 과정을 1개의 step으로 했을 때, 매 step마다 끝에서부터 한 개의 원소가 정렬됨<br>
[ANSWER] 4) 모든 원소를 정렬완료할 때 까지 step 반복<br>
[ANSWER] 시간복잡도 : Best => O(n^2) / Average => O(n^2) / Worst => O(n^2)<br>
[ELAPSED] (50000개 기준) 3230(ms) FINISHED.</p>
</details>
<details>
  <summary>  [QUESTION] Selection Sort(선택정렬)</summary>
  <br>
  <p>[ANSWER] 1) 전체 배열을 순회하면서 최소값(또는 최대값)을 찾는다.<br>
[ANSWER] 2) 1)의 값을 맨 앞자리와 교체한다.<br>
[ANSWER] 3) 교체한 값을 제외한 다음 값부터 1~2를 반복한다.<br>
[ANSWER] 데이터의 양이 적을 때 유용함. 대신, 데이터의 양이 어느정도 많아지면 사용하기 힘들다.<br>
[ANSWER] 시간복잡도 : Best => O(n^2) / Average => O(n^2) / Worst => O(n^2)<br>
[ELAPSED] (50000개 기준) 905(ms) FINISHED.</p>
</details>
<details>
  <summary>  [QUESTION] Insertion Sort(삽입정렬)</summary>
  <br>
  <p>[ANSWER] 1) 2번째 인덱스부터 순회 시작. 해당 값을 정렬된 인덱스에 삽입하기 위한 정렬<br>
[ANSWER] 2) 1)의 인덱스부터 최대 첫 번째 인덱스까지 순회하면서 1)의 인덱스값과 2)에서 순회한 인덱스값 크기 비교<br>
[ANSWER] 3) 1)의 인덱스 값보다 2)의 인덱스 값이 더 크면 2)의 인덱스 원소를 한 칸 뒤로 옮긴다.<br>
[ANSWER] 4) 1)의 인덱스 값이 더 클때까지 2~3 과정 반복.<br>
[ANSWER] 시간복잡도 : Best => O(n) / Average => O(n^2) / Worst => O(n^2)<br>
[ELAPSED] (50000개 기준) 903(ms) FINISHED.</p>
</details>
<details>
  <summary>  [QUESTION] Merge Sort(합병정렬)</summary>
  <br>
  <p>[ANSWER] devide and conquer 알고리즘(분할정복) 활용하여 배열을 나누고 합치면서 정렬을 진행한다.<br>
[ANSWER] 1) 배열을 반으로 분할한다.(2-way)<br>
[ANSWER] 2) 더이상 분할할 배열이 없을 때까지(길이가 1인 배열) 1)의 과정을 진행한다.<br>
[ANSWER] 3) 분할된 배열들을 합친다.<br>
[ANSWER] 시간복잡도 : Best => O(nlogn) / Average => O(nlogn) / Worst => O(nlogn)<br>
[ELAPSED] (50000개 기준) 13(ms) FINISHED.</p>
</details>
<details>
  <summary>  [QUESTION] Quick Sort(퀵정렬)</summary>
  <br>
  <p>[ANSWER] 1) List에서 하나의 기준으로 원소를 선택(pivot)<br>
[ANSWER] 2) pivot 기준 앞(왼쪽)에는 pivot보다 작은 값이, 뒤(오른쪽)에는 pivot보다 큰 값이 오도록 두 개의 리스트로 분할<br>
[ANSWER] 3) 분할된 두 개의 리스트 각각 재귀호출로 퀵소트 진행<br>
[ANSWER] 시간복잡도 : Best => O(nlogn) / Average => O(nlogn) / Worst => O(n^2)<br>
[ELAPSED] (50000개 기준) 9(ms) FINISHED.</p>
</details>
<details>
  <summary>  [QUESTION] Radix Sort(기수정렬)</summary>
  <br>
  <p>[ANSWER] 낮은 자리수부터 비교해서 0~9 10개의 큐(여기서는 배열)에 자리수 숫자에 맞게 분배하고 빼며 정렬하는 방식<br>
[ANSWER] 메모리 낭비 심함<br>
[ANSWER] 1) 각 최소 자리수부터 시작해서 자리수에 맞는 숫자에 맞게 큐에 넣는다.<br>
[ANSWER] 2) 낮은 수의 큐(0~9 중 0)부터 차례로 값을 꺼낸다.<br>
[ANSWER] 3) 십 단위의 자리수 순서대로 최대 숫자의 자리수까지 1~2 과정 반복<br>
[ANSWER] 시간복잡도 : Best => O(n) / Average => O(d(n + k)) / Worst => O(d(n + k))<br>
[ELAPSED] (50000개 기준) 13(ms) FINISHED. -> 개수가 많을수록 좋다.</p>
</details>

<br/>

<br/>

## 3. Tutorial Description

<br/>
<br/>

## 4. Maker : Leehaewon

<br/>
<br/>

## etc.

-   mail : banner4@naver.com
-   start : 2021.09.11
