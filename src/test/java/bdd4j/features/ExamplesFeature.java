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
import static bdd4j.Scenario.*;

/**
 * Als ein Anwender
 * Möchte ich Beispieldaten für Szenarien hinzufügen können
 * 
 * Gegeben sind Vorbedingungen
 * Wenn das Szenario durchlaufen wurde
 * Dann sollen Nachbedingungen gelten
 * 
 * Beispiele sind gegeben
 */
public class ExamplesFeature {

	private Story story;
	
	private Object[][] preconditions = new Object[][] {
			new Integer[] {50, 78, 568, 345, 562},
			new Integer[] {500, 780, 5680, 3450, 5620}
	};
	private Object[][] postconditions = new Integer[][] {
			new Integer[] {0, 1},
			new Integer[] {2, 3}
	};
	
	private int i1, i2, i3;
	
	@Before
	public void before() {
		story = new Story();
		
		i1 = -1;
		story.scenario()
			.example(preconditions[0])
				.captured(postconditions[0])
			.example(preconditions[1])
				.captured(postconditions[1])
			.given(new Step() {
				@Override
				public void step() {
					i1++;
				}})
			.when(new Step() {
				@Override
				public void step() {
					assertArrayEquals(preconditions[i1], example());
				}})
			.then(new Step() {
				@Override
				public void step() {
					assertArrayEquals(postconditions[i1], captured());
				}});
		
		i2 = 0;
		story.scenario(false)
			.example(preconditions[1])
				.captured(postconditions[1])
			.given(new Step() {
				@Override
				public void step() {
					i2++;
				}})
			.when(new Step() {
				@Override
				public void step() {
					assertArrayEquals(preconditions[i2], example());
				}})
			.then(new Step() {
				@Override
				public void step() {
					assertArrayEquals(postconditions[i2], captured());
				}});
		
		i3 = 0;
		story.scenario()
			.given(new Step() {
				@Override
				public void step() {
					i3++;
				}})
			.when(new Step() {
				@Override
				public void step() {
					assertArrayEquals(preconditions[i3], example());
				}})
			.then(new Step() {
				@Override
				public void step() {
					assertArrayEquals(postconditions[i3], captured());
				}});
	}
	
	@Test
	public void test() {
		story.run();
	}

}
