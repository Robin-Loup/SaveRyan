package Exercice4;

public class Main {
	
	public static void  swap(int[] array,int index1,int index2) {
		int swap = array[index1];
		array[index1] = array[index2];
		array[index2] = swap;
	}
	
	public static void print(int[] array) {
		for (int variable : array) {
			System.out.print(variable +" ");
		}
		System.out.println("");
	}
	
	public static int indexOfMin(int[] array, int indice1, int indice2) {
		int min = indice1;
		for(int i = indice1; i < indice2; i++) {
			if (array[i] < array[min]) {
				min = i;
			}
		}
		return min;
	}
	
	public static void sort(int[] array) {
		int min;
		for(int i = 0; i < array.length; i++) {
			min = indexOfMin(array, i, array.length);
			swap(array, min, i);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2, 4, 11, 3, 12, 18, 3, 9, 18, 11};
		Main.swap(array, 0, 6);
		Main.print(array);
		System.out.println(Main.indexOfMin(array, 2, 5));
		Main.sort(array);
		Main.print(array);	
	}

}
