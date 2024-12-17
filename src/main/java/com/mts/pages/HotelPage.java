package com.mts.pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HotelPage {

    private SelenideElement hotelName = $("h2[data-testid='header-title']");
    String newHotelName = hotelName.getText();
   // private SelenideElement hotelStars = $("span.hp__hotel-stars");
   // Ищем элемент с классом, содержащим оценку
   SelenideElement ratingElement = $(".ac4a7896c7");

    // Извлекаем текст из найденного элемента
    String newRating = ratingElement.getText();
    // Ищем элемент, который содержит количество отзывов
    SelenideElement reviewsElement = $("div.c3deae0c07 .a3b8729ab1.d86cee9b25 .ac4a7896c7");

    // Извлекаем текст из найденного элемента
    String newReviewsText = reviewsElement.getText();
 //   private SelenideElement hotelPrice = $(".bui-price-display__value");


    public void verifyHotelInfo() {
        System.out.println("Hotel Info on page: " +
                newHotelName + " " +
               // hotelStars.getText() + " " +
                newRating + " " +
               // hotelReviews.getText() + " " +
                newReviewsText);
    }
}
