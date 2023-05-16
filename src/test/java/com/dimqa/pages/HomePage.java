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
    // 1-ый вопрос в разделе "Вопросы о важном"
    private final By firstQuestion = By.xpath(".//div[@class = 'accordion__item'][1]");
    // 1-ый ответ в разделе "Вопросы о важном"
    private final By firstAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");

    // Логотип "Самокат"
    private final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    // Логотип "Яндекс"
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");

    private final By nameErrorText = By.xpath(".//div[@class = 'Input_InputContainer__3NykH'][1]" +
            "//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6']");

    private final By lastnameErrorText = By.xpath(".//div[@class = 'Input_InputContainer__3NykH'][2]" +
            "//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6']");



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

    public void clickQuestion(String locator) {
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(By.className("accordion"))
        );
        driver.findElement(By.id(locator)).click();
    }

    public String getAnswerText(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        return driver.findElement(By.id(locator)).getText();
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public WebElement getYandexLogoElement() {
        return driver.findElement(yandexLogo);
    }
}