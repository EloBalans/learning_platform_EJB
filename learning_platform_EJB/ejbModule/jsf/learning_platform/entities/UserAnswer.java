package jsf.learning_platform.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_answer database table.
 * 
 */
@Entity
@Table(name="user_answer")
@NamedQuery(name="UserAnswer.findAll", query="SELECT u FROM UserAnswer u")
public class UserAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_answer_id")
	private int userAnswerId;

	//bi-directional many-to-one association to Answer
	@ManyToOne
	private Answer answer;

	//bi-directional many-to-one association to Math
	@ManyToOne
	private Math math;

	//bi-directional many-to-one association to Test
	@ManyToOne
	private Test test;

	public UserAnswer() {
	}

	public int getUserAnswerId() {
		return this.userAnswerId;
	}

	public void setUserAnswerId(int userAnswerId) {
		this.userAnswerId = userAnswerId;
	}

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Math getMath() {
		return this.math;
	}

	public void setMath(Math math) {
		this.math = math;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}