package bdd4j.features;

import org.junit.Test;

import static bdd4j.OutcomeFactory.*;

/**
 * Als ein Anwender
 * Möchte ich ein Ergebnis Überprüfen können
 * 
 * Wenn ein Ergebnis überprüft werden soll
 * Dann muss eine Bedingung erfüllt werden
 */
public class OutcomeFeature {
	
	@Test
	public void test1() {
		outcome(true).shouldBeTrue();
		outcome(false).shouldBeFalse();
		outcome(true).shouldBe(true);
		outcome(true).shouldNotBe(false);
		outcome(34).shouldBe(34);
		outcome(34).shouldNotBe(2);
		outcome(34.5).shouldBe(34.5, 0.001);
		outcome(34.9).shouldNotBe(2.4, 0.001);
		outcome("34").shouldBe("34");
		outcome("34").shouldNotBe("2");
		Object o = null;
		outcome(o).shouldBeNull();
		outcome(32).shouldBeNotNull();
		o = new Object(); Object o2 = o;
		outcome(o).shouldBe(o2);
		outcome(new Object()).shouldNotBe(new Object());
		outcome(new Object[]{12, 56.4, "AB"}).shouldBe(new Object[]{12, 56.4, "AB"});
	}
	
	@Test(expected=AssertionError.class)
	public void test2() {
		outcome(34).shouldBe(20);
	}
}
