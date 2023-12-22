package researchPackage;

import java.util.*;

import studyMaterialsPackage.Faculty;
import usersPackage.*;

public class ResearcherPerson extends User{
	List<ResearchProject> projects;
	List<ResearchPaper> papers;
	List<ResearchPaper> publishedPapers;
	Faculty faculty;
	public final Teacher subjectTeacher;
	public final Student subjectStudent;
	public final GraduateStudent subjectGraduateStudent;
	
	{
		projects = new ArrayList<>();
		papers = new ArrayList<>();
		publishedPapers = new ArrayList<>();
	}	
	
	public ResearcherPerson(String name) {	
		super(name);
		subjectTeacher = null;
		subjectStudent = null;
		subjectGraduateStudent = null;
	}
	public ResearcherPerson(Student subject) {	
		subjectTeacher = null;
		subjectGraduateStudent = null;
		subjectStudent = subject;	
//		this.faculty = subject.getFaculty(); -add when student is completed full
	}
	public ResearcherPerson(Teacher subject) {	
		subjectTeacher = subject;
		subjectStudent = null;	
		subjectGraduateStudent = null;
	}
	public ResearcherPerson(GraduateStudent subject) {	
		subjectTeacher = null;
		subjectStudent = null;	
		subjectGraduateStudent = subject;
	}
	
	
	public User getSubject() {
		if(subjectTeacher!=null) {
			System.out.println(subjectTeacher.toString());
			return subjectTeacher;
		}
		if(subjectStudent!=null) {
			System.out.println(subjectStudent.toString());
			return subjectStudent;
		}
		System.out.println(subjectGraduateStudent.toString());
		return subjectGraduateStudent;
	}

	public Teacher getTeacher() {
		return subjectTeacher;
	}
	public Student getStudent() {
		return subjectStudent;
	}
	public GraduateStudent getGraduateStudent() {
		return subjectGraduateStudent;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	
	public List<ResearchProject> getProjects() {
		return projects;
	}
	public void setProjects(List<ResearchProject> projects) {
		this.projects = projects;
	}

	public List<ResearchPaper> getPapers() {
		return papers;
	}
	public void setPapers(List<ResearchPaper> papers) {
		this.papers = papers;
	}
	
	public ResearchPaper addPaper(String title, String description, NewsManager manager) {
		ResearchPaper newPaper = new ResearchPaper(title, description);
		papers.add(newPaper);
		newPaper.authors.add(this);
		
		newPaper.setManager(manager);
		return newPaper;
	}
	public void removePaper(ResearchPaper p) {
		papers.remove(p);
	}

	public void addPaper(ResearchPaper paper) {
		papers.add(paper);
	}
	
	
	
	public List<ResearchPaper> getPublishedPapers() {
		return publishedPapers;
	}
	public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
		this.publishedPapers = publishedPapers;
	}
	
	public void addPublishedPaper(ResearchPaper p) {
		publishedPapers.add(p);
	}
	public void removePublishedPaper(ResearchPaper p) {
		publishedPapers.remove(p);
	}
	
	
	public void startProject(String topic, String description) {
		ResearchProject project = new ResearchProject(topic, description);
		project.joinProject(this);
		projects.add(project);
	}

	public int calculateHindex() {
		if (papers.isEmpty()) return 0;

        int[] citationsArray = new int[papers.size()];

        int i = 0;
        for (ResearchPaper p : papers) {
            citationsArray[i] = p.getCitations();
            i++;
        }

        Arrays.sort(citationsArray);

        int hIndex = 0;
        int n = citationsArray.length;
        
        for (int j = n - 1; j >= 0; j--) {
            int citations = citationsArray[j];
            int papersWithCitations = n - j;

            if (citations >= papersWithCitations) {
                hIndex = papersWithCitations;
            } else {
                break;
            }
        }
        return hIndex;
	}




	public void printPapers(Comparator c) {
		Collections.sort(papers, c);
		for(ResearchPaper cur: papers) {
			System.out.println(cur);
		}
	}

	public int getCites() {
		int cites=0;
		for(ResearchPaper cur : papers) {
			cites+=cur.getCitations();
		}
		return cites;
	}
	
	public int getCites(int year) {
		int cites = 0;
		for(ResearchPaper cur : papers) {
			if(cur.getDatePublished().getYear()==year)
			cites+=cur.getCitations();
		}
		return cites;
	}


	@Override
	public int compareTo(User o) {		
		if(o.getClass()!=this.getClass()) return 0;
		
		if(getCites() > ((ResearcherPerson)o).getCites()) return 1;
		if(getCites() < ((ResearcherPerson)o).getCites()) return -1;
		return 0;
	}
	
	public String toString() {	
		if(subjectTeacher!=null) return super.toString() + " " +subjectTeacher.toString() + " researcher";
		if(subjectStudent!=null) return super.toString() + " " +subjectStudent.toString() + " researcher";
		if(subjectGraduateStudent!=null) return super.toString() + " " +subjectGraduateStudent.toString();
		else return super.toString() + " researcher";	
	}
	
}
