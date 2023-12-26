package researchPackage;

import java.util.Comparator;
/**
 * Comparator helps to sort ResearchPaper based on their text size count in ascending order
 */
public class PaperLengthComparator implements Comparator<ResearchPaper>{

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		if(o1.text.size() > o2.text.size()) return 1;
		if(o1.text.size() < o2.text.size()) return -1;
		return 0;
	}
}
