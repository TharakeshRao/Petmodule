$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/petmodule.feature");
formatter.feature({
  "name": "Test scenarios to verify PetStore Application REST Api services.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add a new pet and verify the pet is added successfully.",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Using POST operation to add a pet with body",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.postmethod.postoperationtoaddnewpet(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Pet with ID:563 created.");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Using GET operation with pet ID to verify the details are added correctly",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.getmethod.getoperationtoverifydetails(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Verified id:563 is updated with values, name:raki ,status:Sold");
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new pet and verify the user is able to delete it successfully.",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Using POST operation to add a pet with body",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.postmethod.postoperationtoaddnewpet(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Pet with ID:568 created.");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Using DELETE operation with ID and verify the data is removed.",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.deletemethod.deleteoperationwithid(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Pet with ID:568 deleted Successfully");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To verify the pet ID and to check data is removed.",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.getmethod.idtocheckdataisremoved(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Pet with ID:568 is not present.");
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update the existing pet with image and verify details updated successfully.",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Using POST operation to add a pet with body",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.postmethod.postoperationtoaddnewpet(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Pet with ID:567 created.");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Using GET operation with pet ID to verify the details are added correctly",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.getmethod.getoperationtoverifydetails(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Verified id:567 is updated with values, name:rakii ,status:Sold");
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Using GET operation to check status of pet.",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Using GET operation to check status of pet.",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.getmethod.getoperationtocheckstatus(DataTable) in file:/C:/Users/Tharakesh/eclipse-workspace2019/Petmodule/target/test-classes/"
});
formatter.write("Verified Response of status:pending");
formatter.result({
  "status": "passed"
});
});