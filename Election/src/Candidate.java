import java.util.Comparator;


public class Candidate implements CandidateInterface {
	private int totalVotes;
	private String firstName;
	private String lastName;
	
	public Candidate(String inFName, String inLName){
		firstName = inFName;
		lastName = inLName;
		totalVotes = 0;
	}
	
	public static Comparator<CandidateInterface> byLastName() {
		return new Comparator<CandidateInterface>() {
			public int compare(CandidateInterface a, CandidateInterface b) {
				String aLastName = a.getLastName();
				String bLastName = b.getLastName();

				int difference = aLastName.compareTo(bLastName);
				if (difference != 0) {
					return difference;
				}

				String aFirstName = a.getFirstName();
				String bFirstName = b.getFirstName();

				difference = aFirstName.compareTo(bFirstName);
				return difference;
			}
		};
	}
	
	@Override
	public void addVote() {
		totalVotes++;
		
	}

	@Override
	public int getVoteCount() {
		return totalVotes;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(CandidateInterface o) {
		int difference = getVoteCount() - o.getVoteCount();
		if (difference != 0){
			return difference;
		}
		difference = lastName.compareTo(o.getLastName());
		if (difference != 0){
			return difference;
		}
		difference = firstName.compareTo(o.getFirstName());
		return difference;
	}

	public boolean equals(Object ot){	
		CandidateInterface o = (CandidateInterface) ot;
		if (! firstName.equals(o.getFirstName())){
			return false;
		}
		if (! lastName.equals(o.getLastName())){
			return false;
		}
		return true;
	}
}
