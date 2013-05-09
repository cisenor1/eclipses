package star;

import java.awt.event.KeyEvent;
import java.awt.Image;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Toon {
	
	private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    
    private ArrayList<Missile> missiles;
    
    private final int TOON_SIZE = 20;
    
    
    public Toon(){
    	ImageIcon ii = new ImageIcon(this.getClass().getResource("star.png"));
    	image = ii.getImage();
    	missiles = new ArrayList<Missile>();
    	x = 40;
    	y = 60;
    }
    

	public void move(){
		x += dx;
		y += dy;
	}
	
	
    public int getX(){
    	return x;
    }
    
    public int getY(){
    	return y;
    }
    
    public Image getImage(){
    	return image;
    }
    
    public ArrayList getMissiles() {
    	return missiles;
    }

	
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
        	fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }
	
	public void fire() {
		missiles.add(new Missile(x + TOON_SIZE, y + TOON_SIZE/2));
	}

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
		
	}
}



