package researchPackage;

import java.util.Comparator;
/**
 * Comparator helps to sort ResearchPaper based on their publishedDate from oldest to newest
 */
public class PaperDateComparator implements Comparator<ResearchPaper>{

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return o1.datePublished.compareTo(o2.datePublished);
	}

}
