package researchPackage;

import java.util.Comparator;

public class ResearcherCitesComparator implements Comparator<ResearcherPerson>{


	@Override
	public int compare(ResearcherPerson o1, ResearcherPerson o2) {
		if(o1.getCites() > o2.getCites()) return -1;
		if(o1.getCites() < o2.getCites()) return 1;
		return 0;
	}

}
