package jsf.learning_platform.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the section database table.
 * 
 */
@Entity
@NamedQuery(name="Section.findAll", query="SELECT s FROM Section s")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="section_id")
	private int sectionId;

	@Column(name="class_class_id")
	private int classClassId;

	private String name;

	//bi-directional many-to-one association to Math
	@OneToMany(mappedBy="section")
	private List<Math> maths;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="section")
	private List<Test> tests;

	public Section() {
	}

	public int getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getClassClassId() {
		return this.classClassId;
	}

	public void setClassClassId(int classClassId) {
		this.classClassId = classClassId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Math> getMaths() {
		return this.maths;
	}

	public void setMaths(List<Math> maths) {
		this.maths = maths;
	}

	public Math addMath(Math math) {
		getMaths().add(math);
		math.setSection(this);

		return math;
	}

	public Math removeMath(Math math) {
		getMaths().remove(math);
		math.setSection(null);

		return math;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setSection(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setSection(null);

		return test;
	}

}