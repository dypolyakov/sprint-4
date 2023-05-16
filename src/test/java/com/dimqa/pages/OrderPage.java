package com.dimqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;

    // Текстовое поле "Имя"
    private final By firstNameField = By.xpath(".//input[@placeholder = '* Имя']");
    // Текстовое поле "Фамилия"
    private final By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Текстовое поле "Адрес"
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Выпадающий список "Метро"
    private final By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    // Первая станция метро из списка
    private final By firstMetroStation = By.xpath(".//li[@data-index = '0']");
    // Текстовое поле "Телефон"
    private final By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text() = 'Далее']");

    private final By firstNameErrorText = By.xpath(".//div[@class = 'Input_InputContainer__3NykH'][1]" +
            "//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6']");

    private final By lastNameErrorText = By.xpath(".//div[@class = 'Input_InputContainer__3NykH'][2]" +
            "//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6']");

    private final By addressErrorText = By.xpath(".//div[@class = 'Input_InputContainer__3NykH'][3]" +
            "//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6']");

    private final By metroErrorText = By.className("Order_MetroError__1BtZb");

    private final By phoneNumberErrorText = By.xpath(".//div[@class = 'Input_InputContainer__3NykH'][4]" +
            "//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroStation() {
        driver.findElement(metroField).click();
        driver.findElement(firstMetroStation).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillForm(String firstName, String lastName, String address, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetroStation();
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }

    public String getFirstNameErrorText() {
        return driver.findElement(firstNameErrorText).getText();
    }

    public String getLastNameErrorText() {
        return driver.findElement(lastNameErrorText).getText();
    }

    public String getAddressErrorText() {
        return driver.findElement(addressErrorText).getText();
    }

    public String getMetroErrorText() {
        return driver.findElement(metroErrorText).getText();
    }

    public String getPhoneNumberErrorText() {
        return driver.findElement(phoneNumberErrorText).getText();
    }

}
