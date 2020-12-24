package jsf.learning_platform.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_id")
	private int testId;

	private String name;

	//bi-directional many-to-one association to Section
	@ManyToOne
	private Section section;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to UserAnswer
	@OneToMany(mappedBy="test")
	private List<UserAnswer> userAnswers;

	public Test() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserAnswer> getUserAnswers() {
		return this.userAnswers;
	}

	public void setUserAnswers(List<UserAnswer> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public UserAnswer addUserAnswer(UserAnswer userAnswer) {
		getUserAnswers().add(userAnswer);
		userAnswer.setTest(this);

		return userAnswer;
	}

	public UserAnswer removeUserAnswer(UserAnswer userAnswer) {
		getUserAnswers().remove(userAnswer);
		userAnswer.setTest(null);

		return userAnswer;
	}

}