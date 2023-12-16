package researchPackage;

import java.util.Vector;

public class ResearcherStudent extends StudentResearcherDecorator{

	Vector<ResearchProject> projects;
	Vector<ResearchPaper> papers;
	
	{
		projects = new Vector<>();
		papers = new Vector<>();
	}
	
	

	public ResearcherStudent(Researcher newResearcher) {
		super(newResearcher);
		System.out.println("adding researcher person");
	}
	
	public Vector<ResearchProject> getProjects() {
		return projects;
	}

	public void setProjects(Vector<ResearchProject> projects) {
		this.projects = projects;
	}

	public Vector<ResearchPaper> getPapers() {
		return papers;
	}

	public void setPapers(Vector<ResearchPaper> papers) {
		this.papers = papers;
	}


	public void submitPapers() {
		if(papers.isEmpty()) {
			System.out.println("You haven't started any research papers");
			return;
		}
		// add functionality to submit papers
	}

	public void startProject(String topic, String description) {
		ResearchProject project = new ResearchProject(topic, description);
		project.joinProject(this);
		projects.add(project);
	}

	public void printPapers() {
		
		if(!papers.equals(null)) {
			for(ResearchPaper p : papers) {
				System.out.println(p.toString());
			}
			return;
		}
		System.out.println("You don't have any papers to print");
	}

	public int calculateHindex() { //check the correctness of this - compare to real h indexes
        if (papers.isEmpty()) return 0;

        int[] citationsArray = new int[papers.size()];

        int i = 0;
        for (ResearchPaper p : papers) {
            citationsArray[i] = p.getCitations();
            i++;
        }

        int hIndex = 0;
        for (int j = 0; j < citationsArray.length; j++) {
            int citations = citationsArray[j];
            if (citations >= j + 1) {
                hIndex = j + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }

	public void modifyProject() {
		//implement logic for working on a project
	}

	@Override
	public ResearchPaper addPaper(String title, String description) {
		ResearchPaper newPaper = new ResearchPaper(title, description);
		papers.add(newPaper);
		return newPaper;
	}

	@Override
	public void removePaper(ResearchPaper p) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return super.toString() + " is a researcher";
	}

	@Override
	public ResearchPaper addPaper(ResearchPaper paper) {
		papers.add(paper);
		return paper;
	}
}
