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
package bdd4j.examples;

import static bdd4j.OutcomeFactory.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bdd4j.*;

public class SortingNumbers {
	
	private Story story;
	
	private List<Integer> list;

	@Before
	public void before() {
		story = new Story();
		
		story.scenario()
			.annotate("Scenario: Sorting numbers")
			.annotate("Given a list of numbers")
			.given(new Step() {
				@Override
				public void step() {
					list = new LinkedList<Integer>();
					list.add(367);
					list.add(50);
					list.add(5678);
				}})
			.annotate("When I sort the list")
			.when(new Step() {
				@Override
				public void step() {
					Collections.sort(list);
				}})
			.annotate("Then the list will be in numerical order")
			.then(new Step() {
				@Override
				public void step() {
					outcome((int)list.get(0)).shouldBe(50);
					outcome((int)list.get(1)).shouldBe(367);
					outcome((int)list.get(2)).shouldBe(5678);
				}});
	}
	
	@Test
	public void test() {
		story.run();
	}
}
