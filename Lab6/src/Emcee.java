import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Emcee implements EmceeInterface{

	private ArrayList<Instructor> allVictims;
	
	private ThrowerInterface currentThrower;
	private Instructor currentVictim;
	
	
	private int totalFunds;
	
	public Emcee(){
		currentThrower = new Thrower(0);
		currentVictim = new Instructor("");
		allVictims = new ArrayList<Instructor>();
		totalFunds = 0;
	}
	
	
	@Override
	public Iterator<Instructor> iterator() {
		Collections.sort(allVictims);
		Collections.reverse(allVictims);
		return allVictims.iterator();
	}

	@Override
	public ThrowerInterface getCurrentThrower() {
		return currentThrower;
	}

	@Override
	public InstructorInterface getCurrentVictim() {
		return currentVictim;
	}

	@Override
	public void throwerStepsUp(ThrowerInterface nextThrower) {
		currentThrower = nextThrower;
		
	}

	@Override
	public void throwerChoosesVictim(Instructor victim) {
		currentVictim = victim;
		if ((allVictims.indexOf(victim) >= 0) == false){
			allVictims.add(victim);
		}
		
	}

	@Override
	public boolean throwAnother(int fundsPayed) {
		if (currentThrower.hasNext()){
			totalFunds += fundsPayed;
			currentVictim.addToMoneyRaised(fundsPayed);
			currentThrower.next();
			return true;
		}
		return false;
	}

	@Override
	public void dunked() {
		currentVictim.wasDunked();
		
	}

	@Override
	public int getTotalFundsRaised() {
		return totalFunds;
		}

}
