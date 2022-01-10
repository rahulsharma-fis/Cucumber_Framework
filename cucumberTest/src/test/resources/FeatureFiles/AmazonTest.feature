@AmazonTest
Feature: Acceptance testing to validate navigating and searching products 
  In order to validate that 
  the navigation and search is working
  Performing the Acceptance Testing

  @Amazon-SearchPositive
  Scenario: Navigate to amazon basics Page & search for a product
    Given I navigate to the  Home Page "https://www.amazon.com/" of Amazon Website
    When I move to Amazon Basics
    When I Search for product "usb" in search page
    Then I should see list of items 