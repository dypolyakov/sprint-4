package com.dimqa;

import com.dimqa.pages.HomePage;
import com.dimqa.pages.OrderPage;
import com.dimqa.pages.RentPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final By orderButton;
    private WebDriver driver;

    public OrderScooterTest(By orderButton) {
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[] getOrderButtons() {
        return new Object[] {
                By.xpath(".//div[@class = 'Header_Header__214zg']//button[text() = 'Заказать']"),
                By.className("Button_Middle__1CSJM")
        };
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void orderScooter() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.clickOrderButton(orderButton);

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillForm("Дмитрий", "Поляков", "Самая лучшая улица, 2", "+71234567890");

        RentPage rentPage = new RentPage(driver);
        rentPage.fillForm("13.05.2023", "Комментарий для курьера");

        MatcherAssert.assertThat(rentPage.getOrderPlacedText(), startsWith("Заказ оформлен"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
