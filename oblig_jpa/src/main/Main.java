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
		System.out.println("brukernavn: " + AnsattDAO.finnAnsattMedBrukernavn(bruker));
		
		System.out.println("finn ansattlisten for alle ansatte");
		String alleAns = ansatt.nextLine();
		System.out.println("AnsattListe: " + AnsattDAO.finnAlleAnsatt());
		
		System.out.println("Oppdater stilling til første ansatt til økonom");
		int førsteAns = ansatt.nextInt();
		String nyStilling = ansatt.nextLine();
		System.out.println("Oppdatert stilling: " + AnsattDAO.oppdaterStilling(førsteAns, nyStilling));
		
		System.out.println("Legg til ny ansatt: ");
		String nyBruker = ansatt.nextLine();
		String nyFor = ansatt.nextLine();
		String nyBak = ansatt.nextLine();
		String nyStil = ansatt.nextLine();
		int nyLonn = ansatt.nextInt();
		int Avd = ansatt.nextInt();
		System.out.println("ny ansatt: " + AnsattDAO.lageNyAnsatt
			(nyBruker, nyFor, nyBak, LocalDate.now(), nyStil, nyLonn, AvdelingDAO.finnAvdeling(Avd)));
				
		
		//Iterasjon 3

		
		
		
		
	}

}
