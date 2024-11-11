package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PetClinicPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Owners')]")
    private WebElement owners;

    @FindBy(xpath = "//a[@href='#!/owners/new']")
    private WebElement register;

    @FindBy(xpath = "//input[@ng-model='$ctrl.owner.firstName']")
    private WebElement firstNameXpath;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameXpath;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement addressXpath;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityXpath;

    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement telephoneXpath;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButtonXpath;

    @FindBy(xpath = "//a[@href='#!/owners']")
    private WebElement allOwners;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'Edit Owner')]")
    private WebElement ownerEditButton;

    @FindBy(xpath = "//a[contains(text(),'Add New Pet')]")
    private WebElement addNewPetButton;

    @FindBy(xpath = "//input[@ng-model='$ctrl.pet.name']")
    private WebElement petName;

    @FindBy(xpath = "//input[@ng-model='$ctrl.pet.birthDate']")
    private WebElement petBirthDate;

    @FindBy(xpath = "//select[@ng-model='$ctrl.petTypeId']")
    private WebElement petType;

    @FindBy(xpath = "//a[@href='#!/vets']")
    private WebElement vets;

    public PetClinicPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnOwners() throws InterruptedException {
        Thread.sleep(2000);
        owners.click();
    }

    public void clickOnRegister(){
        register.click();
    }

    public void enterOwnerDetails(String firstName,String lastName,String address,String city,String telephone){
        firstNameXpath.sendKeys(firstName);
        lastNameXpath.sendKeys(lastName);
        addressXpath.sendKeys(address);
        cityXpath.sendKeys(city);
        telephoneXpath.sendKeys(telephone);
        submitButton.click();
    }

    public void clickOnAll() throws InterruptedException {
        Thread.sleep(2000);
        allOwners.click();
    }

    public void verifyOwnerIsAdded(String ownerNameText) throws InterruptedException {
        Thread.sleep(2000);
        WebElement elementByXpath = driver.findElement(By.xpath("//a[contains(text(),'"+ownerNameText+"')]"));
        if(elementByXpath.getText().equalsIgnoreCase("ownerNameText")){
            System.out.println(ownerNameText + " is displayed");
        }else{
            System.out.println(ownerNameText + " is not displayed");
        }
    }

    public void clickOnOwnerName(String ownerNameText) throws InterruptedException {
        Thread.sleep(2000);
        WebElement elementByXpath = driver.findElement(By.xpath("//a[contains(text(),'"+ownerNameText+"')]"));
        elementByXpath.click();
        Thread.sleep(2000);
    }

    public void updateOwnerDetails(String firstName,String telephone) throws InterruptedException {
        ownerEditButton.click();
        Thread.sleep(2000);
        firstNameXpath.clear();
        firstNameXpath.sendKeys(firstName);
        telephoneXpath.clear();
        telephoneXpath.sendKeys(telephone);
        submitButton.click();
    }

    public void verifyUpdateOwnerDetails(String ownerNameText) throws InterruptedException {
        Thread.sleep(2000);
        WebElement elementByXpath = driver.findElement(By.xpath("//a[contains(text(),'"+ownerNameText+"')]"));
        if(elementByXpath.getText().equalsIgnoreCase("ownerNameText")){
            System.out.println(ownerNameText + " is displayed");
        }else{
            System.out.println(ownerNameText + " is not displayed");
        }
    }

    public void clickAddNewPetButton() throws InterruptedException {
        Thread.sleep(3000);
        addNewPetButton.click();
    }

    public void createPet(String petNameText,String petBirth,String petTypeText){
        petName.sendKeys(petNameText);
        petBirthDate.sendKeys(petBirth);
        Select dropdown = new Select(petType);
        dropdown.selectByVisibleText(petTypeText);
        submitButton.click();
    }

    public void verifyNewPet(String petName) throws InterruptedException {
        Thread.sleep(2000);
        WebElement elementByXpath = driver.findElement(By.xpath("//a[contains(text(),'"+petName+"')]"));
        if(elementByXpath.getText().equalsIgnoreCase("ownerNameText")){
            System.out.println(petName + " is displayed");
        }else{
            System.out.println(petName + " is not displayed");
        }
    }

    public void clickOnPetName(String petNameText){
        WebElement elementByXpath = driver.findElement(By.xpath("//a[contains(text(),'"+petNameText+"')]"));
        elementByXpath.click();
    }

    public void updatePet(String petNameText) throws InterruptedException {
        Thread.sleep(2000);
        petName.clear();
        petName.sendKeys(petNameText);
        submitButton.click();
    }

    public void clickOnVeterinarians(){
        vets.click();
    }

    public void listAllVeterinarians() {
        List<WebElement> elementList = driver.findElements(By.xpath("//tr[@ng-repeat='vet in $ctrl.vetList']"));
        for (WebElement row : elementList) {
            List<WebElement> tds = row.findElements(By.tagName("td"));
            for (WebElement td : tds) {
               System.out.println(td);
            }
        }
    }
}
