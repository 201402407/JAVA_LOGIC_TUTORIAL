package threadSafety;

public class Sample {
	public static void main(String args[]) throws InterruptedException {
		question1();
		question2();
		question3();
	}
	
	static void question1() {
		System.out.println("[QUESTION 1] Thread-Safety 하다는 것은 어떤 의미인지?");
		System.out.println("[ANSWER] 멀티 쓰레딩 프로그래밍에서 여러 쓰레드가 어떤 객체, 함수, 변수에 접근하게 되도 동작 결과에 아무런 문제가 발생하지 않는 것(= 어디서든 수행 결과가 올바른 것)");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question2() {
		System.out.println("[QUESTION 2] Thread-Safety를 구현할 수 있는 방법은?");
		System.out.println("[ANSWER] 1) Re-entrancy 방법");
		System.out.println("-> 어떤 쓰레드가 함수를 호출해 실행중일 때 다른 쓰레드가 함수를 호출해도 두 결과가 올바르게 나와야 한다.");
		System.out.println("-> 즉, 여러 쓰레드가 동시에 함수를 호출해도 올바른 결과가 나와야 한다.");
		System.out.println("-> 공유하는 자원 없이 독립적으로 실행가능한 코드를 설계하기");
		System.out.println("[ANSWER] 2) Thread-local Storage 방법");
		System.out.println("-> 공유 자원 사용을 줄이기 위해 각각 스레드에서만 접근 가능한 ThreadLocal을 사용한다.");
		System.out.println("[ANSWER] 3) Mutual Exclusion(상호 배제) 방법");
		System.out.println("-> Semaphore(세마포어)나 Synchronize, lock 등 공유 자원의 접근을 통제한다.");
		System.out.println("[ANSWER] 4) Atomic operations 방법");
		System.out.println("-> 데이터의 상태 변경 전/후 에만 접근이 가능하다.");
		System.out.println("-> 데이터를 변경하는 순간에는 다른 변경 접근이 불가능하다.");
		System.out.println("-> ex) ++, +=와 같이 +와 =이 한 코드에 있는 것");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question3() {
		System.out.println("[QUESTION 3] Not Thread-safe 한 경우(동기화X)");
		System.out.println("[ANSWER] not thread-safety 하기 때문에 매 번 잔액 결과가 다르다.");
		Banking banking = new Banking(new BankingCallback());
		Thread thread1 = new Thread(banking);
		Thread thread2 = new Thread(banking);
		thread1.setName("Thread 1번");
		thread2.setName("Thread 2번");
		thread1.start();
		thread2.start();
//		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question4() {
		System.out.println("[QUESTION 4] Synchronized 방법 중 synchronized 함수를 만들어 사용");
		System.out.println("[ANSWER] thread-safety 하기 때문에 잔액 결과가 같다.(Thread1, 2 실행 시간에 따라 누가 어떤 잔액을 가지는지는 달라지지만, 결과는 동일하다)");
		System.out.println("[ANSWER] Synchronized는 객체 내부 전체에 lock을 걸기 때문에, 다른 쓰레드는 객체 자체를 사용하려면 기다려야 한다.");
		BankingSync banking = new BankingSync(new BankingCallback());
		Thread thread1 = new Thread(banking);
		Thread thread2 = new Thread(banking);
		thread1.setName("Thread 1번");
		thread2.setName("Thread 2번");
		thread1.start();
		thread2.start();
//		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question5() {
		System.out.println("[QUESTION 5] Synchronized 방법 중 synchronized lock을 만들어 사용");
		System.out.println("[ANSWER] thread-safety 하기 때문에 잔액 결과가 같다.(Thread1, 2 실행 시간에 따라 누가 어떤 잔액을 가지는지는 달라지지만, 결과는 동일하다)");
		System.out.println("[ANSWER] 함수 내부에 별도 객체를 만들어 lock을 걸기 때문에, 다른 쓰레드는 해당 함수 내부에서 객체 종료를 기다려야 한다.");
		BankingSync2 banking = new BankingSync2(new BankingCallback());
		Thread thread1 = new Thread(banking);
		Thread thread2 = new Thread(banking);
		thread1.setName("Thread 1번");
		thread2.setName("Thread 2번");
		thread1.start();
		thread2.start();
		System.out.println("------------------------------------------------------------------------------");
	}
	
	static void question6() {
		System.out.println("[QUESTION 6] Semaphore 사용");
		System.out.println("[ANSWER] not thread-safe 하기 때문에 종료 구문이 2개 나올 수 있다.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
    static void tempString() {
    	System.out.println(Thread.currentThread().getName() + " TEMP STRING 호출!");
    }
}

// 쓰레드 콜백함수 호출 커스텀
class BankingCallback {
	int finishThreadCount = 0;
	
	void callback(Thread thread, int questionNumber) {
		System.out.println(thread.getName() + " 쓰레드 종료!");
		finishThreadCount++;
		if(finishThreadCount == 2) {
			System.out.println("------------------------------------------------------------------------------");
			if(questionNumber == 3) {
				Sample.question4();
			}
			if(questionNumber == 4) {
				Sample.question5();
			}
		}
	}
}

class Banking implements Runnable {
	BankingCallback cb;
    int money = 700; 
      
    Banking(BankingCallback cb) {
    	this.cb = cb;
    }
    
    @Override
    public void run() {
        while(money > 0){
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금(withDraw)한다.
//            int money = (int)(Math.random() * 3 + 1) * 100;
        	int money = 300;
            withdraw(money);
        }
        
        this.cb.callback(Thread.currentThread(), 3);
    }
    
    private void withdraw(int money) {
    	Sample.tempString();
    	
    	try {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + " 출금 금액 => " + money);
            Thread.sleep(200);
            this.money -= money;
            System.out.println(thread.getName()+" 잔액 => " + this.money);
        }
    	catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

class BankingSync implements Runnable {
	BankingCallback cb;
    int money = 700; 
      
    BankingSync(BankingCallback cb) {
    	this.cb = cb;
    }
    
    @Override
    public void run() {
        while(money > 0){
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금(withDraw)한다.
//            int money = (int)(Math.random() * 3 + 1) * 100;
        	int money = 300;
            withdraw(money);
        }
        
        this.cb.callback(Thread.currentThread(), 4);
    }
    
    private synchronized void withdraw(int money) {
    	Sample.tempString();
    	
    	try {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + " 출금 금액 => " + money);
            Thread.sleep(200);
            this.money -= money;
            System.out.println(thread.getName()+" 잔액 => " + this.money);
        }
    	catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

class BankingSync2 implements Runnable {
	BankingCallback cb;
    int money = 700; 
      
    BankingSync2(BankingCallback cb) {
    	this.cb = cb;
    }
    
    @Override
    public void run() {
        while(money > 0){
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금(withDraw)한다.
//            int money = (int)(Math.random() * 3 + 1) * 100;
        	int money = 300;
            withdraw(money);
        }
        
        this.cb.callback(Thread.currentThread(), 5);
    }
    
    private void withdraw(int money) {
    	Sample.tempString();
    	
    	synchronized(this) {	// 별도 객체 생성해서 해당 객체에만 Synchronized 설정
    		try {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + " 출금 금액 => " + money);
                Thread.sleep(200);
                this.money -= money;
                System.out.println(thread.getName()+" 잔액 => " + this.money);
            }
        	catch (Exception e) {
            	e.printStackTrace();
            }
    	}
    	
    }
}
