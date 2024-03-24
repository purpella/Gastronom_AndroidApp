package com.practicum.tambovgurman.model;

public class Course {

    int id, category;
    String img, title, place, rating, check, color, text, mapUrl, ratingUrl;

    public Course(int id, String img, String title, String place, String rating, String check, String color, String text, String ratingUrl, String mapUrl, int category) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.place = place;
        this.rating = rating;
        this.check = check;
        this.color = color;
        this.text = text;
        this.mapUrl = mapUrl;
        this.ratingUrl = ratingUrl;
        this.category = category;

    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getRatingUrl() {
        return ratingUrl;
    }

    public void setRatingUrl(String ratingUrl) {
        this.ratingUrl = ratingUrl;
    }

    public int getCategory() {
        return category;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
