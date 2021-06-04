package fr.umlv.calc.main;

import java.util.Scanner;

import fr.umlv.calc.Expr;
import static fr.umlv.calc.Expr.Binop.*;

public class Main {
	public static void main(String[] args) {
		Expr expression = new Add(new Value(2), new Value(3));
		Expr expression2 = new Sub(new Add(new Value(2), new Value(3)), new Value(4));
		System.out.println(expression2.eval());
		
		System.out.println(expression2);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(Expr.parse(scanner).eval());
		scanner.close();
	}
}
