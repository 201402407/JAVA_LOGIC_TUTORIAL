package interfaceSample;

public class Sample {
	public static void main(String args[]) {
		// 1) 인터페이스 객체에 구현한 클래스 인스턴스 주입 가능?
		// -> 가능!
		System.out.println("[QUESTION 1] 인터페이스 객체에 구현한 클래스 인스턴스 주입 가능?");
		SmartPhone samsungPhone = new Samsung();
		SmartPhone iPhone = new IPhone();
		assert samsungPhone == null || iPhone == null;
		System.out.println("[ANSWER] 가능!");
		System.out.println("------------------------------------------------------------------------------");
		
		// 2) 인터페이스 객체의 getClass는?
		// -> 인스턴스 클래스!
		System.out.println("[QUESTION 2] 인터페이스 객체의 getClass는?");
		System.out.println("[ANSWER] samsungPhone 객체는 " + samsungPhone.getClass().toString() + " 클래스 입니다.");
		System.out.println("[ANSWER] iPhone 객체는 " + iPhone.getClass().toString() + " 클래스 입니다.");
		System.out.println("------------------------------------------------------------------------------");
		
		// 3) 인터페이스 객체지만 구현 클래스 인스턴스가 들어가있으면, 구현 클래스의 메소드가 호출하는지?
		// -> 구현한 클래스의 메소드가 호출됨!
		System.out.println("[QUESTION 3] 인터페이스 객체지만 구현 클래스 인스턴스가 들어가있으면, 구현 클래스의 메소드가 호출하는지?");
		System.out.print("RESULT(samsung) : ");
		samsungPhone.call();
		System.out.print("RESULT(ihpone) : ");
		iPhone.call();
		System.out.println("[ANSWER] 정상 호출됨!");
		System.out.println("------------------------------------------------------------------------------");
		
		// 4) 어떠한 구현 클래스간에 인스턴스의 상수와 static 메소드 호출 가능?
		System.out.println("[QUESTION 4] 어떠한 구현 클래스간에 인스턴스의 상수와 static 메소드 호출 가능?");
		System.out.println("[!] 상수 호출");
		System.out.println("samsung's TYPE : " + samsungPhone.TYPE);
		System.out.println("iPhone's TYPE : " + iPhone.TYPE);
		System.out.println("[!] static 메소드 호출");
		System.out.println("samsung's telNo : X");
		System.out.println("iPhone's telNo :  X");
		System.out.println("SmartPhone's telNo : " + SmartPhone.getTelNo("01011112222"));
		System.out.println("[ANSWER] 인터페이스 클래스로만 호출 가능(static 이니까)");
		System.out.println("------------------------------------------------------------------------------");
		
		// 5) Overriding한 default 메소드와 안한 default 메소드 호출 결과?
		System.out.println("[QUESTION 5] Overriding한 default 메소드와 안한 default 메소드 호출 결과?");
		System.out.println("[ANSWER] samsungPhone(Overriding) serialId : " + samsungPhone.getSerialId("phone"));
		System.out.println("[ANSWER] iPhone(Not Overriding) serialId : " + iPhone.getSerialId("phone"));
		System.out.println("------------------------------------------------------------------------------");
		
		// ** 6) 구현 클래스에서 생성한 메소드를 인스턴스 주입한 인터페이스 객체에서 사용할 수 있을까?
		System.out.println("[QUESTION 6] 구현 클래스에서 생성한 메소드를 구현 클래스를 주입한 인터페이스 객체에서 사용할 수 있을까?");
		System.out.println("[ANSWER] 인터페이스에서 정의되지 않았기 때문에 사용할 수 없다. 대신, downCasting을 통해 활용할 수 있다.");
		System.out.println("[ANSWER] (samsung) whoIsMyBestLeader : " + ((Samsung) samsungPhone).whoIsMyBestLeader());
		System.out.println("[ANSWER] (iPhone) whoIsMyBestLeader : " + ((IPhone) iPhone).whoIsMyBestLeader());
		System.out.println("------------------------------------------------------------------------------");
	}
}

class Samsung implements SmartPhone {
	private boolean samsungLock = false;
	
	
	@Override
	public String sendSMS(String message) {
		String samsungMessage = "Galaxy Message ::: " + message;
		return samsungMessage;
	}
	
	@Override
	public void call() {
		// TODO: 삼성 핸드폰의 전화로직 구현
		System.out.println(this.getClass().toString() + "의 전화 메소드 호출!");
		this.samsungLock = false;
	}

	@Override
	public boolean lock() {
		return this.samsungLock;
	}	
	
	@Override
	public String getSerialId(String id) {
		return "Samsung의 hashCode : " + id.hashCode();
		
	}
	
	public String whoIsMyBestLeader() {
		return "이재용";
	}
}

class IPhone implements SmartPhone {

	@Override
	public String sendSMS(String message) {
		String iPhoneMessage = "IPhone Message ::: " + message;
		return iPhoneMessage;
	}

	@Override
	public void call() {
		// TODO: 아이폰의 전화로직 구현
		System.out.println(this.getClass().toString() + "의 전화 메소드 호출!");
		
	}

	@Override
	public boolean lock() {
		// TODO: 아이폰의 해제 로직 구현
		return false;
	}
	
	public String whoIsMyBestLeader() {
		return "Steve Jobs";
	}
	
}