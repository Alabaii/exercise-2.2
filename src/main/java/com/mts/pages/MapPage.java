package com.mts.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MapPage {
    private String hotelName;
    private String starsText;
    private String averageRating;
    private String reviewsCount;
    private String price;

    private final SelenideElement shotelName = $("[data-testid='header-title']");
    private final SelenideElement starsElement = $("span[data-testid='rating-stars']");
    private final SelenideElement saverageRating = $x("//div[contains(text(), 'Оценка')]");
    private final SelenideElement sreviewsCount = $x("//div[contains(@class, 'abf093bdfe') and contains(@class, 'd935416c47')]");
    private final SelenideElement sprice = $("span[data-testid='price-and-discounted-price']");
    private final SelenideElement image = $("[data-testid='lazy-image-container']");

    public MapPage saveHotelInfo() {

        hotelName = shotelName.getText();

        starsText = starsElement.getAttribute("aria-label");

// Проверяем, что строка не пуста и содержит нужный текст
        if (starsText != null && starsText.contains("из")) {
            // Извлекаем только часть текста "4 из 5"
            String rating = starsText.split(":")[1].trim();
            System.out.println("Рейтинг: " + rating);
        } else {
            System.out.println("Не удалось извлечь рейтинг.");
        }
        averageRating = saverageRating.getText();
        reviewsCount = sreviewsCount.getText();
        price = sprice.getText();


        return this;
    }
        public String getHotelName() {
            return hotelName;
        }

        public String getStars() {
            return starsText;
        }


        public String getAverageRating() {
            return averageRating;
        }

        public String getReviewsCount() {
            return reviewsCount;
        }

        public String getPrice() {
            return price;
        }



    public HotelPage clickImage() {
        image.click();
        return new HotelPage();
    }



}


