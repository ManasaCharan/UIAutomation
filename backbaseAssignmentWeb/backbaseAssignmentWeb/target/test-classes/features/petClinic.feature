Feature: Pet Clinic

  Scenario Outline: Successfully create a Pet Owner
    Given Navigate to PetClinic Page
    When Click on Owners
    Then Select Register from the dropdown
    And  Register the new Owner "<FirstName>" "<LastName>" "<Address>" "<City>" "<Telephone>"
    Examples:
    |FirstName|LastName|Address|City|Telephone|
    |Cooper |Steve   |638 Cardinal Ave.|Sun Prairie|123456789|

  Scenario Outline: Verify the created new Owner is displayed or not in Owners page
    When Click on Owners
    When Navigate to All Owner Page
    Then Verify the Owner is displayed or not in All owners page "<Name>"
    Examples:
      |Name|
      |Cooper Steve|

  Scenario Outline: Verify by updating the Owner Details
    When Click on the "<OwnerName>" to Edit
    When Edit the "<FirstName>" and "<PhoneNumber>"
    Then Verify Updated Owner Details are displayed in All owners page "<FirstName>"
    Examples:
      |OwnerName      |FirstName     |PhoneNumber|
      |Cooper Steve|Cooper Update |123456788|

  Scenario Outline: Add a new Pet
    When Click on Owners
    When Navigate to All Owner Page
    When Click on the "<OwnerName>" to Edit
    Then Click on Add Pet Button
    And Add a new pet "<PetName>" "<PetBirthdate>" "<PetType>"
    Examples:
    |PetName|PetBirthdate|PetType      |OwnerName|
    |Ping    |28/09/2020  |cat          |Cooper Update Steve |

  Scenario Outline: Verify the new Pet added is displayed
    Then Verify the new Pet is displayed in Owner Details Page "<PetName>"
    Examples:
      |PetName|
      |Ping   |

  Scenario Outline: Update the pet details and verify it is updated
    When Click on pet "<PetName>"
    And Update the pet details in Edit Page "<UpdatePetName>"
    Then Verify the pet details are updated "<UpdatePetName>"
    Examples:
    |PetName|UpdatePetName|
    |Ping   |Ping Update  |

  Scenario: Print all the veterinarians
    When Click on veterinarians
    And Print the veterinarians displayed






