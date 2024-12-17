package com.mts.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private SelenideElement searchField = $("input[name='ss']");
    private SelenideElement searchButton = $x("//button[.//span[text()='Найти']]");
    private  SelenideElement dateFieldButton = $("button[data-testid='date-display-field-start']");
    private SelenideElement flexiblePlansButton = $("#flexible-searchboxdatepicker-tab-trigger");
    private SelenideElement weekendOption = $x("//label//div[contains(text(), 'На выходные')]");
    private SelenideElement monthOption = $x("//label[@data-testid='flexible-dates-month']//span[contains(text(), 'Янв') and following-sibling::span[text()='2025']]");
    private SelenideElement selectDatesButton = $("button:has(span.e4adce92df)");

    public HomePage openHomePage() {
        open("https://booking.com/");
        return this;
    }


    public HomePage enterCity(String city) {
        searchField.setValue(city);
        return this;
    }

    public HomePage selectFlexibleDates() {
        dateFieldButton.click();
        // Клик по кнопке "У меня гибкие планы"
        flexiblePlansButton.click();

        // Клик по опции "На выходные"
        weekendOption.click();

        // Убедимся, что чекбокс для гибких дат выбран
        monthOption.click();

        // Клик по кнопке "Выберите даты"
        selectDatesButton.click();

        return this;
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage();
    }
}
