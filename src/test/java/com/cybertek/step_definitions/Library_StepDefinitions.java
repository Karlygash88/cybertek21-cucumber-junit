package com.cybertek.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Library_StepDefinitions {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters LIBRARIAN username");
        //Assert.fail("INTENTIONAL FAIL!!!");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters LIBRARIAN password");
    }

    @Then("user should see dashboard")
    public void userShouldSeeDashboard() {
        System.out.println("User sees dashboard");
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        System.out.println("User enters STUDENT username");
    }

    @When("user enters student password")
    public void user_enters_student_password() {
        System.out.println("User enters STUDENT password");
    }

    @When("user enters admin username")
    public void user_enters_admin_username() {
        System.out.println("User enters ADMIN username");
    }

    @When("user enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("User Enters ADMIN password");
    }
}
