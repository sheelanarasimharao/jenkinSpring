package fi.agileo.springesim;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity JPA toteututs.
 * Managed Bean tarjotaan JSF:lle. VOidaan käyttää JSF:n kontrollerista
 */

@Entity
@Table(name="SpringTkone")
@NamedQueries({ @NamedQuery(name = "haeKaikki", query = "SELECT t from Tietokone t"),
	@NamedQuery(name = "etsiNimella", query = "SELECT t from Tietokone t where t.merkki like :nimi") })
public class Tietokone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	String merkki;
	String malli;

	public Tietokone() {
		this.merkki = "HP";
		this.malli = "Elitebook";
	}

	public Tietokone(String merkki, String malli) {
		this.merkki = merkki;
		this.malli = malli;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	@Override
	public String toString() {
		return "Tietokone [merkki=" + merkki + ", malli=" + malli + "]";
	}

}