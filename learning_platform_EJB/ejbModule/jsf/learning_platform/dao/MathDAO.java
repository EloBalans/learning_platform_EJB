package jsf.learning_platform.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import jsf.learning_platform.entities.Math;
import jsf.learning_platform.entities.Section;

@Stateless
public class MathDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Math math) {
		
		em.persist(math);
	}

	public Math merge(Math math) {
		return em.merge(math);
	}

	public void remove(Math math) {
		em.remove(em.merge(math));
	}

	public Math find(Object id) {
		return em.find(Math.class, id);
	}
	
	public List<Math> getFullList() {
		List<Math> list = null;

		Query query = em.createQuery("select m from Math m");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Math> getList(Section section) {
		List<Math> list = null;

		// 1. Build query string with parameters
		String select = "select m ";
		String from = "from Math m ";
		String where = "where m.section like :sectionId ";

	
	
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where);

		query.setParameter("sectionId", section);
		
		
		

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	

}
	