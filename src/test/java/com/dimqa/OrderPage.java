package com.dimqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private By firstNameField = By.xpath(".//input[@placeholder = '* Имя']");
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text() = 'Далее']");
}
