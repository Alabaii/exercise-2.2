package com.mts.pages;

import org.openqa.selenium.By;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {

    private final SelenideElement showOnMapButton = $x("//button[@data-map-trigger-button='1']//span[contains(text(), 'Показать на карте')]");


    //private final SelenideElement image = $(".bd958ba124");


    public MapPage clickShowOnMapButton() {
        showOnMapButton.click();
        return new MapPage();
    }
}
