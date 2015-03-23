package com.scightravel.model.entities;

public class PricePerPerson {

    private int price;
    private String currency;

    public PricePerPerson(int price, String currency){
        this.price = price;
        this.currency = currency;
    }

    /**
     * @return The price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }


}