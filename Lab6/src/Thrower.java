
public class Thrower implements ThrowerInterface{

	private int balls = 0;
	
	public Thrower(int ballCount){
		balls = ballCount;
	}
	@Override
	public boolean hasNext() {
		if (balls > 0){
			return true;
		}
		return false;
	}

	@Override
	public int next() {
		int numberBall = balls;
		balls--;
		return numberBall;
	}

}
