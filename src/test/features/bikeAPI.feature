Feature: Find Country in API

  Scenario Outline: Find Country in API on providing city
    Given I create a request with base URL "http://api.citybik.es" and with basepath "/v2/networks"
    When I fire a get request
    Then I verify that in the response the city '<city>' is in the country '<country>'
    And I return their corresponded latitude and longitude of the given city
    Examples:
      |city|country|
     |Paris|FR    |
     |Frankfurt|DE|
    |Noc|nocounry|