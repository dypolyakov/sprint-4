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
//import org.openqa.selenium.firefox.FirefoxDriver;

import static com.dimqa.config.AppConfig.APP_URL;
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
        driver = new ChromeDriver();
    }

    @Test
    public void orderScooter() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        RentPage rentPage = new RentPage(driver);

        String phoneNumber = "+71234567890";
        String firstName = "Дмитрий";
        String lastName = "Поляков";
        String address = "Самая лучшая улица, 2";
        String date = "13.05.2023";
        String comment = "Комментарий для курьера";

        driver.get(APP_URL);
        homePage.acceptCookies();
        homePage.clickOrderButton(orderButton);
        orderPage.fillForm(firstName, lastName, address, phoneNumber);
        rentPage.fillForm(date, comment);
        MatcherAssert.assertThat(rentPage.getOrderPlacedText(), startsWith("Заказ оформлен"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
