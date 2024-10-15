package com.nac.spgit.bdd.stepdefn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRUDStructMsterTest {
    @When("User send HTTP Post request")
    public void method1() {
        System.out.println("When the user send an Http Post request");
    }


    @Then("Result with HTTP.OK response code")
    public void method3() {
        System.out.println("Result with HTTP.OK response code");
    }
}
