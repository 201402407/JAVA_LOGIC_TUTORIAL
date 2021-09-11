package common;

public class Utils {
	public static long startElapsed() {
		System.out.println("[ELAPSED] CHECK START!");
		return System.currentTimeMillis();
	}
	
	public static void endElapsed(long startTime) {
		long endTime = System.currentTimeMillis();
		System.out.println("[ELAPSED] " + (endTime - startTime) + "(ms) FINISHED.");
	}
}
