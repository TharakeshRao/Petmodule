Feature:Test scenarios to verify PetStore Application REST Api services.

    
  Scenario: Add a new pet and verify the pet is added successfully.
    Given Using POST operation to add a pet with body
          |  Id     |  Name    |  Status  |        Photo_Url    | Tags_Id  |  Tags_Name |  Category_Id  |  Category_Name |
          |  563    |  raki    |   Sold   |https://image9       |   22     | ilovepets  |       1       |    cat         |
    Then  Using GET operation with pet ID to verify the details are added correctly
          |  Id     |  Name    |  Status  |
          |  563    |  raki    |   Sold   |
          
  Scenario: Add a new pet and verify the user is able to delete it successfully.
    Given Using POST operation to add a pet with body
      |  Id     |  Name    |  Status  |        Photo_Url  | Tags_Id  |  Tags_Name |  Category_Id  |  Category_Name |
      |  568    |  brown   |   pendig   | https://image25 |   91     | smiley     |       1       |    Dog         |
    And  Using DELETE operation with ID and verify the data is removed.
      |  Id     |
      |  568 |
    Then  To verify the pet ID and to check data is removed.
      |  Id     |  Name    |  Status  |
      |  568    |  brown   |  pending |
  
  Scenario: Update the existing pet with image and verify details updated successfully.
    Given Using POST operation to add a pet with body
          |  Id     |  Name    |  Status  |        Photo_Url    | Tags_Id  |  Tags_Name |  Category_Id  |  Category_Name |
          |  567    |  rakii   |   Sold   |https://image12      |   20     | ilovepets  |       1       |    cat         |
    Then  Using GET operation with pet ID to verify the details are added correctly
          |  Id     |  Name    |  Status  |        Photo_Url    | 
          |  567    |  rakii   |   Sold   |  https://image12    |
  
  Scenario: Using GET operation to check status of pet.
    Given Using GET operation to check status of pet.
        |  status  |  
        |  pending |
  
          
    