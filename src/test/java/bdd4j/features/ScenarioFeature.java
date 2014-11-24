package bdd4j.features;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bdd4j.Step;
import bdd4j.Story;

/**
 * Als ein Anwender
 * Möchte ich ein Szenario ausführen können
 * 
 * Gegeben ist ein Szenario
 * Wenn das Szenario durchlaufen wurde
 * Dann sollte jeder Einzelschritt durchlaufen sein
 */
public class ScenarioFeature {

	private Story story;
	
	private Boolean[] actuals   = new Boolean[] {false, false, false, false};
	private Boolean[] expecteds = new Boolean[] {true, true, true, true};
	
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
	}
	
	@Test
	public void test() {
		story.run();
		assertArrayEquals(expecteds, actuals);
	}

}
