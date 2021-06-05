package fr.umlv.data.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		var list = List.of("hello", "world", "hello", "lambda");
	    System.out.println(count2(list, "hello"));  // 2
	    
	    var list2 = List.of("hello", "world", "hello", "lambda");
	      System.out.println(upperCase(list));  // [HELLO, WORLD, HELLO, LAMBDA]
	    
	}
	
	private static List<String> upperCase(List<String> list) {
		var uppercases = new ArrayList<String>();
		for(var str : list) {
			uppercases.add(str.toUpperCase());
		}
		return uppercases;
	}

	private static List<String> upperCase2(List<String> list) {
		Stream<String> st = list.stream().map(S -> S.toUpperCase());
		var uppercases = new ArrayList<String>();
		st.forEach(S -> uppercases.add(S));
		return uppercases;
	}
	
	private static List<String> upperCase3(List<String> list) {
		Stream<String> st = list.stream().map(String::toUpperCase);
		var uppercases = new ArrayList<String>();
		st.forEach(S -> uppercases.add(S));
		return uppercases;
	}
	
	private static List<String> upperCase4(List<String> list) {
		return list.stream().map(S -> S.toUpperCase()).collect(Collectors.toList());
	}
	
	
	private static long count(List<String> list, String string) {
		long count = 0;
		for(var str : list) {
			if (str.equals(string))
				count++;
		}
		return count;
	}

	private static long count2(List<String> list, String string) {
		// TODO Auto-generated method stub
		return list.stream().filter(S -> S.equals(string)).count();
	}
	
	private static long count3(List<String> list, String string) {
		// TODO Auto-generated method stub
		Stream<String> st = list.stream().filter(S -> S.equals(string));
		LongStream st2 = st.mapToLong(S -> 1L);
		return st2.reduce(0,Long::sum);
	}
	
}
