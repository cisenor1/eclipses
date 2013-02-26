public interface InstructorInterface extends Comparable<InstructorInterface>{

	public void addToMoneyRaised(int amount);
	public void wasDunked();
	public String getNickName();
	public int getMoneyRaised();
	public int getDunks();
}