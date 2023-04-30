package clockpackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Uhr extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	Timer timer;
	Image backgroundImage;
	Dimension d;
	
	int Xm = 210, Ym = 210, r = 210;
	
	int Xstd, Ystd, Xmin, Ymin, Xsek, Ysek, sek, min, std;
	
	//Aktuelle Zeit:
	LocalDateTime ldt;
	
	public Uhr()
	{		
		backgroundImage = new ImageIcon(this.getClass().getResource("/analoge Uhr.png")).getImage();
		setLayout(null);
		timer = new Timer(1000, this);
		
		timer.start();
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		d = getSize();
		
		g2D.drawImage(backgroundImage, 0, 0, null);
		
		ldt = LocalDateTime.now();
		
		sek = ldt.getSecond();
		min = ldt.getMinute();
		std = ldt.getHour();
		
		Xstd = Xm + (int)(0.5 * r * Math.sin((std * Math.PI/6) + (min * Math.PI/360)));
		Ystd = Ym - (int)(0.5 * r * Math.cos((std * Math.PI/6) + (min * Math.PI/360)));
		
		Xmin = Xm + (int)(0.7 * r * Math.sin(min * Math.PI/30));
		Ymin = Ym - (int)(0.7 * r * Math.cos(min * Math.PI/30));
		
		Xsek = Xm + (int)(0.9 * r * Math.sin(sek * Math.PI/30));
		Ysek = Ym - (int)(0.9 * r * Math.cos(sek * Math.PI/30));		
		
		//StundenZeiger:
		g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(9));
        g2D.drawLine(Xm, Ym, Xstd, Ystd);
		
        //MinutenZeiger:
        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(Xm, Ym, Xmin, Ymin);
        
        //SekundenZeiger:
        g2D.setPaint(Color.red);
        g2D.setStroke(new BasicStroke(1));
        g2D.drawLine(Xm, Ym, Xsek, Ysek);      
           
	}

	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
