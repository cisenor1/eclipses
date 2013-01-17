package star;


import java.awt.event.KeyEvent;
import java.awt.Image;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import star.Board;
import star.Missile;

public class Baddie {
	
	private int x, y;
	private Image image;
	boolean visible;
	private ArrayList<Baddie> baddie;
	
	private final int BaddieSpeed = 10;
	
	public Baddie() {
		
		ImageIcon ii = 
				new ImageIcon(this.getClass().getResource("Baddie.png"));
		image = ii.getImage();
		
		visible = true;
		this.x = 299;
		this.y = 80;
		
	}
	
	public void hit(){
		
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
		
//		x += MISSILE_SPEED;
//		if (x > Board.sizeX)
//			visible = false;
		
	}
}