package bdd4j.features;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bdd4j.Step;
import bdd4j.Story;

/**
 * Als ein Anwender
 * Möchte ich Szenarien ausführen können
 * 
 * Gegeben sind zwei Szenarien
 * Wenn die Szenarien durchlaufen wurden
 * Dann sollte jeder Einzelschritt durchlaufen sein
 */
public class ScenariosFeature {

	private Story story;
	
	private Boolean[] actuals   = new Boolean[] {false, false, false, false, false, false, false, false, false};
	private Boolean[] expecteds = new Boolean[] {true, true, true, true, true, true, true, true, true};
	
	@Before
	public void before() {
		story = new Story();
		
		story.scenario()
			.given(new Step() {
				@Override
				public void step() {
					actuals[0] = true;
				}})
			.and(new Step() {
				@Override
				public void step() {
					actuals[1] = true;
				}})
			.when(new Step() {
				@Override
				public void step() {
					actuals[2] = true;
				}})
			.then(new Step() {
				@Override
				public void step() {
					actuals[3] = true;
				}});
		
		story.scenario()
			.given(new Step() {
				@Override
				public void step() {
					actuals[4] = true;
				}})
			.when(new Step() {
				@Override
				public void step() {
					actuals[5] = true;
				}})
			.and(new Step() {
				@Override
				public void step() {
					actuals[6] = true;
				}})
			.and(new Step() {
				@Override
				public void step() {
					actuals[7] = true;
				}})
			.then(new Step() {
				@Override
				public void step() {
					actuals[8] = true;
				}});		
	}
	
	@Test
	public void test() {
		story.run();
		assertArrayEquals(expecteds, actuals);
	}

}
