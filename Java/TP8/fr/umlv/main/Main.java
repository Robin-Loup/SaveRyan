package fr.umlv.main;

import java.util.HashSet;

import fr.umlv.*;

public class Main {
	
	public static void main(String[] args) {
        var set = new HashSet<Pear>();
        set.add(new Pear(5));
        System.out.println(set.contains(new Pear(5)));
        
        var apple1 = new Apple(20, AppleKind.Golden);
        var apple2 = new Apple(40, AppleKind.PinkLady);
        var pear = new Pear(5);
   
        var basket = new Basket();
        basket.add(apple1, 5);
        basket.add(apple2);
        basket.add(pear, 7);
        System.out.println(basket);
	}
}
	         
	         
