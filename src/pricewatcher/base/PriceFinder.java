package pricewatcher.base;

import java.util.Random;

public class PriceFinder{

    public static float newPrice;

    public static float returnNewPrice(){

        Random rando = new Random();

        return 100 + rando.nextFloat() * (300 - 100);

    }
}
