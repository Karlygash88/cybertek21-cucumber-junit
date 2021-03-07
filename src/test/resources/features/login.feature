@1
Feature: Library app login feature
  As a user, I should be able to login with correct credentials to different accounts. And dashboard
  Accounts are:librarian, student, admin
  #this is how we comment in feature file

  Background: User is already in login page
    Given user is on the login page

  @librarian @employee
  Scenario:Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see dashboard

  @student
  Scenario: Login as Student
    When user enters student username
    And user enters student password
    Then user should see dashboard

  @admin @employee @db
  Scenario: Login as Admin
    When user enters admin username
    And user enters admin password
    Then user should see dashboard








