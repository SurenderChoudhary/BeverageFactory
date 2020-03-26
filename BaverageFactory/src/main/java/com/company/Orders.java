package com.company;

import java.util.EnumMap;
import java.util.List;

public class Orders {

    private MenuItem menuItem;
    private Ingredients ingredients;

    public Orders(MenuItem menuItem, Ingredients ingredients) {
        this.menuItem = menuItem;
        this.ingredients = ingredients;
    }

    public float getOrdersPrice(List<String> ordersList) throws Exception {
        String validationMessage = validateOrder(ordersList);
        if (!validationMessage.isEmpty()){
            throw new Exception(validationMessage);
        }
        EnumMap<Ingredients.BeverageIngredients,Float> ingredientsFloatEnumMap = ingredients.getBeverageIngredientsValue();
        float sum = 0.0F;
        for (String orders: ordersList) {
            sum = sum + eachorderPrice(orders,ingredientsFloatEnumMap);
        }
        return sum;
    }

    private float eachorderPrice(String eachOrder,EnumMap<Ingredients.BeverageIngredients,Float> ingredientsFloatEnumMap){
        float priceofeachorder = 0.0f;
        String[] eachingredient = eachOrder.split(",");
        if (eachingredient.length == 1){
            return menuItem.getMenuItemList().stream().filter(x -> x.menuitem.equalsIgnoreCase(eachingredient[0])).
                    findFirst().get().menuItemPrice;
        }

        priceofeachorder = menuItem.getMenuItemList().stream().filter(x -> x.menuitem.equalsIgnoreCase(eachingredient[0])).
                findFirst().get().menuItemPrice;
       /// Ingredients.BeverageIngredients.valueOf("SUGAR")

        for(int i = 1 ;i<eachingredient.length;i++){
            String eachiIngredient = eachingredient[i].replace("-", "").toUpperCase().trim();
            priceofeachorder = priceofeachorder - ingredientsFloatEnumMap.get(Ingredients.BeverageIngredients.valueOf(eachiIngredient));
        }
        return priceofeachorder;
    }

    private String validateOrder(List<String> ordersList){
        String validationmessage = "";
        if(ordersList.isEmpty()){
            validationmessage = "No order for pricing";
            return validationmessage;
        }
        for (String orders: ordersList) {
            if(orders.trim().toString().isEmpty()){
                validationmessage = "Menu Item is required";
                return validationmessage;
            }
            String[] eachingredient = orders.split(",");

            if(!menuItem.getMenuItemList().stream().filter(x -> x.menuitem.equalsIgnoreCase(eachingredient[0])).findFirst().isPresent()){
                validationmessage = "Invalid Menu Item";
                return validationmessage;
            }
            MenuItem orderedMenuItem = menuItem.getMenuItemList().stream().filter(x -> x.menuitem.equalsIgnoreCase(eachingredient[0])).findFirst().get();

            for(int i = 1 ;i<eachingredient.length;i++){

                if(eachingredient[i].indexOf('-')==-1){
                    validationmessage = "Ingredient can only be removed";
                    return validationmessage;
                }
                String eachiIngredient = eachingredient[i].replace("-", "").toUpperCase().trim();


                if(! checkingrdients(eachiIngredient)){
                    validationmessage = "Invalid Igridients";
                    return validationmessage;
                }

                if(!orderedMenuItem.ingredientList.contains(Ingredients.BeverageIngredients.valueOf(eachiIngredient))){
                    validationmessage = "Ingredient Doesnt exist in MenuItem";
                    return validationmessage;
                }

                orderedMenuItem.ingredientList.remove(Ingredients.BeverageIngredients.valueOf(eachiIngredient));

            }

            if(!checkmenuIngredients(orderedMenuItem.ingredientList) ){
                validationmessage = "Cannot remove all the ingridients";
                return validationmessage;
            }



        }

        return validationmessage;
    }

    private boolean checkingrdients(String eachiIngredient){
        boolean returnvalue = true;
        try {
            Ingredients.BeverageIngredients.valueOf(eachiIngredient);
        }
        catch (Exception ex){
            returnvalue = false;
        }
        return returnvalue;
    }

    private boolean checkmenuIngredients(List<Ingredients.BeverageIngredients> beverageIngredients){
        boolean returnvalue = true;
        try {
            if(beverageIngredients.isEmpty()) {
             return false;
            }

            if(beverageIngredients.size() > 1){
                return true;
            }

            if(beverageIngredients.size() == 1){
                if(beverageIngredients.contains(Ingredients.BeverageIngredients.COFFEE) ||
                   beverageIngredients.contains(Ingredients.BeverageIngredients.TEA) ||
                   beverageIngredients.contains(Ingredients.BeverageIngredients.BANANA) ||
                   beverageIngredients.contains(Ingredients.BeverageIngredients.STRAWBERRIES) ||
                   beverageIngredients.contains(Ingredients.BeverageIngredients.LEMON) ) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        catch (Exception ex){
            returnvalue = false;
        }
        return returnvalue;
    }


}
