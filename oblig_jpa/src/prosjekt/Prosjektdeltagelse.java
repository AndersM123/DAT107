package prosjekt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ansatt.Ansatt;


@Entity 
@Table(schema = "oblig_jpa")
public class Prosjektdeltagelse {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int deltagelse_id;
	    
	    private int timer;
	    
	    @ManyToOne
	    @JoinColumn(name="ansatt_id")
	    private Ansatt a;
	    
	    @ManyToOne
	    @JoinColumn(name="prosjekt_id")
	    private Prosjekt p;
	    
	    public Prosjektdeltagelse() {}
	    
	    public Prosjektdeltagelse(Ansatt a, Prosjekt p, int timer) {
	    	this.a = a;
	    	this.p = p;
	    	this.timer = timer;
	    }

		public int getTimer() {
			return timer;
		}

		public void setTimer(int timer) {
			this.timer = timer;
		}

		public Ansatt getA() {
			return a;
		}

		public void setA(Ansatt a) {
			this.a = a;
		}

		public Prosjekt getP() {
			return p;
		}

		public void setP(Prosjekt p) {
			this.p = p;
		}

		@Override
		public String toString() {
			return  "Timer=" + timer + ", Ansatte med i prosjekt " + a ;
		}
		
		
}

