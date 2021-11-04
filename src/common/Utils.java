package common;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Utils {
	public static long startElapsed() {
		System.out.println("[ELAPSED] CHECK START!");
		return System.currentTimeMillis();
	}
	
	public static void endElapsed(long startTime) {
		long endTime = System.currentTimeMillis();
		System.out.println("[ELAPSED] " + (endTime - startTime) + "(ms) FINISHED.");
	}
	
	public static <T> void elapsedCheck(Supplier<T> supplier) {
		long startTime = startElapsed();
		supplier.get();
		endElapsed(startTime);
	}
	
	public static <T> void elapsedCheck(Predicate<T> predicate, T t) {
		long startTime = startElapsed();
		predicate.test(t);
		endElapsed(startTime);
	}
}
