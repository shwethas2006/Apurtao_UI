Feature:AutomationPractice tests scenarios

  Background: Login to automation practice

    Given I open the browser
    And Open the AutomationPractice application URL
    Then Login with username "app.email" and "app.password" and login


  Scenario: Order T-Shirt and verify the order history
    Given I am on MyAccount Page
    And  I click on T-SHIRTS
    And I select tshirt size small
    And I click on Add to cart
    And I click to proceed to checkout
    And I click to proceed to checkout on summary page
    And I click to proceed to checkout on address page
    Then I click on terms of service checkbox
    And I click to proceed to checkout on shipping page
    And I select pay by bank wire
    And I confirm the order
    And I navigate to Order history page
    Then I verify the order placed is listed in history page

  Scenario: Order T-Shirt and verify the order history
    Given I am on MyAccount Page
    And I navigate to My Personal Information page
    And I change the firstname and click save
    Then verify the firstname changed successfully






