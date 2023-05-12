package com.dimqa;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class Main {
    private WebDriver driver;

    @Test
    public void orderScooter() {
        driver = new FirefoxDriver();
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

        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.setDate();
        aboutRentPage.setRentalPeriod();
        aboutRentPage.clickOrderButton();
        aboutRentPage.clickConfirmButton();

        MatcherAssert.assertThat(aboutRentPage.getOrderPlacedText(), startsWith("Заказ оформлен"));
    }

    @After
    public void tearDown() {
//        driver.quit();
    }
}
