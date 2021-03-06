package avdeling;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ansatt.Ansatt;

@Entity
@Table(schema = "oblig_jpa")
public class Avdeling {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String navn;
    
    @OneToMany(mappedBy="avdeling",fetch = FetchType.EAGER)
    private List<Ansatt> ansatte = new ArrayList<>();
    
    
    @OneToOne
    @JoinColumn(name = "sjef_id")
    private Ansatt sjef;
    
    public Avdeling(){}
    
    public Avdeling(String navn,Ansatt sjef, int id) {
    	this.navn = navn;
    	this.sjef = sjef;
    	this.id = id;
    }
    

    public void leggTilAnsatt(Ansatt ansatt) {
        ansatte.add(ansatt);
        ansatt.setAvdeling(this);
    }

    public void fjernAnsatt(Ansatt ansatt) {
        ansatte.remove(ansatt);
        ansatt.setAvdeling(null);
    }

	public int getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public Ansatt getSjef() {
		return sjef;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		return  "AvdelingId=" + id + ", Avdelingsnavn=" + navn + "," + "Sjef=" + sjef.getFornavn() + "]" + "\n" + 
				"Ansatte: " + "\n" + ansatte; 
	

	}
	
		
	}

	
