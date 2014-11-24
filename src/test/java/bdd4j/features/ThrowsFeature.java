package bdd4j.features;

import org.junit.Before;
import org.junit.Test;

import static bdd4j.Scenario.*;
import bdd4j.*;

/**
 * Als ein Anwender
 * Möchte ich eine Exception werfen können
 * 
 * Wenn nicht IllegalArgumentException geworfen wurde
 * Dann wird ein AssertionError erwartet
 */
public class ThrowsFeature {
	
	private Story story;

	@Before
	public void before() {
		story = new Story();
		
		story.scenario()
			.when(ensureThrows(new Step() {
				@Override
				public void step() {
				}}, IllegalArgumentException.class));
	}
	
	@Test(expected=AssertionError.class)
	public void test() {
		story.run();
	}
}
