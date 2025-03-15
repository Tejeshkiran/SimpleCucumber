Feature: Verify Google Apis
  @AddPlace @Regression
  Scenario Outline: Verify if user Address is added in server using add place api
  and verify if Address is mapped to same user

    Given add "<name>" "<address>" "<language>" in AddplaceApi payload
    When send the "Post" httprequest using "AddplaceApi"
    Then validate the status code has 200
    And validate response Attribute "status" is "OK"
    And validate response Attribute "scope" is "APP"
    And validate address is mapped to "<name>" using "GetplaceApi"

    Examples:
      | name   | address           | language |
      | Surya  | tamilNadu,Chennai | tamil    |
      | Pushpa | Chitur            | Telugu   |

  @DeletePlace @Regression
  Scenario: To check when user delets location in server location should be deleted

    Given add placeid in body as payload
    When send the "Delete" httprequest using "DeleteplaceApi"
    Then validate the status code has 200
    And validate response Attribute "status" is "OK"






