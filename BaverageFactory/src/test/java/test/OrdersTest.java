package test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.company.Ingredients;
import com.company.MenuItem;
import com.company.Orders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrdersTest {

    private MenuItem menuItem;
    private Ingredients ingredients;
    private Orders orders;
    private List<MenuItem> menuItems;

    @Before
    public void setup() {
        menuItem = mock(MenuItem.class);
        ingredients = mock(Ingredients.class);
        orders = new Orders(menuItem,ingredients);

    }

    @Test
    public void testValidInputs() throws Exception {

        //1. "Chai, -sugar"  - 3.5
        MenuItem menuItemlocal = new MenuItem();
        menuItems = menuItemlocal.getMenuItemList();
        when(menuItem.getMenuItemList()).thenReturn(menuItems);
        when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
        String order = "Chai, -sugar"; //3.5
        List<String> ordersList = new ArrayList<>();
        ordersList.add(order);
        float price = orders.getOrdersPrice(ordersList);
        assertThat(price, is(3.5F));

        //2. "Chai, -sugar, -milk" 2.5
        menuItems = menuItemlocal.getMenuItemList();
        when(menuItem.getMenuItemList()).thenReturn(menuItems);
        when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
        ordersList.clear();
        order = "Chai, -sugar, -milk";
        ordersList.add(order);
        price = orders.getOrdersPrice(ordersList);
        assertThat(price, is(2.5F));

        //3. "Chai" 4
        menuItems = menuItemlocal.getMenuItemList();
        when(menuItem.getMenuItemList()).thenReturn(menuItems);
        when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
        ordersList.clear();
        order = "Chai";
        ordersList.add(order);
        price = orders.getOrdersPrice(ordersList);
        assertThat(price, is(4F));

        //4. ["Chai, -sugar", "Chai", "Coffee, -milk"] // Chai and Tea are menu items 3.5 + 4+ 4 = 11.5
        menuItems = menuItemlocal.getMenuItemList();
        when(menuItem.getMenuItemList()).thenReturn(menuItems);
        when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
        ordersList.clear();
        order = "Chai, -sugar";
        ordersList.add(order);
        order = "Chai";
        ordersList.add(order);
        order = "Coffee, -milk";
        ordersList.add(order);
        price = orders.getOrdersPrice(ordersList);
        assertThat(price, is(11.5F));

        menuItems = menuItemlocal.getMenuItemList();
        when(menuItem.getMenuItemList()).thenReturn(menuItems);
        when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
        ordersList.clear();
        order = "Mojito, -water, -mint";
        ordersList.add(order);
        price = orders.getOrdersPrice(ordersList);
        assertThat(price, is(6.5F));
    }

    @Test
    public void Invalid_MenuItem(){
        try {
            MenuItem menuItemlocal = new MenuItem();
            menuItems = menuItemlocal.getMenuItemList();
            when(menuItem.getMenuItemList()).thenReturn(menuItems);
            when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
            String order = "ElaichiChai, -sugar"; //3.5
            List<String> ordersList = new ArrayList<>();
            ordersList.add(order);
            orders.getOrdersPrice(ordersList);

        }
        catch (Exception ex){
            assertThat(ex.getMessage(), is("Invalid Menu Item"));
        }
    }

    @Test
    public void Ingredient_Can_Only_Be_Removed(){
        try {
            MenuItem menuItemlocal = new MenuItem();
            menuItems = menuItemlocal.getMenuItemList();
            when(menuItem.getMenuItemList()).thenReturn(menuItems);
            when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
            String order = "Chai, sugar"; //3.5
            List<String> ordersList = new ArrayList<>();
            ordersList.add(order);
            orders.getOrdersPrice(ordersList);

        }
        catch (Exception ex){
            assertThat(ex.getMessage(), is("Ingredient can only be removed"));
        }
    }

    @Test
    public void removeallIngredients(){
        try {
            MenuItem menuItemlocal = new MenuItem();
            menuItems = menuItemlocal.getMenuItemList();
            when(menuItem.getMenuItemList()).thenReturn(menuItems);
            when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
            String order = "Chai, -sugar, -water, -milk"; //3.5
            List<String> ordersList = new ArrayList<>();
            ordersList.add(order);
            orders.getOrdersPrice(ordersList);

        }
        catch (Exception ex){
            assertThat(ex.getMessage(), is("Cannot remove all the ingridients"));
        }
    }

    @Test
    public void removeInvalidIngredients(){
        try {
            MenuItem menuItemlocal = new MenuItem();
            menuItems = menuItemlocal.getMenuItemList();
            when(menuItem.getMenuItemList()).thenReturn(menuItems);
            when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
            String order = "Chai, -sugar1"; //3.5
            List<String> ordersList = new ArrayList<>();
            ordersList.add(order);
            orders.getOrdersPrice(ordersList);

        }
        catch (Exception ex){
            assertThat(ex.getMessage(), is("Invalid Igridients"));
        }
    }

    @Test
    public void removeIngredients_that_does_not_belon_to_MenuItem(){
        try {
            MenuItem menuItemlocal = new MenuItem();
            menuItems = menuItemlocal.getMenuItemList();
            when(menuItem.getMenuItemList()).thenReturn(menuItems);
            when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
            String order = "Chai, -soda"; //3.5
            List<String> ordersList = new ArrayList<>();
            ordersList.add(order);
            orders.getOrdersPrice(ordersList);

        }
        catch (Exception ex){
            assertThat(ex.getMessage(), is("Ingredient Doesnt exist in MenuItem"));
        }
    }

    @Test
    public void emptyOrder(){
        try {
            MenuItem menuItemlocal = new MenuItem();
            menuItems = menuItemlocal.getMenuItemList();
            when(menuItem.getMenuItemList()).thenReturn(menuItems);
            when(ingredients.getBeverageIngredientsValue()).thenReturn(getBeverageIngredientsValue());
            List<String> ordersList = new ArrayList<>();
            orders.getOrdersPrice(ordersList);

        }
        catch (Exception ex){
            assertThat(ex.getMessage(), is("No order for pricing"));
        }
    }

    @Test
    public void OrderWithEmptyItem(){
        try {
            String order = ""; //3.5
            List<String> ordersList = new ArrayList<>();
            ordersList.add(order);
            orders.getOrdersPrice(ordersList);
        }
        catch (Exception ex){
            assertThat(ex.getMessage(), is("Menu Item is required"));
        }
    }



    private EnumMap<Ingredients.BeverageIngredients,Float> getBeverageIngredientsValue(){
        EnumMap<Ingredients.BeverageIngredients, Float> beverageIngredientsPriceEnumMap = new
                EnumMap<Ingredients.BeverageIngredients, Float>(Ingredients.BeverageIngredients.class);

        beverageIngredientsPriceEnumMap.put(Ingredients.BeverageIngredients.MILK,1f);
        beverageIngredientsPriceEnumMap.put(Ingredients.BeverageIngredients.SUGAR,0.5f);
        beverageIngredientsPriceEnumMap.put(Ingredients.BeverageIngredients.SODA,0.5f);
        beverageIngredientsPriceEnumMap.put(Ingredients.BeverageIngredients.MINT,0.5f);
        beverageIngredientsPriceEnumMap.put(Ingredients.BeverageIngredients.WATER,0.5f);
        return beverageIngredientsPriceEnumMap;

    }
}