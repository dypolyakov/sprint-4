package com.dimqa;

import com.dimqa.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.dimqa.config.AppConfig.APP_URL;
import static com.dimqa.pages.HomePage.*;
//import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class QuestionsTest {
    private WebDriver driver;

    private final By questionLocator;
    private final By answerLocator;
    private final String expected;

    public QuestionsTest(By questionLocator, By answerLocator, String expected) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {firstQuestion, firstAnswer, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {secondQuestion, secondAnswer, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {thirdQuestion, thirdAnswer, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {fourthQuestion, fourthAnswer, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {fifthQuestion, fifthAnswer, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {sixthQuestion, sixthAnswer, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {seventhQuestion, seventhAnswer, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {eighthQuestion, eighthAnswer, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkQuestions() {
        driver.get(APP_URL);
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.clickQuestion(questionLocator);
        String error = "Вопросы о важном: Отображается некорректный текст";
        String actual = homePage.getAnswerText(answerLocator);
        Assert.assertEquals(error, expected, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
