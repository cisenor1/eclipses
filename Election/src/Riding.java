import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Riding implements RidingInterface{
	
	private String name;
	private List<CandidateInterface> candidates;
	
	public Riding(String inName){
		name = inName;
		candidates = new ArrayList<CandidateInterface>();
		
	}
	
	@Override
	public Iterator<CandidateInterface> iterator() {
		Collections.sort(candidates);
		Collections.reverse(candidates);
		return candidates.iterator();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addCandidate(CandidateInterface who) {
		candidates.add(who);
	}

	@Override
	public void voteFor(CandidateInterface fakeWho) {
		int foundPosition = candidates.indexOf(fakeWho);
		if (foundPosition == -1) {
			return;
		}

		CandidateInterface toUpdate = candidates.get(foundPosition);
		toUpdate.addVote();
		
	}

	@Override
	public CandidateInterface getWinner() {
		CandidateInterface max = Collections.max(candidates);
		return max;
	}
	
	public Iterator<CandidateInterface> byLastName() {
		Collections.sort(candidates, Candidate.byLastName());
		return candidates.iterator();
	}
	

}
