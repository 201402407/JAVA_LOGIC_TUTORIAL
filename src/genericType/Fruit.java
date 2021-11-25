package genericType;

public class Fruit {
	@Override
	public String toString() {
		return "Fruit";
	}
	
	public String temp() {
		return "TEMP";
	}
}

class Apple extends Fruit {
	@Override
	public String toString() {
		return "Apple";
	}
}

class GreenApple extends Apple {
	@Override
	public String toString() {
		return "GreenApple";
	}
}

class HoneyApple extends Apple implements Delicious {
	@Override
	public String toString() {
		return "HoneyApple";
	}
}

class Orange extends Fruit implements Comparable<Fruit> {
	@Override
	public String toString() {
		return "Orange";
	}

	@Override
	public int compareTo(Fruit o) {
		return -1;
	}
}

class Banana extends Fruit {
	@Override
	public String toString() {
		return "Banana";
	}
}

class RedBanana extends Banana {
	@Override
	public String toString() {
		return "RedBanana";
	}
}
