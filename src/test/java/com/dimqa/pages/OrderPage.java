package com.dimqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    // Текстовое поле "Имя"
    private By firstNameField = By.xpath(".//input[@placeholder = '* Имя']");
    // Текстовое поле "Фамилия"
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Текстовое поле "Адрес"
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Выпадающий список "Метро"
    private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    // Первая станция метро из списка
    private By firstMetroStation = By.xpath(".//li[@data-index = '0']");
    // Текстовое поле "Телефон"
    private By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[text() = 'Далее']");

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

}
