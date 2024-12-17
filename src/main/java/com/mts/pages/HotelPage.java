package com.mts.pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HotelPage {
    private String newHotelName;
    private String starsTextNew;
    private String averageRatingNew;

    private String reviewsTextNew;
//    private String price;
  private SelenideElement hotelName =  $x("//div[@data-capla-component-boundary='b-property-web-property-page/PropertyHeaderName']//h2");
    private final SelenideElement starsElement = $("span[data-testid='rating-stars']");
    private final SelenideElement averageRating = $x("//div[@data-testid='review-score-right-component']//div[contains(text(),'Оценка')]");

    private final SelenideElement reviewsElement = $x("//div[@data-testid='review-score-right-component']//div[contains(text(), 'отзыв')]");




    public HotelPage saveHotelInfoNew() {
        newHotelName = hotelName.getText();
        System.out.println(newHotelName);
        int starCount = starsElement.findAll("span").size();
        starsTextNew = "Количество звезд: " + starCount + " из 5";
        averageRatingNew = averageRating.getText();





        reviewsTextNew = reviewsElement.getText();



        return this;
    }

    public String getHotelNameNew() {
        return newHotelName;
    }

    public String getStarsTextNew() {
        return starsTextNew;
    }


    public String getAverageRatingNew() {
        return averageRatingNew;
    }

    public String getReviewsCountNew() {
        return reviewsTextNew;
    }

}
