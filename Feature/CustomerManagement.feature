@Regressions
Feature: Customer Management activities
 
  Background:
    Given User is login to send2 page
 
  
  Scenario: User can Export CSV
    Given User navigate to Customer Management page
    When User Export CSV
    Then User should able to Export CSV
 
  
  