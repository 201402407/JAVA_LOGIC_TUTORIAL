package interfaceSample;

public interface SmartPhone {
	// 1. 상수 - 인터페이스에 final 선언 가능(불변)
	final String TYPE = "ELECTRONIC";
	
	// 2. 추상 메소드 - 인터페이스를 구현하는 클래스에서 구현 필수(구현 강제)
	// public만 사용 가능
	public String sendSMS(String message);
	public void call();
	public boolean lock();
	
	// 3. 정적 메소드 - 인터페이스에서 정의된 형식으로만 사용 가능(불변)
	public static String getTelNo(String telNo) {
		return telNo.substring(0, 3) + "-" + telNo.substring(3, 7) + "-" + telNo.substring(7, 11);
	}
	
	// 4. default 메소드 - 구현하는 클래스에서 입맛에 맞게 오버라이딩 가능(구현 선택)
	default String getSerialId(String id) {
		return String.valueOf(id.hashCode());
	}
	 
}
