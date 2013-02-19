
public class ElectionTime {

	public static void main(String[] args) {


		Riding springfield = new Riding("Springfield");
		springfield.addCandidate(new Candidate("Homer", "Simpson"));
		springfield.addCandidate(new Candidate("Clancy", "Wiggum"));
		springfield.addCandidate(new Candidate("Ralph", "Wiggum"));
		springfield.addCandidate(new Candidate("Seymour", "Skinner"));
		
		Candidate fakeHomer = new Candidate("Homer", "Simpson");
		Candidate fakeClancy = new Candidate("Clancy", "Wiggum");
		Candidate fakeRalph = new Candidate("Ralph", "Wiggum");
		Candidate fakeSeymour = new Candidate("Seymour", "Skinner");
		
		for (int i = 0; i < 32341; i++){
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeHomer);
			springfield.voteFor(fakeClancy);
			springfield.voteFor(fakeClancy);
			springfield.voteFor(fakeClancy);
			springfield.voteFor(fakeClancy);
			springfield.voteFor(fakeClancy);
			springfield.voteFor(fakeClancy);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeRalph);
			springfield.voteFor(fakeSeymour);
			springfield.voteFor(fakeSeymour);
			springfield.voteFor(fakeSeymour);
			springfield.voteFor(fakeSeymour);
			springfield.voteFor(fakeSeymour);
		}
		
		
		System.out.println(springfield.getWinner().getFirstName() + " " + springfield.getWinner().getLastName() + " is the winner!\n");
		
		for (CandidateInterface schmo : springfield){
			System.out.println(schmo.getFirstName() + " " + schmo.getLastName() + " has " + schmo.getVoteCount() + " votes.");
		}
		
		
	}	

}
