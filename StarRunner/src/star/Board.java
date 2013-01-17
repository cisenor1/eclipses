package star;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

	private Toon toon;
	private Timer timer;

	public Board() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		toon = new Toon();

		timer = new Timer(5, this);
		timer.start();

	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(toon.getImage(), toon.getX(), toon.getY(), this);
		
		ArrayList ms = toon.getMissiles();
		
		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile) ms.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}
		

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList ms = toon.getMissiles();
		
		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile)ms.get(i);
			if (m.isVisible())
				m.move();
			else ms.remove(i);
		}
		toon.move();
		repaint();
		
	}

	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			toon.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			toon.keyPressed(e);

		}
	}
}
