package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "./Feature/scenario.feature",
		 glue= {"com.stepDefination"},
		 dryRun = false,
		 monochrome = true
		 )
public class Runner {
	 
}
