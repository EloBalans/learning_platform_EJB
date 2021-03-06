package jsf.learning_platform.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jsf.learning_platform.entities.User;

@Stateless
public class UserDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(User user) {
		em.persist(user);
	}

	public User merge(User user) {
		return em.merge(user);
	}

	public void remove(User user) {
		em.remove(em.merge(user));
	}

	public User find(Object id) {
		return em.find(User.class, id);
	}
	
	public List<User> getUsers() {
		List<User> list = null;

		Query query = em.createQuery("select u from User u");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public String getUserRole()
	{
		return "0";
	}

	public List<User> getUser(String email, String password) {
		List<User> user = null;

		
		String select = "select u ";
		String from = "from User u ";
		String where = "";
		String orderby = "";

		
		if (email != null&&password != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "u.email like :email and u.password like :password ";
		}
		
		Query query = em.createQuery(select + from + where + orderby);

			query.setParameter("email", email);
			query.setParameter("password", password);

		try {
			user = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}
	