package com.company;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    public static final String coffee = "Coffee";
    public static final String chai = "Chai";
    public static final String Banana_Smoothie = "BANANA Smoothie";
    public static final String Strawberry_Shake = "Strawberry Shake";
    public static final String Mojito = "Mojito";

    public String menuitem;
    public float menuItemPrice;
    public List<Ingredients.BeverageIngredients> ingredientList;


    public List<MenuItem> getMenuItemList(){
        List<MenuItem> listMenuitem = new ArrayList<>();
        listMenuitem.add(getCoffeeMenuItem());
        listMenuitem.add(getChaiMenuItem());
        listMenuitem.add(getBananaSmoothieMenuItem());
        listMenuitem.add(getStrawberryShakeMenuItem());
        listMenuitem.add(getMojitoMenuItem());
        return listMenuitem;
    }

    private MenuItem getCoffeeMenuItem(){
        MenuItem coffeemenuitem = new MenuItem();
        coffeemenuitem.menuitem = MenuItem.coffee;
        coffeemenuitem.menuItemPrice = 5f;
        coffeemenuitem.ingredientList = getCoffeeIngredient();
        return coffeemenuitem;
    }

    private MenuItem getChaiMenuItem(){
        MenuItem chaimenuitem = new MenuItem();
        chaimenuitem.menuitem = MenuItem.chai;
        chaimenuitem.menuItemPrice = 4f;
        chaimenuitem.ingredientList = getChaiIngredient();
        return chaimenuitem;
    }

    private MenuItem getBananaSmoothieMenuItem(){
        MenuItem bananaShakemenuitem = new MenuItem();
        bananaShakemenuitem.menuitem = MenuItem.Banana_Smoothie;
        bananaShakemenuitem.menuItemPrice = 6f;
        bananaShakemenuitem.ingredientList = getBananaSmoothieIngredient();
        return bananaShakemenuitem;
    }

    private MenuItem getStrawberryShakeMenuItem(){
        MenuItem strawberryShakemenuitem = new MenuItem();
        strawberryShakemenuitem.menuitem = MenuItem.Strawberry_Shake;
        strawberryShakemenuitem.menuItemPrice = 7f;
        strawberryShakemenuitem.ingredientList = getStrawBerryShakeIngredient();
        return strawberryShakemenuitem;
    }

    private MenuItem getMojitoMenuItem(){
        MenuItem mojitomenuitem = new MenuItem();
        mojitomenuitem.menuitem = MenuItem.Mojito;
        mojitomenuitem.menuItemPrice = 7.5f;
        mojitomenuitem.ingredientList = getMojitoIngredient();
        return mojitomenuitem;
    }

    private List<Ingredients.BeverageIngredients> getCoffeeIngredient(){
        List<Ingredients.BeverageIngredients> beverageIngredients = new ArrayList<>();
        beverageIngredients.add(Ingredients.BeverageIngredients.COFFEE);
        beverageIngredients.add(Ingredients.BeverageIngredients.MILK);
        beverageIngredients.add(Ingredients.BeverageIngredients.SUGAR);
        beverageIngredients.add(Ingredients.BeverageIngredients.WATER);
        return beverageIngredients;
    }

    private List<Ingredients.BeverageIngredients> getChaiIngredient(){
        List<Ingredients.BeverageIngredients> beverageIngredients = new ArrayList<>();
        beverageIngredients.add(Ingredients.BeverageIngredients.TEA);
        beverageIngredients.add(Ingredients.BeverageIngredients.MILK);
        beverageIngredients.add(Ingredients.BeverageIngredients.SUGAR);
        beverageIngredients.add(Ingredients.BeverageIngredients.WATER);
        return beverageIngredients;
    }

    private List<Ingredients.BeverageIngredients> getBananaSmoothieIngredient(){
        List<Ingredients.BeverageIngredients> beverageIngredients = new ArrayList<>();
        beverageIngredients.add(Ingredients.BeverageIngredients.BANANA);
        beverageIngredients.add(Ingredients.BeverageIngredients.MILK);
        beverageIngredients.add(Ingredients.BeverageIngredients.SUGAR);
        beverageIngredients.add(Ingredients.BeverageIngredients.WATER);
        return beverageIngredients;
    }

    private List<Ingredients.BeverageIngredients> getStrawBerryShakeIngredient(){
        List<Ingredients.BeverageIngredients> beverageIngredients = new ArrayList<>();
        beverageIngredients.add(Ingredients.BeverageIngredients.STRAWBERRIES);
        beverageIngredients.add(Ingredients.BeverageIngredients.MILK);
        beverageIngredients.add(Ingredients.BeverageIngredients.SUGAR);
        beverageIngredients.add(Ingredients.BeverageIngredients.WATER);
        return beverageIngredients;
    }

    private List<Ingredients.BeverageIngredients> getMojitoIngredient(){
        List<Ingredients.BeverageIngredients> beverageIngredients = new ArrayList<>();
        beverageIngredients.add(Ingredients.BeverageIngredients.LEMON);
        beverageIngredients.add(Ingredients.BeverageIngredients.SUGAR);
        beverageIngredients.add(Ingredients.BeverageIngredients.WATER);
        beverageIngredients.add(Ingredients.BeverageIngredients.SODA);
        beverageIngredients.add(Ingredients.BeverageIngredients.MINT);
        return beverageIngredients;
    }
}
