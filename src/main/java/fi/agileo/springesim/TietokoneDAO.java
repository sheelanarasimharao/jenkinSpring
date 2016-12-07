package fi.agileo.springesim;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


/*
 * Spring 4:ssa ei enää suositellä käytettäväksi erillistä XML-tiedostoa eikä
 * JpaTemplate-luokkaa, vaan toteutetaan suoraan JPA:n pohjalta.
 * 
 * EntityManager injektoidaan kuten EJB/JSF:ssä standardilla tavalla käyttäen 
 * @PersistenceContext annotaatiota.
 * 
 * Hyvä tutorial: http://www.baeldung.com/spring-dao-jpa
 */

@Repository("tietokoneDao")
@Transactional(propagation = Propagation.REQUIRED)
public class TietokoneDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public TietokoneDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Tietokone> findAll() {
		List<Tietokone> koneet = (List<Tietokone>) em.createQuery("select t from Tietokone t").getResultList();
		return koneet;
	}

	@SuppressWarnings("unchecked")
	public List<Tietokone> findByName(String name) {
		List<Tietokone> koneet = (List<Tietokone>) em.createQuery("select t from Tietokone t where t.merkki=:merkki")
				.setParameter("merkki", name).getResultList();
		return koneet;
	}

	public Tietokone save(Tietokone kone) {
		em.persist(kone);
		return kone;
	}
	
	public Tietokone update(Tietokone kone) {
		em.merge(kone);
		return kone;
	}

	public void delete(Tietokone kone) {
		em.remove(kone);
	}

}
