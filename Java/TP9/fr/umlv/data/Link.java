package fr.umlv.data;

record Link<U>(U val, Link<U> next) {
	
	public static void main(String[] args) {
		Link<Integer> l1 = new Link<Integer>(13, null);
		Link<Integer> l2 = new Link<Integer>(144, null);
	}
}
