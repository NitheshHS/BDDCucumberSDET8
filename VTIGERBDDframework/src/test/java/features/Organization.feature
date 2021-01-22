Feature: Organization feature
  

 Scenario: As a valid user I wnat to create an oraganization
    Given I want to navigate to organization 
    And naviagate to create new organizationpage by click on +  image
    When create a organization with madatory field "TY"
    Then I validate the Oraganization created or not
    


