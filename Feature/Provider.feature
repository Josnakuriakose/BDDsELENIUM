Feature: Provider

  Background: 
    Given the user is on the home page

  Scenario: User creates a new provider successfully
    Given user is on the provider page
    When the user clicks on the Add Provider button
    And the user fills in all required provider fields
    And the user clicks the Submit button
    Then the new provider should be created
    And the new provider should be displayed in the provider list

  @Regressions
  Scenario: Delete newly created provider
    Given user is in newly created provider page
    When user click on Delete button
    Then The provider should delete successfully
