Feature: validate Google Apis

  @Addplace @Regression
  Scenario Outline: verify if place is added using AddPlaceApi
  and able to get the place details using GetPalceAPi

    Given add "<name>" "<address>" "<language>" in AddplaceApi payload
    When call "AddplaceApi" with "Post" http method
    Then validate response has 200 status code
    And validate response parameter has "status" is "OK"
    And validate response parameter has "scope" is "APP"
    And validate place is madded to "<name>" using "GetPlaceAPI"

    Examples:

      | name    | address | language  |
      | maxwell | Ausis   | Australia |
      | sam     | England | English   |









