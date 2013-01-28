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

	ArrayList<Puzzle> listSuccesseur=new ArrayList<Puzzle>();
	
	IHeuristique heuristique;
	JButton btSuivat=new JButton("Suivant");
	JButton btPrecedent=new JButton("Precedent");
	JButton btRsolution=new JButton("Resolution");
	
	
	public FenetreDetail(IHeuristique h)
	{
		heuristique=h;
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		// fenetre ************************************************************
		
		this.setSize(405, 250);
		this.setTitle("DÃ©tails");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//Panel d'information *************************************************
		
		JPanel pan_info=new JPanel();
		pan_info.setBorder(BorderFactory.createTitledBorder("Informations :"));
		this.getContentPane().add(pan_info ,BorderLayout.CENTER);
		
		//Button****************************************************************
		
		JPanel pan_bt=new JPanel();
		pan_bt.setBorder(BorderFactory.createTitledBorder(""));
		Dimension dim=new Dimension(120,35);
		btPrecedent.setPreferredSize(dim);
		btSuivat.setPreferredSize(dim);
		pan_bt.setLayout(new BorderLayout());
		pan_bt.add(btSuivat, BorderLayout.EAST);
		pan_bt.add(btRsolution, BorderLayout.CENTER);
		pan_bt.add(btPrecedent, BorderLayout.WEST);
		this.getContentPane().add(pan_bt,BorderLayout.SOUTH);
		
		//Clique sur le bouton Précedent *****************************************
		
		btPrecedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//Clique sur le bouton Suivant *****************************************
		btSuivat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		//Clique sur le bouton Resolution *****************************************
		btRsolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
	}
}
