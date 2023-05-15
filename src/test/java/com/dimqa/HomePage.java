package com.dimqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    // Верхняя кнопка "Заказать"
    private By topOrderButton = By.xpath(".//div[@class = 'Header_Header__214zg']//button[text() = 'Заказать']");
    // Нижняя кнопка "Заказать"
    private By bottomOrderButton = By.className("Button_Middle__1CSJM");
    // Кнопка принятия куки "да все привыкли"
    private By cookiesAcceptButton = By.className("App_CookieButton__3cvqF");

    private By firstQuestion = By.xpath(".//div[@class = 'accordion__item'][1]");
    private By firstAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.findElement(cookiesAcceptButton).click();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public void clickFirstQuestion() {
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", firstQuestion);
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(firstQuestion));
        driver.findElement(firstQuestion).click();
    }

    public String getFirstAnswerText() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(firstAnswer));
        return driver.findElement(firstAnswer).getText();
    }
}
