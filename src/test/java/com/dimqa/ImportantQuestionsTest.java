package com.dimqa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImportantQuestionsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }

    @Test
    public void QuestionsTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.clickFirstQuestion();
        String error = "Вопросы о важном: Отображается некорректный текст";
        String actual = homePage.getFirstAnswerText();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals(error, expected, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
