Feature: Smart Bear Order

  Background: Logged in and goes to Order link
    Given User logs in Smart Bear
    And User goes to Order Page


  Scenario: Purchase scenario
    Then User enters "2" to quantity
    And user enters address information
      | customerName | jamal          |
      | street       | 123 london ave |
      | city         | london         |
      | state        | center         |
      | zip          | 34411          |
    And user enters payment information
      | cardType       | American Express |
      | cardNumber     | 3333444422221111 |
      | expirationDate | 12/24            |
    When User clicks process button
    Then user should see their name in the ViewAllOrders page

  @smartBear
  Scenario Outline: Smart Bear Login

    Then User selects "<product>" from product dropdown
    And User enters "<quantity>" to quantity
    And User enters "<customer name>" to customer name
    And User enters "<street>" to street
    And User enters "<city>" to city
    And User enters "<state>" to state
    And User enters "<zip>" to zip
    And User selects "<cardType>" as card type
    And User enters "<cardNumber>" to card number
    And User enters "<expDate>" to expiration date
    And User clicks process button
    Then User verifies "<expectedName>" is in the list

    Examples: filling the form by passing the following data
      | product     | quantity | customer name | street       | city    | state | zip   | cardType         | cardNumber   | expDate | expectedName  |
      | MyMoney     | 1        | Ken Adams     | Kinzie st    | Chicago | IL    | 60004 | Visa             | 123569874152 | 12/22   | Ken Adams     |
      | FamilyAlbum | 4        | Bob Crystal   | Flamingo st  | Chicago | IL    | 60056 | Master Card      | 555889874152 | 11/22   | Bob Crystal   |
      | ScreenSaver | 6        | Tokm Geller   | Dartshire st | Chicago | IL    | 60055 | Visa             | 987569874152 | 10/22   | Tom Geller    |
      | FamilyAlbum | 7        | Chandler Bing | Dunholme st  | Chicago | IL    | 60044 | American Express | 635569874152 | 09/22   | Chandler Bing |
      | ScreenSaver | 5        | Denis Atieh   | Floyd st     | Chicago | IL    | 60034 | Visa             | 789569874152 | 07/22   | Denise Atieh  |
      | MyMoney     | 3        | Franklin Jobs | Brownhill st | Chicago | IL    | 60010 | Master Card      | 145269874152 | 05/22   | Franklin Jobs |
      | ScreenSaver | 8        | Maria Aspen   | Fountain st  | Chicago | IL    | 60044 | Visa             | 366998874152 | 06/22   | Maria Aspen   |
      | MyMoney     | 10       | Caroline Kim  | Paso st      | Chicago | IL    | 60111 | Visa             | 898745691528 | 11/22   | Caroline Kim  |





