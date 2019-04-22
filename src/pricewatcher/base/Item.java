package pricewatcher.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @author Angel Villalpando
 *  @version 1.1
 *  @since 1.0
 * */

public class Item {

    public static String itemName;
    public static String itemURL;
    public static float itemInitialPrice;
    public static float itemCurrentPrice;
    //private static URL testURL = new URL("https://amzn.to/2HlSGMH");


    /**
     * Sets the item details manually.
     * @param name Name of the item being added to Price Watcher
     * @param uRL URL of the item being added to Price Watcher
     * @param price Price of the item being added to Price Watcher
     *  */

    public Item(){

    }
    public Item(String name, String uRL, float price){
        itemName = name;
        itemURL = uRL;
        itemInitialPrice = price;
    }

    public static void setItemDetails(String name, String uRL, float price){
        itemName = name;
        itemURL = uRL;
        itemInitialPrice = price;
    }


    /**
     * Returns the date the item was added to the Price Watcher app.
     * @return Date The item's date.
     * */
    public static String returnDate(){

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        return formatter.format(date);
    }

    /**
     * Updates the item price manually.
     * @param price The price being set for the item.
     *
     * */

    public static void setPrice(float price){
        itemCurrentPrice = price;
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

    public static String itemToString(){
        String details = "Name:\t" + getName() + "\n" + "URL:\t" + getURL() + "\n" + "Initial Price:\t" + getInitialPrice() + "\n" + "Current Price:\t" + getCurrentPrice() + "\n" + "Date Added:\t" + "04/20/2019";
        return details;
    }

}
