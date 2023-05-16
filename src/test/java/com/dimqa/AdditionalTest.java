package com.dimqa;

import com.dimqa.pages.HomePage;
import com.dimqa.pages.OrderPage;
import com.dimqa.pages.TrackPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdditionalTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
    }

    @Test
    public void checkScooterLogo() {
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        HomePage homePage = new HomePage(driver);
        homePage.clickScooterLogo();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";

        Assert.assertEquals("При клике на логотип самоката происходит переход на неверный URL",
                actualUrl,
                expectedUrl);
    }

    @Test
    public void checkyandexLogoLink() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        WebElement yandexLogo = homePage.getYandexLogoElement();
        String actualUrl = yandexLogo.getAttribute("href");
        String expectedUrl = "https://yandex.ru/";

        Assert.assertEquals("Ссылка на логотипе яндекс не совпадает с yandex.ru ",
                expectedUrl,
                actualUrl);
    }

    @Test
    public void checkErrorsInOrderForm() {
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickNextButton();
        orderPage.setAddress("1234");

        Assert.assertEquals(orderPage.getFirstNameErrorText(), "Введите корректное имя");
        Assert.assertEquals(orderPage.getLastNameErrorText(), "Введите корректную фамилию");
        Assert.assertEquals(orderPage.getAddressErrorText(), "Введите корректный адрес");
        Assert.assertEquals(orderPage.getMetroErrorText(), "Выберите станцию");
        Assert.assertEquals(orderPage.getPhoneNumberErrorText(), "Введите корректный номер");
    }

    @Test
    public void checkMissingOrder() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.clickStatusButton();
        homePage.setOrderSearchField("123123");
        homePage.clickGoButton();

        TrackPage trackPage = new TrackPage(driver);
        Assert.assertNotNull(trackPage.getNotFoundImageElement());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
