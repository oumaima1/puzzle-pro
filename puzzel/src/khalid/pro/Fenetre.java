package khalid.pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Future;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Fenetre extends JFrame implements KeyListener {

	Puzzle puzzle;
	Surface surface;

	JMenuBar menu = new JMenuBar();
	
	JMenu menuDimension = new JMenu("Dimension");
	JMenu menuFichier = new JMenu("Fichier");
	JMenu menuHeristique = new JMenu("Heuristique");
	JMenu menuAction=new JMenu("Action");
	
	JMenuItem mi2 = new JMenuItem("2 x 2");
	JMenuItem mi3 = new JMenuItem("3 x 3");
	JMenuItem mi4 = new JMenuItem("4 x 4");
	JMenuItem mi5 = new JMenuItem("5 x 5");
	JMenuItem miQuitter = new JMenuItem("Quitter");
	JMenuItem mih1 = new JMenuItem("h1 :Case male plac� ");
	JMenuItem mih2 = new JMenuItem("h2 :Somme des distances ");
	JMenuItem miInitatisation =new JMenuItem("Initialisation");
	JMenuItem miDesordonnee =new JMenuItem("Desordonnée");
	
	

	public Fenetre() {
		this.addKeyListener(this);
		this.init();
	}

	private void init() {

		// JFrame-----------------------------------------------------------------------

		this.setSize(405, 451);
		this.setTitle("Puzzle 2.0");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// JMenu--------------------------------------------------------------------------
		menu.add(menuFichier);
		menu.add(menuAction);
		menu.add(menuDimension);
		menu.add(menuHeristique);
		menuFichier.add(miQuitter);
		menuDimension.add(mi2);
		menuDimension.add(mi3);
		menuDimension.add(mi4);
		menuDimension.add(mi5);
		menuHeristique.add(mih1);
		menuHeristique.add(mih2);
		menuAction.add(miInitatisation);
		menuAction.add(miDesordonnee);
		
		this.setJMenuBar(menu);
		// Evenement
		// JMenu---------------------------------------------------------------

		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initPuzzle(2);
			}
		});
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initPuzzle(3);
			}
		});
		mi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initPuzzle(4);
			}
		});
		mi5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initPuzzle(5);
			}
		});
		miInitatisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initPuzzle(puzzle.getDimension());
			}
		});
		miDesordonnee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.Desordonner();
				surface.refresh();
			}
		});
		miQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mih1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FenetreDetail f=new FenetreDetail(new casesNonPlace());
			}
		});
		mih2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreDetail f=new FenetreDetail(new sommeDistances());
			}
		});

		// ------------------------------------------------------------------------------

		this.puzzle = new Puzzle(new sommeDistances(), 3);
		this.surface = new Surface(puzzle, 400);
		this.getContentPane().add(surface);

		this.setVisible(true);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			puzzle.Permutation_Basse();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			puzzle.Permutation_Haute();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			puzzle.Permutation_Droite();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			puzzle.Permutation_Gauche();
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
	}

	public void initPuzzle(int dimension) {
		this.puzzle.setDimension(dimension);
		this.surface.refresh();
	}

}
