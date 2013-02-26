
public class DunkDriver {

	public static void main(String[] args) {
		EmceeInterface dunkTank = new Emcee();
		
		ThrowerInterface fred = new Thrower(8);
		
		dunkTank.throwerStepsUp(fred);
		dunkTank.throwerChoosesVictim(new Instructor("DrillSargeant"));
		
		while(dunkTank.throwAnother(200)) {;
			dunkTank.dunked();
		}
		
		ThrowerInterface sam = new Thrower(5);
		dunkTank.throwerStepsUp(sam);
		dunkTank.throwerChoosesVictim(new Instructor("Comp170"));		
		
		while(dunkTank.throwAnother(200)) {
			dunkTank.dunked();
		}
		
		ThrowerInterface joe = new Thrower(3);
		dunkTank.throwerStepsUp(joe);
		dunkTank.throwerChoosesVictim(new Instructor("Comp170"));		
		
		dunkTank.throwAnother(600);
		dunkTank.dunked();
		dunkTank.throwAnother(600);
		dunkTank.throwAnother(600);
		
		System.out.println("Instructor Money Dunks");
		System.out.println("----------------------");
		
		for(InstructorInterface who : dunkTank) {
			System.out.println(who.getNickName() + "\t" +
					who.getMoneyRaised() + "\t" +
					who.getDunks()
					);
		}
		System.out.println("----------------------");

		System.out.println();
		System.out.println("Total money raised is " + dunkTank.getTotalFundsRaised());
	}
}
