package com.dimqa;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class OrderScooterTest {
    private WebDriver driver;

    @Test
    public void orderScooter() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillForm("Дмитрий", "Поляков", "Неглинная улица, 2", "+71234567890");

        RentPage rentPage = new RentPage(driver);
        rentPage.fillForm("13.05.2023", "Комментарий для курьера");

        MatcherAssert.assertThat(rentPage.getOrderPlacedText(), startsWith("Заказ оформлен"));
    }

    @After
    public void tearDown() {
//        driver.quit();
    }
}
