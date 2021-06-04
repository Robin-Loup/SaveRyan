package fr.umlv.data;

import java.util.Objects;

public class LinkedList <T> {
	private Link<T> head;
	private int size;
	
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	public void add(T obj) {
		Link<T> l = new Link<T>(obj,head);
		head = l;
		size++;
	}
	
	public T get(int index) {
		Objects.checkIndex(index, size);
		Link<T> tmp = head;
		for(int i = 0; i < index; i++) {
			tmp = tmp.next();
		}
		return tmp.val();
	}
	
	public boolean contains(Object o) {
		Link<T> tmp = head;
		for (int i = 0; i < size; i++) {
			if (tmp.val().equals(o))
				return true;
			tmp = tmp.next();
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append('{');
		Link<T> tmp = head;
		while (tmp != null) {
			str.append(tmp.val());
			if (tmp.next() != null)
				str.append(", ");
			tmp = tmp.next();
		}
		str.append('}');
		return str.toString();
	}
	

}
