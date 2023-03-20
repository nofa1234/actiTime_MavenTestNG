package com.hr.qa.testrunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "E:/8th semester/Emerging Trends/Assignment/project/ICT_18_847/src/main/java/com/hr/qa/feature"
		,glue={"com/hr/qa/stepdefinitions"}
		,monochrome = true,
				strict=true,
				dryRun=false
				
		)


public class TestRunner {

}
