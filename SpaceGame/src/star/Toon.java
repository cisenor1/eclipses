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
    private final int shipSpeed = 10;
    
    
    public Toon(){
    	ImageIcon ii = new ImageIcon(this.getClass().getResource("star.png"));
    	image = ii.getImage();
    	missiles = new ArrayList<Missile>();
    	x = 0;
    	y = 60;
    }
    

	public void move(){
		
		if (x < 15 && dx < 0){
			return;
		}
		if (x >= Board.sizeX - 90 && dx > 0){
			return;
		}
		x += dx;
		
		
		if (y < 1 && dy < 0){
			return;
		}
		if (y >= Board.sizeY - 90 && dy > 0){
			return;
		}
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
    
    public ArrayList<Missile> getMissiles() {
    	return missiles;
    }

	
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE ) {
        	fire();
        }

        if ((key == KeyEvent.VK_LEFT) && (x >= 0)) {
            	dx = -shipSpeed;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	if (x <= Board.sizeX) {
            	dx = shipSpeed;
            }
            else {
            	dx = 0;
            }
        }

        if (key == KeyEvent.VK_UP) {
        	if (y >= 0) {
            	dy = -shipSpeed;
            }
            else {
            	dy = 0;
            };
        }

        if (key == KeyEvent.VK_DOWN) {
        	if (y <= Board.sizeY) {
            	dy = shipSpeed;
            }
            else {
            	dy = 0;
            }
        }
    }
	
	public void fire() {
		missiles.add(new Missile(x, y));
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



