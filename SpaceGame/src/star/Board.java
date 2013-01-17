package star;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	
	public static int sizeX = 1200;
	public static int sizeY = 600;
	private static final long serialVersionUID = 1L;
	private Toon toon;
	private Baddie baddie;
	private Timer timer;
	private int gameSpeed = 10  ;

	public Board() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		setDoubleBuffered(true);

		toon = new Toon();
		baddie = new Baddie();

		timer = new Timer(gameSpeed, this);
		timer.start();

	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(toon.getImage(), toon.getX(), toon.getY(), this);
		
		g2d.drawImage(baddie.getImage(), baddie.getX(), baddie.getY(), this);

		ArrayList<?> ms = toon.getMissiles();									// gets number of missiles and stores it in the index.
;

		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile) ms.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<?> ms = toon.getMissiles();
		//ArrayList<?> bs = BaddieMaker.getBaddies()

		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile) ms.get(i);
			//Baddie b = (Baddie) bs.get(i);
			if (m.isVisible())
				m.move();
			else if (m.getX() == baddie.getX() && m.getY() == baddie.getY()){
				baddie.hit();
				ms.remove(i);
				}
			else{
				ms.remove(i);
		}
		}
		toon.move();
		repaint();

	}
	
	/*public void generateBaddie(){
		baddie.add(new Baddie(x, y));
	}

	*/private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			toon.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			toon.keyPressed(e);

		}
	}
}
