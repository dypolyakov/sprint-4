package com.dimqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    // Верхняя кнопка "Заказать"
    private final By topOrderButton = By.xpath(".//div[@class = 'Header_Header__214zg']//button[text() = 'Заказать']");
    // Нижняя кнопка "Заказать"
    private final By bottomOrderButton = By.className("Button_Middle__1CSJM");
    // Кнопка принятия куки "да все привыкли"
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
    private final By goButton = By.xpath(".//button[@class = 'Button_Button__ra12g Header_Button__28dPO']");





    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.findElement(cookiesAcceptButton).click();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }
    public By getTopOrderButton() {
        return topOrderButton;
    }

    public By getBottomOrderButton() {
        return bottomOrderButton;
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public void clickQuestion(String locator) {
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(By.className("accordion"))
        );
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id(locator)));
        driver.findElement(By.id(locator)).click();
    }

    public String getAnswerText(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        return driver.findElement(By.id(locator)).getText();
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
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }
}
