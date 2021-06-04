package fr.umlv;

import java.util.Objects;

public class Pear implements Fruit {
	final private int juice;
	
	public Pear(int juice) {
		if (juice < 0 || juice > 9) {
			throw new IllegalArgumentException("bad juice");
		}
		
		this.juice = juice;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pear) {
			Pear mypear = (Pear) obj;
			return mypear.juice == juice;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(juice);
	}
	
	@Override
	public int price() {
		return juice *3;
	}
	
	@Override
	public String toString() {
		return ("pear: " + juice);
	}

}
