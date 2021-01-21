Feature: Login feature
  I want to test the login functionality of Vtiger Application

  Background: 
    Given I want to launch the browser
    And I will navigate to login page by entering the url "http://localhost:8888"

@SmokeTest @Functional
  Scenario: I want to login to Vtiger Application as a valid user
    When I enter valid username "admin" and password "manager" and click on login button
    Then I validate Home page is displayed or not "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"
    And I signout from application
@Functional
  Scenario Outline: I want to create multiple organization
    When I enter valid username "admin" and password "manager" and click on login button
    And I will click on organization
    And In organization page I will click on create organization icon
    And I enter the organization name "<organizationName>" and click on save button
    Then I validate that organization name is displayed in the info or not

    Examples: 
      | organizationName |
      | Qspiders         |
      | Jspiders         |
      | pySpiders        |

@Functional
  Scenario: I will try to login to vtiger application by using invalid credentials
  When I enter the invalid username and password
  	|admin123|manager123|
  Then I validate that error message is displayed or not
