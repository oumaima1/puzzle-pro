package khalid.pro;

public class caseBienPlacee implements IHeuristique {

	@Override
	public int heuristique(Case[][] tab, int dimension) {

		int compt = 1, n = 0;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (tab[i][j].getOrdre() == compt) {
					n++;
				}
				compt++;
			}
		}
		return n * -1;
	}

	public String toString() {
		return "le nombre de case bien placées ";
	}

}
