public interface EmceeInterface extends Iterable<Instructor>{

	public ThrowerInterface getCurrentThrower();
	public InstructorInterface getCurrentVictim();
	public void throwerStepsUp(ThrowerInterface nextThrower);
	public void throwerChoosesVictim(Instructor victim);
	public boolean throwAnother(int fundsPayed);
	public void dunked();
	public int getTotalFundsRaised();
}