Feature: 'When user go to the Verint search page, and search for an item,
  User expect to see some reference to that item in the result summary.'

  @search-verint
  Scenario: Search product with product list result validation
    Given user visits the Verint website
    When click the search button
    And search with "news" keyword
    Then article contains that keyword appears