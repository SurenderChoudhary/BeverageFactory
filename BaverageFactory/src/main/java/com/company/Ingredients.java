package com.company;

import java.util.EnumMap;

public class Ingredients {
    IngredientPrice ingredientPrice;

    public enum BeverageIngredients {
        COFFEE,
        MILK,
        SUGAR,
        SODA,
        MINT,
        WATER,
        TEA,
        BANANA,
        STRAWBERRIES,
        LEMON
    }

    public Ingredients(){
        IngredientPrice ingredientPrice = new IngredientPrice();
        this.ingredientPrice = ingredientPrice;
    }


    public EnumMap<BeverageIngredients,Float> getBeverageIngredientsValue(){
        EnumMap<BeverageIngredients, Float> beverageIngredientsPriceEnumMap = new
                EnumMap<BeverageIngredients, Float>(BeverageIngredients.class);

        beverageIngredientsPriceEnumMap.put(BeverageIngredients.MILK,ingredientPrice.getMilkPrice());
        beverageIngredientsPriceEnumMap.put(BeverageIngredients.SUGAR,ingredientPrice.getSugarPrice());
        beverageIngredientsPriceEnumMap.put(BeverageIngredients.SODA,ingredientPrice.getSodaPrice());
        beverageIngredientsPriceEnumMap.put(BeverageIngredients.MINT,ingredientPrice.getMintPrice());
        beverageIngredientsPriceEnumMap.put(BeverageIngredients.WATER,ingredientPrice.getWaterPrice());
        return beverageIngredientsPriceEnumMap;

    }

}
