package prosjekt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(schema = "oblig_jpa")
public class Prosjekt {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	
	 	private String navn;
	 	private String beskrivelse;
	 	
	 	@OneToMany(mappedBy = "p",fetch = FetchType.EAGER)
	 	 List<Prosjektdeltagelse> deltagelser = new ArrayList<>();
	 	
	 	
	 	public Prosjekt() {}
	 	
	 	public Prosjekt(String navn, String beskrivelse) {
	 		this.navn = navn;
	 		this.beskrivelse = beskrivelse;
	 	}
	 	 public void leggTilProsjektdeltagelse(Prosjektdeltagelse deltagelse) {
	         deltagelser.add(deltagelse);
	     }

	     public void fjernProsjektdeltagelse(Prosjektdeltagelse deltagelse) {
	         deltagelser.remove(deltagelse);
}			
	     
	     @Override
	     public String toString() {
	    	 return "Prosjekt id: " + id +  ", Navn: " + navn + ", Rolle: " + beskrivelse + 
	    			 "\n" + "Prosjektdeltagelser: " + deltagelser;
	     }
		public String getNavn() {
			return navn;
		}
		public void setNavn(String navn) {
			this.navn = navn;
		}
		public String getBeskrivelse() {
			return beskrivelse;
		}
		public void setBeskrivelse(String beskrivelse) {
			this.beskrivelse = beskrivelse;
		}
	     
}