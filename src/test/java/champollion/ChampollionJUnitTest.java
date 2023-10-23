package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML", 8, 15, 20);
		java = new UE("Programmation en java", 10, 12, 18);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testHeurePrevu(){
		//8h de TD pour le module UML
		untel.ajouteEnseignement(uml, 0, 10, 0);
		assertEquals(10, untel.heuresPrevues(), "L'enseignant a 8h de prévues");

	}
	@Test
	public void testEstEnSousService(){
		//Cas : en sous-service où l'enseignant fait 50h d'intervention il est en dessous de 192h
		untel.ajouteEnseignement(uml, 13, 17, 20);
		assertTrue(untel.sousService(), "L'enseignant est en sous service");

		//Cas : pas en sous-service
		//ajout de 160h
		untel.ajouteEnseignement(uml, 20, 36, 24 );
		untel.ajouteEnseignement(java, 20, 24, 36);
		assertTrue(untel.sousService(), "L'enseignant n'est pas en sous service");

	}

	@Test
	public void testVerifierTypeIntervention(){
		ServicePrevu s = new ServicePrevu(10, 5, 20, uml, untel);
		assertTrue(s.getUe().equals(uml), "Bon UE");
	}
	
}
