package com.nac.spgit.bdd.feature;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/nac/spgit/bdd/feature", glue ={"com.nac.spgit.bdd.stepdefn"} , monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
