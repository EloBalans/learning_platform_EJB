package jsf.learning_platform.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the math database table.
 * 
 */
@Entity
@NamedQuery(name="Math.findAll", query="SELECT m FROM Math m")
public class Math implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="math_id")
	private int mathId;

	@Column(name="`answer A`")
	private String answer_A;

	@Column(name="`answer B`")
	private String answer_B;

	@Column(name="`answer C`")
	private String answer_C;

	@Column(name="`answer D`")
	private String answer_D;

	private String content;

	private String experience;

	private String operation;

	private Time time;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="math")
	private List<Answer> answers;

	//bi-directional many-to-one association to Answer
	@ManyToOne
	private Answer answer;

	//bi-directional many-to-one association to Section
	@ManyToOne
	private Section section;

	//bi-directional many-to-one association to UserAnswer
	@OneToMany(mappedBy="math")
	private List<UserAnswer> userAnswers;

	public Math() {
	}

	public int getMathId() {
		return this.mathId;
	}

	public void setMathId(int mathId) {
		this.mathId = mathId;
	}

	public String getAnswer_A() {
		return this.answer_A;
	}

	public void setAnswer_A(String answer_A) {
		this.answer_A = answer_A;
	}

	public String getAnswer_B() {
		return this.answer_B;
	}

	public void setAnswer_B(String answer_B) {
		this.answer_B = answer_B;
	}

	public String getAnswer_C() {
		return this.answer_C;
	}

	public void setAnswer_C(String answer_C) {
		this.answer_C = answer_C;
	}

	public String getAnswer_D() {
		return this.answer_D;
	}

	public void setAnswer_D(String answer_D) {
		this.answer_D = answer_D;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setMath(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setMath(null);

		return answer;
	}

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<UserAnswer> getUserAnswers() {
		return this.userAnswers;
	}

	public void setUserAnswers(List<UserAnswer> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public UserAnswer addUserAnswer(UserAnswer userAnswer) {
		getUserAnswers().add(userAnswer);
		userAnswer.setMath(this);

		return userAnswer;
	}

	public UserAnswer removeUserAnswer(UserAnswer userAnswer) {
		getUserAnswers().remove(userAnswer);
		userAnswer.setMath(null);

		return userAnswer;
	}

}