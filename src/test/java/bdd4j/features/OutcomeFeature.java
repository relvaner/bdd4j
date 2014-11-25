/*
 * bdd4j - Framework for behavior-driven development
 * Copyright (c) 2014, David A. Bauer
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
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
