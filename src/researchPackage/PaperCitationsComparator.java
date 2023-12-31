package researchPackage;

import java.util.Comparator;

/**
 * Comparator helps to sort ResearchPaper based on their citation count in ascending order
 */
public class PaperCitationsComparator implements Comparator<ResearchPaper>{

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		if (o1.getCitations() > o2.getCitations()) return 1;
		else if (o1.getCitations() < o2.getCitations()) return -1;
		else return 0;
	}

}
