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
Consumer&lt;String&gt; consumer = (str) -> System.out.println('이거슨 Consumer, parameter: ' + str);<br>
Consumer.accept('consumer') <br>
-> 이거슨 Consumer, parameter: consumer</p>
</details>
<details>
  <summary>  [QUESTION 4] Predicate 함수형 인터페이스 설명 및 예제</summary>
  <br>
  <p>[ANSWER] return type이 boolean(True / False). test 추상 메소드를 통해 함수형 인터페이스 호출가능<br>
[ANSWER] T -> boolean<br>
Predicate&lt;String&gt; predicate = (str) -> str.equals('True');<br>
Predicate.test('False') -> false</p>
</details>
<details>
  <summary>  [QUESTION 5] Supplier 함수형 인터페이스 설명 및 예제</summary>
  <br>
  <p>[ANSWER] 공급자. parameter는 없고, return 값만 존재. get 추상 메소드를 통해 함수형 인터페이스 호출가능. 대괄호 안에 return 필수<br>
[ANSWER] () -> T<br>
Supplier&lt;String&gt; supplier = () -> { return supplierStr + ' Supplier !! '; }<br>
Supplier.get() -> This is Supplier !! </p>
</details>
<details>
  <summary>  [QUESTION 6] BiConsumer 함수형 인터페이스 설명 및 예제</summary>
  <br>
  <p>[ANSWER] parameter는 2개가 존재하고, Return X. accept(param1, param2) 추상 메소드를 통해 함수형 인터페이스 호출가능.<br>
[ANSWER] Supplier 만 제외한 나머지엔 Bi가 존재<br>
BiConsumer&lt;String, String&gt; biConsumer = (param1, param2) -> { System.out.print(param1 + param2); }<br>
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
[ANSWER] 2) entrySet() => Map.Entry&lt;Key, Value&gt; 방법<br>
[ELAPSED] CHECK START!<br>
key : Beck , value : 5<br>
key : Sway , value : 2<br>
key : Lee , value : 1<br>
key : FULL , value : 2<br>
[ELAPSED] 0(ms) FINISHED.<br>
[ANSWER] 3) keySet() 및 get(key) 방법<br>
[ELAPSED] CHECK START!<br>
key : Beck , value : 5<br>
key : Sway , value : 2<br>
key : Lee , value : 1<br>
key : FULL , value : 2<br>
[ELAPSED] 0(ms) FINISHED.<br>
[ANSWER] 4) (성능낮음) lambda forEach 방법<br>
[ELAPSED] CHECK START!<br>
key : Beck , value : 5<br>
key : Sway , value : 2<br>
key : Lee , value : 1<br>
key : FULL , value : 2<br>
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
    -

<br/>

### ** Reference(참조) **

    -   순환참조의 정의와 예시

<br/>

### ** Generic Type(제네릭 타입) **

    -   Generic Type이란?

    -   Generic Type을 사용한 경우와 사용하지 않은 경우

    -   Generic Type을 사용한 인터페이스

    -   Generic Type을 2개 사용한 클래스

    -   제한된 Generic Type 클래스 사용

<br/>

### ** ThreadLocal **

    -   ThreadLocal이란?

    -   ThreadLocal은 보통 언제 사용하는지?

    -   ThreadLocal 사용법

    -   ThreadLocal 사용 예시

<br/>

### ** Thread-Safety **

    -   Thread-Safety 하다는 것은 어떤 의미인지?

    -   Thread-Safety를 구현할 수 있는 방법은?

    -   Not Thread-safe 한 경우(동기화X)

    -   Synchronized 방법 중 synchronized 함수를 만들어 사용

    -   Synchronized 방법 중 synchronized lock을 만들어 사용

    -   Semaphore 사용(작성중!)

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
