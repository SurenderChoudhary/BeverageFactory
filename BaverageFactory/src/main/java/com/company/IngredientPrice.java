package com.company;

import java.util.Properties;


public class IngredientPrice {
    private Properties properties;

    public IngredientPrice(){
        ApplicationProperties applicationProperties = new ApplicationProperties();
        this.properties = applicationProperties.getAppProperties();
    }

    public float getSugarPrice(){
       return Float.parseFloat(properties.getProperty("SugarPrice"));
    }

    public float getMilkPrice(){
        return Float.parseFloat(properties.getProperty("MilkPrice"));
    }

    public float getSodaPrice(){
        return Float.parseFloat(properties.getProperty("SodaPrice"));
    }

    public float getMintPrice(){
        return Float.parseFloat(properties.getProperty("MintPrice"));
    }

    public float getWaterPrice(){
        return Float.parseFloat(properties.getProperty("WaterPrice"));
    }
}
