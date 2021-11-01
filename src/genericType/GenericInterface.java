package genericType;

public interface GenericInterface<T> {
	public default T getType() {
		return null;
	}
}
