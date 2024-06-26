@Pet
@CRUD
Feature: CRUD pet and body validation

  @issue:BA-39-addNewPetToStore
  Scenario: Checks if pet is added correctly to the store
    When Add a new pet to the store
    Then The response with status code 200 is returned
    And Check the response body of created pet is correct

  @issue:BA-53-updateExistingPet
  Scenario: Checks if pet is updated correctly
    When Update an existing pet
    Then The response with status code 200 is returned
    And Check the response body of updated pet is correct

  @issue:BA-54-deletePet
  Scenario: Checks if pet is deleted correctly
    When Delete an existing pet
    Then The response with status code 200 is returned
    And Check if pet is not found

  @issue:BA-55-retrievingPetInformationById
    Scenario: Checks if pet is found by id
     When Find pet by id
     Then The response with status code 200 is returned
     And Check the response body of found pet is correct

  @issue:BA-56-findingPetByStatus
  Scenario: Checks if pets with certain status are correctly returned
    When Finds Pets by status "available"
    Then Check if status "available" is returned

  @issue:BA-56-findingPetByStatus
  Scenario Outline: Checks the response code for returned pets by status
    When Finds Pets by status "<status>"
    Then The response with status code 200 is returned

    Examples:
      | status |
      | available |
      | pending |
      | sold |

  @issue:BA-57-uploadingImagForPet
  Scenario: Upload an image for a pet
    When Upload an image for a pet
    Then The response with status code 200 is returned