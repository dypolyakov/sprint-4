package com.dimqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private WebDriver driver;

    private By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By rentalPeriod = By.className("Dropdown-root");
    private By firstRentalPeriod = By.xpath(".//div[(@class = 'Dropdown-option' and text() = 'сутки')]");
    private By commentFiled = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    private By confirmButton = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']//button[text() = 'Да']");

    private By orderPlaced = By.className("Order_ModalHeader__3FDaJ");
    

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDate() {
        String date = "13.05.2023";
        driver.findElement(dateField).sendKeys(date, Keys.ENTER);
    }

    public void setRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(firstRentalPeriod).click();

    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public String getOrderPlacedText() {
        return driver.findElement(orderPlaced).getText();
    }
}
