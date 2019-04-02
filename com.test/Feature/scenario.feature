@tag
Feature: Search Bus form Mumbai to Nashik and search for Andheri hotel 

  @tag1
  Scenario Outline: Title of your scenario
    Given User is on home screen
    Then User enter source as "<source>" 
    Then User enter destination as "<destination>"
    And User select "<date>" of journey
    And User click on search bus button
    Then User select non-ac bus and click on view seat
    Then User select seat 
    Then User select boarding point
    Then User select dropping point
    Then User click on proceed to payment
    And User unselect insurance option
    Then User validate amount 
    
   Examples:
     
    | source | destination |date|
    | Dadar  | Nasik       | 29 |

@tag2
  Scenario Outline: Title of your scenario
    Given User is on home screen
    Then User click on hotel option
    And User enter area "<area>"
    Then User click on search button
    Then User validate result
    
       Examples:
     
    | area     |
    | Andheri  |