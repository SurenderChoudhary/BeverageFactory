package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.sun.deploy.util.StringUtils;

public class Main {

    public static void main(String[] args) throws Exception {

        MenuItem menuItem = new MenuItem();
        Ingredients ingredients = new Ingredients();
        Orders orders = new Orders(menuItem,ingredients);

        List<String> ordersList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replace("[","").replace("]","");

        //String s = "Chai, -sugar, -milk, -water";
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(s);
        while (m.find()) {
           ordersList.add(m.group(1));
        }

        float totalprice = orders.getOrdersPrice(ordersList);

        System.out.println(totalprice);
    }
}
