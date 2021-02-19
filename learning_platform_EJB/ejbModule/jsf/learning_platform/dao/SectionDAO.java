package jsf.learning_platform.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import jsf.learning_platform.entities.Section;

@Stateless
public class SectionDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Section section) {
		em.persist(section);
	}

	public Section merge(Section section) {
		return em.merge(section);
	}

	public void remove(Section section) {
		em.remove(em.merge(section));
	}

	public Section find(Object id) {
		return em.find(Section.class, id);
	}
	
	public List<Section> getFullList() {
		List<Section> list = null;

		Query query = em.createQuery("select s from Section s");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Section> getList(Map<String, Object> searchParams) {
		List<Section> list = null;

		// 1. Build query string with parameters
		String select = "select s ";
		String from = "from Section s ";
		String where = "";
		String orderby = "order by s.name asc";

		// search for surname
		String name = (String) searchParams.get("name");
		if (name != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "s.name like :name ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (name != null) {
			query.setParameter("name", name+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	

}
	