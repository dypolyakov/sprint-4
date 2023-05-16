package com.dimqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackPage {
    private final WebDriver driver;

    // Изображение "Такого заказа нет"
    private final By notFoundImage = By.xpath(".//img[@alt = 'Not found']");

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNotFoundImageElement() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundImage));
        return driver.findElement(notFoundImage);
    }
}
