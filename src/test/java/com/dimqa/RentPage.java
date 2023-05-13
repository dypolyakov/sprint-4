package com.dimqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private WebDriver driver;

    // Текстовое поле "Дата"
    private By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // Выпадающий список "Срок аренды"
    private By rentalPeriod = By.className("Dropdown-root");
    // Первый элемент выпадающего списка "Срок аренды" - "Сутки"
    private By oneDayPeriod = By.xpath(".//div[(@class = 'Dropdown-option' and text() = 'сутки')]");
    // Текстовое поле "Комментарий"
    private By commentFiled = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    // Чекбокс выбора черного цвета
    private By blackColorCheckbox = By.xpath(".//label[@for = 'black']");
    // Чекбокс выбора серого цвета
    private By greyColorCheckbox = By.xpath(".//label[@for = 'grey']");
    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    // Кнопка подтверждения заказа в модальном окне "Хотите оформить заказ?"
    private By confirmButton = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']//button[text() = 'Да']");

    // Модальное окно успешного заказа
    private By orderPlaced = By.className("Order_ModalHeader__3FDaJ");
    

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date, Keys.ENTER);
    }

    public void setRentalPeriod(String period) {
        driver.findElement(rentalPeriod).click();
        String xpath = String.format(".//div[(@class = 'Dropdown-option' and text() = '%s')]", period);
        By locator = By.xpath(xpath);
        driver.findElement(locator).click();
    }

    public void setColor(String color) {
        switch (color) {
            case "Black":
                driver.findElement(blackColorCheckbox).click();
                break;
            case "Grey":
                driver.findElement(greyColorCheckbox).click();
                break;
            default:
                break;
        }

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
