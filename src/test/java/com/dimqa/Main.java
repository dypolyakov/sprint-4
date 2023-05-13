package com.dimqa;

import com.dimqa.constants.Color;
import com.dimqa.constants.RentalPeriod;
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

        RentPage rentPage = new RentPage(driver);
        rentPage.setDate("13.05.2023");
        rentPage.setRentalPeriod(RentalPeriod.ONE_DAY);
        rentPage.setColor(Color.BLACK);
        rentPage.clickOrderButton();
        rentPage.clickConfirmButton();

        MatcherAssert.assertThat(rentPage.getOrderPlacedText(), startsWith("Заказ оформлен"));
    }

    @After
    public void tearDown() {
//        driver.quit();
    }
}
