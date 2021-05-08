Feature: to run tests

  Scenario Outline: Click Services button
    Given I connect to epam.com
    When I click on "<buttons>" button
    Then I check that I come to "<page>" page
    Examples:
      | buttons      | page         |
      | SERVICES     | services     |
      | HOW WE DO IT | how-we-do-it |
      | OUR WORK     | our-work     |


  Scenario: Switch to Russian
    Given I connect to epam.com
    When I click on 'language' button
    And I click on 'Russian' button
    Then I check that page changed its careers region

  Scenario: Check search function
    Given I connect to epam.com
    When I click on 'search' button
    And I enter 'junior'
    Then I check that page changed to search result

  Scenario: Check button hover
    Given I connect to epam.com
    When I point cursor to 'CONSULT'
    Then I check that it is hovered by text

  Scenario: Check link to 'INFONGEN'
    Given I connect to epam.com
    When I click on 'INFONGEN' button
    Then I check that 'https://www.infongen.com/' opens on a new page

  Scenario: Check 'Contact us'
    Given I connect to epam.com
    When I click on 'Contact Us' button
    Then I check that I come to "about/who-we-are/contact" page

  Scenario: Check FAQ
    Given I connect to epam.com
    When I point cursor to 'ABOUT'
    And I click on 'FAQ' button
    Then I check that I come to investors page

  Scenario: Check 'CAREERS'
    Given I connect to epam.com
    When I point cursor to 'CAREERS'
    And I click on 'Blog' button
    Then I check that I come to "careers/blog" page
