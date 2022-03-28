package ansatt;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import avdeling.Avdeling;
import prosjekt.Prosjektdeltagelse;

@Entity
@Table(schema = "oblig_jpa")
public class Ansatt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	private String brukernavn;
	private String fornavn;
	private String etternavn;

	private LocalDate ansattdato;
	private String stilling;
	private int maanedslonn;

	@ManyToOne
	@JoinColumn(name = "avd_id")
	private Avdeling avdeling;

	@OneToMany(mappedBy = "a")
	private List<Prosjektdeltagelse> deltagelser;

	public Ansatt() {
	}

	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansattdato, String stilling,
			int maanedslonn, Avdeling avdeling) {

		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansattdato = ansattdato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		this.avdeling = avdeling;

	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsettelsesdato() {
		return ansattdato;
	}

	public void setAnsettelsesdato(LocalDate ansettelsesdato) {
		this.ansattdato = ansettelsesdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public void setAvdeling(Avdeling avdeling2) {
		this.avdeling = avdeling2;

	}

	public Avdeling getAvdeling() {
		return this.avdeling;
	}

	@Override
	public String toString() {
		return "\n" + "AnsattId=" + id + ", Brukernavn=" + brukernavn + ", Fornavn=" + fornavn + ", Etternavn="
				+ etternavn + ", Ansattdato=" + ansattdato + ", Stilling=" + stilling + ", Lønn=" + maanedslonn + "\n";
	}

	public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
		deltagelser.add(prosjektdeltagelse);

	}
}
