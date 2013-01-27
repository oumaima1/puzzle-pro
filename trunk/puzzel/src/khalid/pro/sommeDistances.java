/*
 * Heuristique :
 * somme des distances  Manhattan
 */
package khalid.pro;

public class sommeDistances implements IHeuristique {

	public int heuristique(Case[][] tab, int dimension) {
		int somme = 0, c = 0;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (tab[i][j].getValeur() != '0') {
					int y = (tab[i][j].getOrdre() - 1) % dimension;
					int x = (tab[i][j].getOrdre() - 1) / dimension;
					c = Math.abs((i - x)) + Math.abs((j - y));
					somme = somme + c;
				}
			}
		}
		return somme;
	}

}
