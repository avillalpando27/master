package pricewatcher.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

    private static String itemName;
    private static String itemURL;
    private static float itemInitialPrice;
    private static float itemCurrentPrice;



    public static void setItemDetails(String name, String uRL, float price){
        itemName = name;
        itemURL = uRL;
        itemInitialPrice = price;
    }
    public static String returnDate(){

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        return formatter.format(date);

    }

    public static String getName(){
        return itemName;
    }

    public static String getURL(){
        return itemURL;
    }

    public static float getInitialPrice(){
        return itemInitialPrice;
    }

    public static float getCurrentPrice(){
        PriceFinder randomPrice = new PriceFinder();
        itemCurrentPrice = randomPrice.returnNewPrice();
        return itemCurrentPrice;
    }
    /*public static Date getDateAdded(){
        return dateAdded;
    }*/

    public static float getChange(){

        float priceChange;

        priceChange = ((itemInitialPrice - itemCurrentPrice)/itemInitialPrice) * 100;

        return priceChange * -1;

        }

}
