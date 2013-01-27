package khalid.pro;

public class Case {
	private char valeur;
	private int ordre;
	public static int compteur = 0;

	public Case() {
		compteur++;
		this.valeur = (char) (compteur + 64);
		this.ordre = compteur;
	}

	public char getValeur() {
		return valeur;
	}

	public void setValeur(char valeur) {
		this.valeur = valeur;
	}

	public int getOrdre() {
		return ordre;
	}
	public String toString() {
		return String.valueOf(this.valeur);
	}

}
