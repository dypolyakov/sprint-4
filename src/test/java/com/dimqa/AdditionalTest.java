package com.dimqa;

import com.dimqa.pages.HomePage;
import com.dimqa.pages.OrderPage;
import com.dimqa.pages.TrackPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.dimqa.config.AppConfig.APP_URL;
import static com.dimqa.config.AppConfig.ORDER_URL;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class AdditionalTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkScooterLogo() {
        driver.get(APP_URL);

        HomePage homePage = new HomePage(driver);
        homePage.clickScooterLogo();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";

        Assert.assertEquals("При клике на логотип самоката происходит переход на неверный URL",
                actualUrl,
                expectedUrl);
    }

    @Test
    public void checkYandexLogoLink() {
        driver.get(APP_URL);

        HomePage homePage = new HomePage(driver);
        String originalWindow = driver.getWindowHandle();

        assert driver.getWindowHandles().size() == 1;

        homePage.clickYandexLogo();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://dzen.ru/?yredirect=true";

        Assert.assertEquals("Открывается вкладка с некорректным адресом",
                expectedUrl,
                currentUrl);
    }

    @Test
    public void checkErrorsInOrderForm() {
        driver.get(ORDER_URL);

        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickNextButton();
        orderPage.setAddress("1234");

        Assert.assertEquals(orderPage.getFirstNameErrorText(), "Введите корректное имя");
        Assert.assertEquals(orderPage.getLastNameErrorText(), "Введите корректную фамилию");
        Assert.assertEquals(orderPage.getAddressErrorText(), "Введите корректный адрес");
        Assert.assertEquals(orderPage.getMetroErrorText(), "Выберите станцию");
        Assert.assertEquals(orderPage.getPhoneNumberErrorText(), "Введите корректный номер");
    }

    @Test
    public void checkMissingOrder() {
        driver.get(APP_URL);

        HomePage homePage = new HomePage(driver);
        homePage.clickStatusButton();
        homePage.setOrderSearchField("123123");
        homePage.clickGoButton();

        TrackPage trackPage = new TrackPage(driver);
        Assert.assertNotNull(trackPage.getNotFoundImageElement());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
