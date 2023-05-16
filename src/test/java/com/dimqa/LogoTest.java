package com.dimqa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogoTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
    }

    @Test
    public void scooterLogoTest() {
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
    public void yandexLogoTest() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        WebElement yandexLogo = homePage.getYandexLogoElement();
        String actualUrl = yandexLogo.getAttribute("href");
        String expectedUrl = "https://yandex.ru/";

        Assert.assertEquals("Ссылка на логотипе яндекс не совпадает с yandex.ru ",
                expectedUrl,
                actualUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
