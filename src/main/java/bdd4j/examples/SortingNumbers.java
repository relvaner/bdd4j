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
