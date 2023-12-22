package researchPackage;

import java.util.Comparator;

public class PaperLengthComparator implements Comparator<ResearchPaper>{

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		if(o1.text.size() > o2.text.size()) return 1;
		if(o1.text.size() < o2.text.size()) return -1;
		return 0;
	}
}
