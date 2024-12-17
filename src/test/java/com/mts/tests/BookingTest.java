package com.mts.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.mts.pages.HomePage;
import com.mts.pages.SearchResultsPage;
import com.mts.pages.HotelPage;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@Epic("Функциональность бронирования")
@Feature("Поиск отелей")
public class BookingTest {
    @BeforeAll
    public static void setupAll() {
        // Этот метод будет вызван перед всеми тестами
        System.out.println("Настройка окружения...");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));

        // Настройка Chrome в режиме инкогнито
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // Режим инкогнито
        options.addArguments("--start-maximized"); // Открыть на полный экран
        options.addArguments("--disable-notifications"); // Отключить уведомления
        options.addArguments("--disable-geolocation");
        options.addArguments("--no-restore-session-state");
        options.addArguments("--disable-location-services");
        options.addArguments("--disable-cache");

        // Передача настроек браузеру
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;

        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }
    @BeforeEach
    public void setup() {
        // Этот метод будет вызываться перед каждым тестом
        System.out.println("Запуск теста поиска отелей...");
    }

    @Test
    @DisplayName("Тест поиска отелей в Праге")
    @Tag("critical")
    @Description("Тест поиска отелей по карте в Праге")
    public void testBookingSearch() {
        HomePage homePage = new HomePage();
        homePage.openHomePage()
                .enterCity("Прага")
                .selectFlexibleDates();
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();
        searchResultsPage.clickMapButton();
        HotelPage hotelPage = searchResultsPage.saveHotelInfoAndOpenMap();
        hotelPage.verifyHotelInfo();
    }
}