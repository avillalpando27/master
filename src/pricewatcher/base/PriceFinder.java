package pricewatcher.base;

import java.util.Random;

public class PriceFinder{

    public static double newPrice;

    public static double returnNewPrice(){

        Random rando = new Random();

        newPrice = (Math.random()*(200-1)+1);

        return newPrice;

    }
}
