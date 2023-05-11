package com.dimqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private WebDriver driver;

    private By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By rentalPeriod = By.className("Dropdown-root");
    private By commentFiled = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }
}
