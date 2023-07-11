package com.dimqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    private final By cookiesAcceptButton = By.className("App_CookieButton__3cvqF");
    // Логотип "Самокат"
    private final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    // Логотип "Яндекс"
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    // Кнопка "Статус заказа"
    private final By statusButton = By.className("Header_Link__1TAG7");
    // Поле поиска по номеру заказа "Введите номер заказа"
    private final By orderSearchField = By.xpath(".//input[@class = 'Input_Input__1iN_Z Header_Input__xIoUq']");
    // Кнопка Go поиска заказа

    // 1-ый вопрос в разделе "Вопросы о важном"
    public static final By firstQuestion = By.id("accordion__heading-0");
    // 2-ый вопрос в разделе "Вопросы о важном"
    public static final By secondQuestion = By.id("accordion__heading-1");
    // 3-ый вопрос в разделе "Вопросы о важном"
    public static final By thirdQuestion = By.id("accordion__heading-2");
    // 4-ый вопрос в разделе "Вопросы о важном"
    public static final By fourthQuestion = By.id("accordion__heading-3");
    // 5-ый вопрос в разделе "Вопросы о важном"
    public static final By fifthQuestion = By.id("accordion__heading-4");
    // 6-ый вопрос в разделе "Вопросы о важном"
    public static final By sixthQuestion = By.id("accordion__heading-5");
    // 7-ый вопрос в разделе "Вопросы о важном"
    public static final By seventhQuestion = By.id("accordion__heading-6");
    // 8-ый вопрос в разделе "Вопросы о важном"
    public static final By eighthQuestion = By.id("accordion__heading-7");

    // 1-ый ответ в разделе "Вопросы о важном"
    public static final By firstAnswer = By.id("accordion__panel-0");
    // 2-ый ответ в разделе "Вопросы о важном"
    public static final By secondAnswer = By.id("accordion__panel-1");
    // 3-ый ответ в разделе "Вопросы о важном"
    public static final By thirdAnswer = By.id("accordion__panel-2");
    // 4-ый ответ в разделе "Вопросы о важном"
    public static final By fourthAnswer = By.id("accordion__panel-3");
    // 5-ый ответ в разделе "Вопросы о важном"
    public static final By fifthAnswer = By.id("accordion__panel-4");
    // 6-ый ответ в разделе "Вопросы о важном"
    public static final By sixthAnswer = By.id("accordion__panel-5");
    // 7-ый ответ в разделе "Вопросы о важном"
    public static final By seventhAnswer = By.id("accordion__panel-6");
    // 8-ый ответ в разделе "Вопросы о важном"
    public static final By eighthAnswer = By.id("accordion__panel-7");
    // Кнопка GO
    private final By goButton = By.xpath(".//button[@class = 'Button_Button__ra12g Header_Button__28dPO']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.findElement(cookiesAcceptButton).click();
    }

    public void clickQuestion(By locator) {
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(By.className("accordion"))
        );
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public String getAnswerText(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void clickOrderButton(By button) {
        driver.findElement(button).click();
    }

    public void clickStatusButton() {
        driver.findElement(statusButton).click();
    }

    public void setOrderSearchField(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderSearchField));
        driver.findElement(orderSearchField).sendKeys(orderNumber);
    }

    public void clickGoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }
}
