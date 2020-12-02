package jsf.learning_platform.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the answer database table.
 * 
 */
@Entity
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;

	private String grade;

	private int points;

	//bi-directional many-to-one association to Math
	@ManyToOne
	private Math math;

	//bi-directional many-to-one association to Math
	@OneToMany(mappedBy="answer")
	private List<Math> maths;

	//bi-directional many-to-one association to UserAnswer
	@OneToMany(mappedBy="answer")
	private List<UserAnswer> userAnswers;

	public Answer() {
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Math getMath() {
		return this.math;
	}

	public void setMath(Math math) {
		this.math = math;
	}

	public List<Math> getMaths() {
		return this.maths;
	}

	public void setMaths(List<Math> maths) {
		this.maths = maths;
	}

	public Math addMath(Math math) {
		getMaths().add(math);
		math.setAnswer(this);

		return math;
	}

	public Math removeMath(Math math) {
		getMaths().remove(math);
		math.setAnswer(null);

		return math;
	}

	public List<UserAnswer> getUserAnswers() {
		return this.userAnswers;
	}

	public void setUserAnswers(List<UserAnswer> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public UserAnswer addUserAnswer(UserAnswer userAnswer) {
		getUserAnswers().add(userAnswer);
		userAnswer.setAnswer(this);

		return userAnswer;
	}

	public UserAnswer removeUserAnswer(UserAnswer userAnswer) {
		getUserAnswers().remove(userAnswer);
		userAnswer.setAnswer(null);

		return userAnswer;
	}

}