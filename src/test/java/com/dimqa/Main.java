package com.dimqa;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    private WebDriver driver;

    @Test
    public void orderScooter() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setFirstName("Дмитрий");
        orderPage.setLastName("Поляков");
        orderPage.setAddress("Неглинная улица, 2");
        orderPage.setMetroStation();
        orderPage.setPhoneNumber("+71234567890");
        orderPage.clickNextButton();
    }
}
