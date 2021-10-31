package threadLocal;

public class Sample {
	public static void main(String args[]) throws InterruptedException {
		question1();
		question2();
		question3();
		question4();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] ThreadLocal이란?");
		System.out.println("[ANSWER] 일종의 쓰레드 지역변수. 오직 하나의 쓰레드에 의해 읽고 쓸 수 있는 변수로서, 다른 각각의 쓰레드가 하나의 ThreadLocal을 호출해도 서로 다른 값을 바라본다.");
		System.out.println("[ANSWER] Thread의 정보를 Key로 하는 Map 형식으로 데이터를 저장해두고 사용하는 자료구조.");
		System.out.println("[ANSWER] ThreadPool 사용하여 Thread 재활용 시 이전에 저장된 ThreadLocal을 호출하게 되므로 모든 ThreadLocal 사용 후 remove 필수.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question2() {
		System.out.println("[QUESTION 2] ThreadLocal은 보통 언제 사용하는지?");
		System.out.println("[ANSWER] 1) 사용자 인증정보 - Spring Security에서 사용자마다 다른 사용자 인증 정보 세션을 사용할 때.");
		System.out.println("[ANSWER] 2) 트랜잭션 컨텍스트 - 트랜잭션 매니저가 트랜잭션 컨텍스트를 전파할 때.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question3() {
		System.out.println("[QUESTION 3] ThreadLocal 사용법");
		System.out.println("[ANSWER] 1) ThreadLocal 객체 생성");
		ThreadLocal threadLocal = new ThreadLocal();
		System.out.println("[?] ThreadLocal Generic Type 사용 가능할까?");
		ThreadLocal<String> threadLocalGeneric = new ThreadLocal<>();
		System.out.println("[!] ThreadLocal Generic Type 사용 가능(<>로 사용방법 동일)");
		System.out.println("[?] ThreadLocal Class의 Default 초기값 설정 방법?");
		System.out.println("[!] ThreadLocal에서 initialValue method를 Override 하면 이 ThreadLocal 변수를 사용하는 모든 쓰레드의 default값이 존재한다.");
		System.out.println("[!] 즉, 별도의 set 함수로 값 설정하기 전에도 get으로 동일한 default값을 꺼내 사용할 수 있다.");
		ThreadLocal<String> subThreadLocal = new ThreadLocal<String>() {
			@Override
			protected String initialValue() {
				return "Init Value";
			}
		};
		System.out.println("[ANSWER] 2) 현재 ThreadLocal에 값 저장(.set())");
		threadLocalGeneric.set("TEMP");
		System.out.println("[ANSWER] 3) 현재 ThreadLocal에 값 불러오기(.get())");
		String result = threadLocalGeneric.get();
		System.out.println("[ANSWER] 4) 사용 완료 후 ThreadLocal 값 삭제(.remove())");
		threadLocalGeneric.remove();
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question4() throws InterruptedException {
		System.out.println("[QUESTION 4] ThreadLocal 사용 예시");
		System.out.println("[ANSWER] 1) Runnable 인터페이스 구현(MyRunnable) -> threadLocal에 랜덤 값 저장");
		MyRunnable runnable = new MyRunnable();
		System.out.println("[ANSWER] 2) 하나의 Runnable 객체를 2개의 쓰레드에 담기");
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		System.out.println("[ANSWER] 3) 각 쓰레드 run 시 두 쓰레드에 다른 값이 담기는지 확인(쓰레드 별 ThreadLocal에 랜덤 값이 담기기 때문에 다르다.)");
		System.out.print("thread1 get 결과 :: ");
		thread1.start();
		Thread.sleep(200);
		System.out.print("thread2 get 결과 :: ");
		thread2.start();
		Thread.sleep(200);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	
	 public static class MyRunnable implements Runnable {

	        private ThreadLocal<Integer> threadLocal =
	               new ThreadLocal<Integer>();

	        @Override
	        public void run() {
	            threadLocal.set( (int) (Math.random() * 100D) );
	    
	            try {
	                Thread.sleep(50);
	            } catch (InterruptedException e) {
	            }
	    
	            System.out.println(threadLocal.get());
	        }
	    }
}