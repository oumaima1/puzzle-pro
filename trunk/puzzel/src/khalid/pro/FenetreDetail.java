package khalid.pro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreDetail extends JFrame {

	ArrayList<Puzzle> List_successeurs = new ArrayList<Puzzle>();
	ArrayList<Puzzle> Chemin = new ArrayList<Puzzle>();
	Puzzle puzzle;
	IHeuristique heuristique;
	private int jeu = 0;

	JButton btSuivat = new JButton("Suivant");
	JButton btPrecedent = new JButton("Precedent");
	JButton btRsolution = new JButton("Resolution");

	public FenetreDetail(IHeuristique h, Puzzle p) {
		puzzle = p;
		heuristique = h;
		puzzle.setheuristique(h);
		this.init();
		this.setVisible(true);
	}

	public void init() {
		// fenetre ************************************************************

		this.setSize(405, 250);
		this.setTitle("Details");
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// Panel d'information *************************************************

		JPanel pan_info = new JPanel();
		pan_info.setBorder(BorderFactory.createTitledBorder("Informations :"));
		this.getContentPane().add(pan_info, BorderLayout.CENTER);

		// Button****************************************************************

		JPanel pan_bt = new JPanel();
		pan_bt.setBorder(BorderFactory.createTitledBorder(""));
		Dimension dim = new Dimension(120, 35);
		btPrecedent.setPreferredSize(dim);
		btSuivat.setPreferredSize(dim);
		pan_bt.setLayout(new BorderLayout());
		pan_bt.add(btSuivat, BorderLayout.EAST);
		pan_bt.add(btRsolution, BorderLayout.CENTER);
		pan_bt.add(btPrecedent, BorderLayout.WEST);
		this.getContentPane().add(pan_bt, BorderLayout.SOUTH);

		// Clique sur le bouton Pr�cedent
		// *****************************************

		btPrecedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jeu > 0) {
					jeu--;
					jouer(jeu);
				}
			}
		});
		// Clique sur le bouton Suivant
		// *****************************************
		btSuivat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jeu < Chemin.size() - 1) {
					jeu++;
					jouer(jeu);
				}
			}
		});
		// Clique sur le bouton Resolution
		// *****************************************
		btRsolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jeu = 0;
				Chemin.clear();
				List_successeurs.clear();
				boolean solution_trove = false;
				Puzzle meilleur = null;

				List_successeurs.add(new Puzzle(puzzle));
				while (List_successeurs.size() > 0 && !solution_trove) {
					meilleur = List_successeurs.get(0);
					meilleur.setheuristique(heuristique);
					for (int i = 1; i < List_successeurs.size(); i++) {
						Puzzle p = List_successeurs.get(i);
						p.setheuristique(heuristique);
						if (p.heuristique() < meilleur.heuristique()) {
							meilleur = p;
						}
					}
					Chemin.add(meilleur);
					List_successeurs.clear();
					if (meilleur.isInit()) {
						solution_trove = true;
					} else {
						ArrayList<Puzzle> list = meilleur.Successeurs();
						for (Puzzle p : list) {
							if (existDansChemin(p)<0) {
								List_successeurs.add(p);
							}
						}
					}
				}
			}
		});
	}

	private int existDansChemin(Puzzle p) {
		for (int i = 0; i < Chemin.size() - 1; i++) {
			if (p.equals(Chemin.get(i))) {
				System.out.println(i);
				return i;
			}
		}
		return -1;
	}

	private void jouer(int i) {
		puzzle.setPuzzle(Chemin.get(jeu));
		Fenetre.surface.refresh();
	}
}
