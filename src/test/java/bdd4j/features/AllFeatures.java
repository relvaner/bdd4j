package bdd4j.features;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ScenarioFeature.class, 
	ScenariosFeature.class,
	ExamplesFeature.class,
	ThrowsFeature.class,
	OutcomeFeature.class})
public class AllFeatures {

}
