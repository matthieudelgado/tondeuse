package com.matthieudelgado.xebia.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.matthieudelgado.xebia.tondeuse.Simulateur;
import com.matthieudelgado.xebia.tondeuse.entites.Tondeuse;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Ordre;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Orientation;
import com.matthieudelgado.xebia.tondeuse.factory.MowItNowFactory;

public class Steps {
	private Simulateur simulateur;

	@Given("un terrain de taille $longueur, $largeur")
	public void initierSimulation(int longueur, int largeur) {
		simulateur = MowItNowFactory.creerSimutaleur(longueur, largeur);
	}
	
	@Given("une tondeuse avec la position $x, $y, $orientation")
	@Alias("une autre tondeuse avec la position $x, $y, $orientation")
	public void initierTondeuse(int x, int y, Orientation orientation) {
	   Tondeuse tondeuse = MowItNowFactory.creerTondeuse(); 
	   simulateur.ajouterTondeuse(tondeuse, x, y, orientation);
	}
	
	@When("on donne l'ordre $ordre a la tondeuse $idTondeuse")
	public void ordonner(List<Ordre> ordres, int idTondeuse) {
	    ordres.stream().forEach(ordre -> simulateur.ordonnerTondeuse(ordre, idTondeuse - 1));
	}
	 
	@Then("la position de la tondeuse  $idTondeuse est $x, $y, $orientation")
	public void verifierPosition(int idTondeuse, int x, int y, Orientation orientation) {
		assertThat(simulateur.getTondeuse(idTondeuse-1).getX(), equalTo(x));
		assertThat(simulateur.getTondeuse(idTondeuse-1).getY(), equalTo(y));
		assertThat(simulateur.getTondeuse(idTondeuse-1).getOrientation(), equalTo(orientation));
	}	
	
	@AfterScenario 
	public void apresScenario() {
		simulateur.dessinerTerrain();
		simulateur.afficherPositionTondeuses();
	}
}