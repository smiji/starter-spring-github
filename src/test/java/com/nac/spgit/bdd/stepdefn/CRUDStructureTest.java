package com.nac.spgit.bdd.stepdefn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRUDStructureTest {
    @Given("A Create Structure \\{{string}:{int},{string}: {string}}")
    public void a_create_structure(String string, Integer int1, String string2, String string3) {

    }
    @When("I send a Post request to \\/structure")
    public void i_send_a_post_request_to_structure() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I get the response code {int}")
    public void i_get_the_response_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
