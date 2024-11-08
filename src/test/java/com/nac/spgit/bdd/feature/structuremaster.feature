Feature: I want to make sure the CRUD operations are working fine with the REST API
  Scenario Outline: create a Structure
    Given A Create Structure <request>
    When I send a Post request to /structure
    Then I get the response code 201
    Examples:
      | request                         |
      | {"id":0,"description": "3 bhk"} |
      | {"id":0,"description": "2 bhk"} |
      | {"id":0,"description": "1 bhk"} |
 