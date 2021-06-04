package DM;
import java.util.Arrays;
import java.util.Optional;

public class Matrice {

	private final int n; /* nombre de lignes */
	private final int m; /* nombre de colonnes */
	private final Rational[][] coeff; /* liste des coefficients */

	/**
	 * Création d'une matrice
	 * 
	 * @param coeff coefficients de la matrice
	 */
	public Matrice(Rational[][] coeff) {
		n = coeff.length;
		m = coeff[0].length;
		this.coeff = coeff;
	}

	/**
	 * Création d'une matrice
	 * 
	 * @param coeff coefficients de la matrice, donnés comme long
	 */
	public Matrice(long[][] coeff) {
		n = coeff.length;
		m = coeff[0].length;
		this.coeff = new Rational[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				this.coeff[i][j] = new Rational(coeff[i][j]);
			}
		}
	}

	/**
	 * Calcul de la somme matricielle this + M (si les dimensions de this et M
	 * l'autorisent)
	 * 
	 * @param M matrice à ajouter : tableau n x m
	 * @return somme this + M : tableau n x m
	 */
	public Matrice plus(Matrice M) {
		if (n != M.n || m != M.m) {
			throw new IllegalArgumentException("Dimensions incorrectes");
		}

		Rational[][] sum = new Rational[n][m];
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum[i][j] = this.coeff[i][j].plus(M.coeff[i][j]);
			}
		}
		return new Matrice(sum);
	}

	/**
	 * Calcul du produit matriciel this M (si les dimensions de this et M
	 * l'autorisent)
	 * 
	 * @param M matrice à multiplier : tableau m x p
	 * @return produit this M : tableau n x p
	 */
	public Matrice times(Matrice M) {
		if (m != M.n) {
			throw new IllegalArgumentException("Dimensions incorrectes");
		}
		int p = M.m;

		Rational[][] prod = new Rational[n][p];
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < p; j++) {
				prod[i][j] = Rational.ZERO;
				for(int k = 0; k < m; k++) {
					prod[i][j] = prod[i][j].plus(coeff[i][k].times(M.coeff[k][j]));
				}
			}
		}
		return new Matrice(prod);
	}

	/**
	 * Calcul de la transposée de this
	 * 
	 * @return transposée de this : tableau m x n
	 */
	public Matrice transpose() {
		Rational[][] trans = new Rational[m][n];
		for(int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				trans[i][j] = this.coeff[j][i];
			}
		}
		return new Matrice(trans);
	}

	/**
	 * Échange les lignes i et j de la matrice
	 * 
	 * @param i première ligne à échanger
	 * @param j deuxième ligne à échanger
	 */
	private void swapRows(int i, int j) {
		Rational swap;
		for (int x = 0; x < m; x++) {
			swap = coeff[i][x];
			coeff[i][x] = coeff[j][x];
			coeff[j][x] = swap;
		}
	}

	/**
	 * Ajoute a fois la ligne i de this à sa ligne j
	 * 
	 * @param i ligne à ajouter (multiplée par a)
	 * @param j ligne à laquelle on ajoute a fois la ligne i
	 * @param a scalaire par lequel on multiplie la ligne i quand on l'ajoute
	 */
	private void transvection(int i, int j, Rational a) {
		for (int x = 0; x < m; x++) {
			coeff[j][x] = coeff[j][x].plus(coeff[i][x].times(a));
		}
	}
	
	private void soustraction(int i, int j, Rational a) {
		for (int x = 0; x < m; x++) {
			coeff[j][x] = coeff[j][x].minus(coeff[i][x].times(a));
		}
	}

	/**
	 * Mutiplie par a la ligne i de this
	 * 
	 * @param i ligne à multiplier par a
	 * @param a scalaire par lequel on multiplie la ligne i
	 */
	private void multiplyRow(int i, Rational a) {
		for (int x = 0; x < m; x++) {
			coeff[i][x] = coeff[i][x].times(a);
		}
	}
	
	private void divideRow(int i, Rational a) {
		if (a.equals(Rational.ZERO)) {
			throw new IllegalArgumentException("Diviseur incorrect");
		}
		
		for (int x = 0; x < m; x++) {
			coeff[i][x] = coeff[i][x].divide(a);
		}
	}

	/**
	 * Calcul de la matrice identité de mêmes dimensions que this (si les dimensions
	 * de this l'autorisent)
	 * 
	 * @return matrice identité : tableau n x n
	 */
	public Matrice identity() {
		if (m != n) {
			throw new IllegalArgumentException("Dimensions incorrectes");
		}
		Rational[][] id = new Rational[n][n];
		for(int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					id[i][j] = Rational.ONE;
				}
				else
					id[i][j] = Rational.ZERO;
			}
		}
		return new Matrice(id);
	}

	/**
	 * Calcul d'une copie de this
	 * 
	 * @return copie de this : tableau n x m
	 */
	public Matrice clone() {
		Rational[][] clone = new Rational[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				clone[i][j] = coeff[i][j];
			}
		}
		return new Matrice(clone);
	}

	
	public int maxInColumn(int col) {
        var max = coeff[col][col];
        var index = col;

        for (var i = col + 1; i < n; i++) {
            if (coeff[i][col].isGreaterThan(max)) {
                max = coeff[i][col];
                index = i;
            }
        }

        return index;
    }
	
	/**
	 * Calcul de l'inverse de this
	 * 
	 * @return inverse de this : tableau n x n
	 */
	public Matrice inverse() {
		if (m != n) {
			throw new IllegalArgumentException("Dimensions incorrectes");
		}
		Matrice clone = clone();
		Matrice id = identity();
		int r = -1;
		for (int j = 0; j < n; j++) {
			int k = 0;
			k = maxInColumn(j);
			
			if (!clone.coeff[k][j].equals(Rational.ZERO)){
				Rational a = clone.coeff[k][j];
				r++;
				clone.divideRow(k, a);
				id.divideRow(k, a);
				if (k != r) {
					clone.swapRows(k, r);
					id.swapRows(k, r);
				}
				for (int i = 0; i < n; i++) {
					if (i != r) {
						Rational a2 = clone.coeff[i][j];
						clone.soustraction(r, i, a2);
						id.soustraction(r, i, a2);
					}
				}
			}
			else {
				throw new ArithmeticException("Division par zéro");
			}
		}
		/** On suggère très fortement d'utiliser l'algorithme du pivot de Gauss */
		/** 
                 *  S'il s'avère que la matrice this n'a pas d'inverse :
		 *    throw new ArithmeticException("Division par zéro");
                 */
		return id;
	}

	/**
	 * Résoud une équation linéaire matricielle
	 * 
	 * @param this est une matrice n x m
	 * @param b vecteur m x 1 que l'on veut obtenir
	 * 
	 * @return vecteur colonne a tel que this * a = b : tableau n x 1
	 */
	public Matrice resoud(Matrice b) {
		if (m != b.n) {
			throw new IllegalArgumentException("Dimensions incorrectes");
		}
		Rational[][] a = new Rational[n][1];
		Matrice alpha = new Matrice(a);
		Matrice m = inverse();
		alpha = m.times(b);
		
		/** 
         *  S'il s'avère que l'équation n'a pas de solution :
		 *    throw new ArithmeticException("Pas de solution");
		 *  Si elle a plusieurs solutions :
		 *    on peut renvoyer n'importe quelle solution.
                 */
		return alpha;
	}

	@Override
    public String toString() {
        var sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(Arrays.toString(coeff[i])).append("\n");
        }

        return sb.toString();
    }

}
