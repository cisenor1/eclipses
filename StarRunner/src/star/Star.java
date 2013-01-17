package star;


import javax.swing.JFrame;


public class Star extends JFrame  {

	public Star() {
		
		add(new Board());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,428);
		setLocationRelativeTo(null);
		setTitle("R - Type");
		setResizable(false);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Star();
	}
	
}
