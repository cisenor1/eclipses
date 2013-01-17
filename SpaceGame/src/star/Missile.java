package star;


import java.awt.Image;

import javax.swing.ImageIcon;


public class Missile {
	
	private int x, y;
	private Image image;
	boolean visible;
	
	private final int MISSILE_SPEED = 10;
	
	public Missile(int x, int y) {
		
		ImageIcon ii = 
				new ImageIcon(this.getClass().getResource("laser.png"));
		image = ii.getImage();
		visible = true;
		this.x = x + 32;
		this.y = y + 30;
		
	}
	
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void move() {
		
		x += MISSILE_SPEED;
		if (x > Board.sizeX)
			visible = false;
		
	}
}
