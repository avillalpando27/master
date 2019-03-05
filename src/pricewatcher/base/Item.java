package pricewatcher.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

    private static String itemName;
    private static String itemURL;
    private static double itemPrice;
    //private static Date dateAdded = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    public static void setItemDetails(String name, String uRL, double price){
        itemName = name;
        itemURL = uRL;
        itemPrice = price;
    }

    public static String getName(){
        return itemName;
    }

    public static String getURL(){
        return itemURL;
    }

    public static double getPrice(){
        return itemPrice;
    }

    /*public static Date getDateAdded(){
        return dateAdded;
    }*/

    public static double getChange(){

        double priceChange;
        PriceFinder randomPrice = new PriceFinder();
        double newPrice = randomPrice.returnNewPrice();

        priceChange = ((itemPrice - newPrice)/itemPrice) * 100;

        return priceChange * -1;

        }

}
