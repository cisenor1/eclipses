package star;


import javax.swing.JFrame;



public class Star extends JFrame  {
	
	private static final long serialVersionUID = 1L;

	public Star() {
		
		add(new Board());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Board.sizeX,Board.sizeY);
		setLocationRelativeTo(null);
		setTitle("R - Type");
		setResizable(false);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Star();
	}
	
}
