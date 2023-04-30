package clockpackage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Fenster extends JFrame
{	
	
	public Fenster()
	{		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Rolexx");
		setIconImage(new ImageIcon(this.getClass().getResource("/Clock-icon.png")).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
		add(new Uhr());
		setSize(435,460);
		setResizable(false);
		setLocationRelativeTo(null);

		setVisible(true);
	}
}
