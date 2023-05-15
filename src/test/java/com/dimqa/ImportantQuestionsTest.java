package com.dimqa;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class ImportantQuestionsTest {
    private WebDriver driver;

    @Test
    public void QuestionsTest() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.clickFirstQuestion();
        String firstAnswerText = homePage.getFirstAnswerText();
        String actual = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        MatcherAssert.assertThat("Текст ошибки", Objects.equals(firstAnswerText, actual));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
