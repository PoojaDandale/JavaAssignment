Feature: Foreign currency exchange rates api with currency conversion

  Scenario: Checking status code
    Given Rates API for Latest Foreign Exchange rates
    When The API is available
    Then Validate the code

  Scenario: Checking response
    Given Rates API for Latest Foreign Exchange rates
    When The API is available
    Then Validate the response

  Scenario: Checking error response
    Given Rates API for Latest Foreign Exchange rates
    When An incorrect or incomplete url is provided
    Then Validate the correct response

  Scenario: Foreign Exchange rates
    Given Rates API for specific date Foreign Exchange rates
    When The API is available for foreign
    Then success status

  Scenario: Foreign Exchange rates latest
    Given Rates API for specific date Foreign Exchange
    When The API is available for foreign
    Then response assertion

  Scenario: Foreign Exchange rates of today
    Given Rates API for specific date Foreign Exchange rate
    When The future date is privided in the url
    Then future validation
