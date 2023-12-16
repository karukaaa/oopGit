package researchPackage;

import java.util.Comparator;
import researchPackage.ResearchPaper;

public class PaperDateComparator implements Comparator<ResearchPaper>{

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return o1.datePublished.compareTo(o2.datePublished);
	}

}
