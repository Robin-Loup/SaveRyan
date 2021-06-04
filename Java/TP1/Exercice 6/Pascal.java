
public class Pascal {
	public static int pascal(int nBut, int pBut) {
		int tab[] = new int[nBut + 1];
		int n, i;

		tab[0] = 1;

		for (n = 1; n <= nBut; n++) {
			tab[n] = 1;

			for (i = n - 1; i > 0; i--)
				tab[i] = tab[i - 1] + tab[i];
		}

		int result = tab[pBut];
		return result;
	}

	public static void main(String[] args) {
		System.out.println(" Cn, p = " + pascal(30000, 250) + "\n");
	}

}
/*time ./a.out
 Cn, p = -1742193024

real	0m0,895s
user	0m0,889s
sys	0m0,004s


time java Pascal 
Cn, p = -1742193024


real	0m0,178s
user	0m0,199s
sys	0m0,010s
*/

/* Le java est plus rapide car c'est un langage interprété
 * alors que le C est compilé. La machine virtuelle dispose donc
 * d'information dynamique dépendant précisément de l'exécution et
 * fait de l'optimisation pour Java.
 */