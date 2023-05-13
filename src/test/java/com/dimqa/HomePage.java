package com.dimqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Верхняя кнопка "Заказать"
    private By topOrderButton = By.xpath(".//div[@class = 'Header_Header__214zg']//button[text() = 'Заказать']");
    // Нижняя кнопка "Заказать"
    private By bottomOrderButton = By.className("Button_Middle__1CSJM");
    // Кнопка принятия куки "да все привыкли"
    private By cookiesAcceptButton = By.className("App_CookieButton__3cvqF");
    
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
}
