@smoke_test
Feature: Etsy search feature


  Scenario: Etsy default title verification
    Given user is on the Etsy landing page
    Then user should see title as expected

    #expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Etsy search title verification
    Given user is on the Etsy landing page
    When user searches for "wooden spoon"
    Then user should see "Wooden spoon" in the Etsy title
