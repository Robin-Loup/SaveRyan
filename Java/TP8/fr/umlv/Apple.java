package fr.umlv;

public record Apple(int weight, AppleKind name) implements Fruit {
	
	public int price() {
		return weight/2;
	}
	
	@Override
	public String toString() {
		return (name + " " + weight + " g");
	}

}
