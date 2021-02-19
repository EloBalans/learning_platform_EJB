package jsf.learning_platform.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jsf.learning_platform.entities.Answer;

@Stateless
public class AnswerDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Answer answer) {
		em.persist(answer);
	}

	public Answer merge(Answer answer) {
		return em.merge(answer);
	}

	public void remove(Answer answer) {
		em.remove(em.merge(answer));
	}

	public Answer find(Object id) {
		return em.find(Answer.class, id);
	}
	

	
}
	