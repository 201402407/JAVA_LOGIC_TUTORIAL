package threadSafety;

import java.util.concurrent.Semaphore;

public class SemaphoreResource {
	private Semaphore semaphore; 
	private int maxThread;
	
	public SemaphoreResource(int maxThread) {
		this.maxThread = maxThread;
		this.semaphore = new Semaphore(maxThread);
	}
	
	public void use() {
		try {
			semaphore.acquire();	// Thread가 Semaphore에게 시작 알림
			System.out.println("[" + Thread.currentThread().getName() + "] " + (maxThread - semaphore.availablePermits()) + "개 세마포어(쓰레드) 사용중");
			Thread.sleep((long) ((Math.random() * 10) * 1000));
			semaphore.release(); 	// Thread가 Semaphore에게 종료 알림
			System.out.println("[" + Thread.currentThread().getName() + "] 세마포어 사용 해제(잔여 세마포어 : " + (maxThread - semaphore.availablePermits()) + ")");
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

