package fr.umlv.calc;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public sealed interface Expr {
	
	
	public sealed interface Binop extends Expr {
		Expr left();
		Expr right();
		public int compute(int x, int y);
		
		@Override
		default int eval() {
			int VarLeft = left().eval();
			int VarRight = right().eval();
			return compute(VarLeft, VarRight);
		}
		public record Add(Expr left, Expr right) implements Binop {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
			
			@Override
			public String toString() {
				StringBuilder str = new StringBuilder();
				if (left.getClass() != new Value(0).getClass())
					str.append('(').append(left).append(')');
				else
					str.append(left);
				
				str.append(" + ");
				
				if (right.getClass() != new Value(0).getClass())
					str.append('(').append(right).append(')');
				else
					str.append(right);
				
				return str.toString();
			}
		}
		public record Sub(Expr left, Expr right) implements Binop {
			@Override
			public int compute(int x, int y) {
				return x - y;
			}
			
			@Override
			public String toString() {
				StringBuilder str = new StringBuilder();
				if (left.getClass() != new Value(0).getClass())
					str.append('(').append(left).append(')');
				else
					str.append(left);
				
				str.append(" - ");
				
				if (right.getClass() != new Value(0).getClass())
					str.append('(').append(right).append(')');
				else
					str.append(right);
				
				return str.toString();
			}
		}
	}
	
	
	
	
	public record Value(int val) implements Expr {
		@Override
		public int eval() {
			return val;
		}
		
		@Override
		public String toString() {
			return String.valueOf(eval());
		}
	}
	/*public record Add(Expr left, Expr right) implements Expr {
		@Override
		public int eval() {
			// TODO Auto-generated method stub
			return left.eval() + right.eval();
		}
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			if (left.getClass() != new Value(0).getClass())
				str.append('(').append(left).append(')');
			else
				str.append(left);
			
			str.append(" + ");
			
			if (right.getClass() != new Value(0).getClass())
				str.append('(').append(right).append(')');
			else
				str.append(right);
			
			return str.toString();
		}
	}*/
	/*public record Sub(Expr left, Expr right) implements Expr {
		@Override
		public int eval() {
			// TODO Auto-generated method stub
			return left.eval() - right.eval();
		}
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			if (left.getClass() != new Value(0).getClass())
				str.append('(').append(left).append(')');
			else
				str.append(left);
			
			str.append(" - ");
			
			if (right.getClass() != new Value(0).getClass())
				str.append('(').append(right).append(')');
			else
				str.append(right);
			
			return str.toString();
		}
	}*/
	
	public int eval();
	
	public static Expr parse(Scanner scanner) {
		Expr result;
		var scan = scanner.next();
		if (scan.equals("+")) {
			Expr left = parse(scanner);
			Expr right = parse(scanner);
			result = new Binop.Add(left, right);
		}
		
		else if (scan.equals("-")) {
			Expr left = parse(scanner);
			Expr right = parse(scanner);
			result = new Binop.Sub(left, right);
		}
		
		else {
			result = new Value(Integer.parseInt(scan));
		}
		return result;
	}
	
	public static Expr parse(List<String> list) {
		return parse(list.iterator());
	}
	
	public static Expr parse(Iterator<String> it) {
		var token = it.next();
		return switch(token) {
			case "+" -> new Binop.Add(parse(it), parse(it));
			case "-" -> new Binop.Sub(parse(it), parse(it));
			default -> new Value(Integer.parseInt(token));
		};
	}
	
	
}
