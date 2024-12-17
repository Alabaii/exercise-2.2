package com.mts.pages;

import org.openqa.selenium.By;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {

    private final SelenideElement  showOnMapButton = $x("//button[@data-map-trigger-button='1']//span[contains(text(), 'Показать на карте')]");


    private final SelenideElement image = $(".bd958ba124");


    public SearchResultsPage clickMapButton() {
        showOnMapButton.click();
        return this;
    }


//    public void hoverOverFirstHotel() {
//        hotelCards.first().hover();
//    }


   public HotelPage saveHotelInfoAndOpenMap() {

       String hotelName = $(By.cssSelector("[data-testid='header-title']")).getText();
       SelenideElement starsElement = $("span[data-testid='rating-stars']");
       String starsText = starsElement.getAttribute("aria-label");

// Проверяем, что строка не пуста и содержит нужный текст
       if (starsText != null && starsText.contains("из")) {
           // Извлекаем только часть текста "4 из 5"
           String rating = starsText.split(":")[1].trim();
           System.out.println("Рейтинг: " + rating);
       } else {
           System.out.println("Не удалось извлечь рейтинг.");
       }
       String averageRating = $(By.cssSelector("div.c3deae0c07 .a3b8729ab1.d86cee9b25 .ac4a7896c7")).getText();
       String reviewsCount = $(By.cssSelector(".abf093bdfe.f45d8e4c32.d935416c47")).getText();
       String price =  $(By.cssSelector("span[data-testid='price-and-discounted-price']")).getText();

       // Печатаем результат
       System.out.println("Название отеля: " + hotelName);
       //       System.out.println("Количество звезд: " + rating);
       System.out.println("Средняя оценка: " + averageRating);
       System.out.println("Количество отзывов: " + reviewsCount);
       System.out.println("Стоимость: " + price);


        image.click();

        return new HotelPage();
    }
}
