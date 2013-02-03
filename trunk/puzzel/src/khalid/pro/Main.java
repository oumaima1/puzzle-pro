package khalid.pro;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

	//	String name = System.getProperty ( "os.name" );
	//	System.out.println(name);
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				Fenetre f=new Fenetre();
			}
		});

	}
}
