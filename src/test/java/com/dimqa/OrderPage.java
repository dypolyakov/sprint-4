package com.dimqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private By firstNameField = By.xpath(".//input[@placeholder = '* Имя']");
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By metroLubyanka = By.xpath(".//li[@data-index = '8']");
    private By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
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
        driver.findElement(metroLubyanka).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

}
