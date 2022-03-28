package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import ansatt.Ansatt;
import ansatt.AnsattDAO;
import avdeling.Avdeling;
import avdeling.AvdelingDAO;

public class Main {

	public static void main(String[] args) {
		AnsattDAO ansattdao = new AnsattDAO();
		AvdelingDAO aDao = new AvdelingDAO();
//		Avdeling avdeling = aDao.finnAvdeling(1);
//		List<Ansatt> ansattliste = ansattdao.finnAlleAnsatt();	
//		List<Avdeling> avdliste = aDao.utListning("Salgsavdeling");
//		
//		 Ansatt ansatt_1 = AnsattDAO.lageNyAnsatt
//				("S0H", "Simen", "Helland", LocalDate.now(), "Programmerer", 650000, a);
		
		
		
		// Iterasjon 2
		
		Scanner ansatt = new Scanner(System.in);
	
		System.out.println("Finn ansatt med id: ");	
		int ansattId = ansatt.nextInt();
		System.out.println("ansattId: " + AnsattDAO.FinnAnsattID(ansattId));
		
		System.out.println("finn ansatt med brukernavn");
		String bruker = ansatt.nextLine();
		System.out.println("brukernavn: " + bruker);
		
		System.out.println("finn ansattlisten for alle ansatte");
		String alleAns = ansatt.nextLine();
		System.out.println("AnsattListe: " + alleAns);
		
		

//		System.out.println("Oppdater stilling til første ansatt til økonom");
//		ansattdao.oppdaterStilling(1, "Økonom");
//		System.out.println(ansattdao.finnAnsattMedPK(1));
//		System.out.println("\n---\n");
	//	
//		System.out.println("Oprett ny ansatt");
//		System.out.println("Ansatt nyAnsatt = ansattdao.lageNyAnsatt(Iph1, Dag, Didrik, LocalDate.now(), Økonom, 670000, avdeling");
//		//Ansatt nyAnsatt = ansattdao.lageNyAnsatt("Iph2", "Dag", "Didrik", LocalDate.now(), "Økonom", 670000, avdeling);
//		System.out.println(ansattdao.finnAnsattMedBrukernavn("Iph1"));
		
		
		
		

	}

}
