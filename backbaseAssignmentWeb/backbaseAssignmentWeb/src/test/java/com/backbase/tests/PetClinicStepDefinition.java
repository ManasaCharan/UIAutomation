package com.backbase.tests;


import com.base.BrowserFactory;
import com.pages.PetClinicPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PetClinicStepDefinition extends BaseTest {
//    SearchResultsPage searchResultsPage;
//    public SearchTest(){
//        this.searchResultsPage = new SearchResultsPage(driver);
//
//    }
    private PetClinicPage petClinicPage;
    private WebDriver driver;

    public PetClinicStepDefinition() {
        this.driver = BrowserFactory.getDriver();
        petClinicPage = PageFactory.initElements(driver, PetClinicPage.class);
    }

    @Given("Navigate to PetClinic Page")
    public void navigateToPetClinicPage() {
//        driver = BrowserFactory.createChromeDriver();
        driver.get("http://localhost:8080");
    }

    @When("Click on Owners")
    public void clickOnOwners() throws InterruptedException {
        petClinicPage.clickOnOwners();
    }

    @Then("Select Register from the dropdown")
    public void selectRegisterFromTheDropdown() {
        petClinicPage.clickOnRegister();
    }


    @And("Register the new Owner {string} {string} {string} {string} {string}")
    public void registerTheNewOwner(String firstName, String lastName, String address, String city, String telephone) {
        petClinicPage.enterOwnerDetails(firstName,lastName,address,city,telephone);
    }

    @When("Navigate to All Owner Page")
    public void navigateToAllOwnerPage() throws InterruptedException {
        petClinicPage.clickOnAll();

    }

    @Then("Verify the Owner is displayed or not in All owners page {string}")
    public void verifyTheOwnerIsDisplayedOrNotInAllOwnersPage(String name) throws InterruptedException {
        petClinicPage.verifyOwnerIsAdded(name);
    }

    @When("Edit the {string} and {string}")
    public void editTheAnd(String name, String phoneno) throws InterruptedException {
        petClinicPage.updateOwnerDetails(name,phoneno);
    }

    @When("Click on the {string} to Edit")
    public void clickOnTheToEdit(String name) throws InterruptedException {
        petClinicPage.clickOnOwnerName(name);
    }

    @Then("Verify Updated Owner Details are displayed in All owners page {string}")
    public void verifyUpdatedOwnerDetailsAreDisplayedInAllOwnersPage(String name) throws InterruptedException {
        petClinicPage.clickOnOwners();
        petClinicPage.clickOnAll();
        petClinicPage.verifyUpdateOwnerDetails(name);
    }

    @Then("Click on Add Pet Button")
    public void clickOnAddPetButton() throws InterruptedException {
        petClinicPage.clickAddNewPetButton();
    }


    @And("Add a new pet {string} {string} {string}")
    public void addANewPet(String petName, String petBirthDate, String petType) {
        petClinicPage.createPet(petName,petBirthDate,petType);
    }

    @Then("Verify the new Pet is displayed in Owner Details Page {string}")
    public void verifyTheNewPetIsDisplayedInOwnerDetailsPage(String petName) throws InterruptedException {
        petClinicPage.verifyNewPet(petName);
    }

    @When("Click on pet {string}")
    public void clickOnPet(String petName) {
        petClinicPage.clickOnPetName(petName);
    }

    @And("Update the pet details in Edit Page {string}")
    public void updateThePetDetailsInEditPage(String petName) throws InterruptedException {
        petClinicPage.updatePet(petName);
    }

    @Then("Verify the pet details are updated {string}")
    public void verifyThePetDetailsAreUpdated(String petName) throws InterruptedException {
        petClinicPage.verifyNewPet(petName);
    }

    @When("Click on veterinarians")
    public void clickOnVeterinarians() {
        petClinicPage.clickOnVeterinarians();
    }

    @And("Print the veterinarians displayed")
    public void printTheVeterinariansDisplayed() {
        petClinicPage.listAllVeterinarians();
    }

}
