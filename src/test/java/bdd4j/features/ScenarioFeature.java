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
