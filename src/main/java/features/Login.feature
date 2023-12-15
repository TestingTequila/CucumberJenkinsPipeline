Feature: Validating Login Test cases
Background:
  Given Open the browser
  And Enter the application url
  When Click on My Account Icon
  And Click on Login Link

  @Sanity
  Scenario: To verify functionality of login page when correct email and correct password is entered

    And Enter correct email
    And Enter correct password
    When Click on Login button
    Then User should be able to Login Successfully
    And Close the browser

    #Ways to pass data from Feature file into Step Definition class file
    # Regular Expression
  @Sanity
  Scenario: To verify functionality of login page when correct email and correct password is entered from feature File using Regular Expression

    And Enter correct email as "kerrie.wright@gmail.com"
    And Enter correct password as "test@1234"
    When Click on Login button
    Then User should be able to Login Successfully
    And Close the browser

    #DataTable
  @Smoke
  Scenario: To verify functionality of login page when correct email and correct password is entered using DataTable

    And Enter correct email and correct password
      | forest.grump@janbask.com | test@1234 | Male | 8860418225 |
    When Click on Login button
    Then User should be able to Login Successfully
    And Close the browser

    #ScenarioOutline [Data Driven Approach]
  @Regression
  Scenario Outline: To verify functionality of login page when correct email and correct password is entered
    And Enter the correct <email> and correct <password>
    When Click on Login button
    Then User should be able to Login Successfully
    And Close the browser

    Examples:
      | email                    | password  |
      | tom.hanks@janbask.com    | test@1234 |
      | kerrie.wright@gmail.com  | test@1234 |
      | forest.grump@janbask.com | test@1234 |
