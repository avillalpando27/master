/**
 * CS 3331 -- Advanced Object Oriented Programming
 * HW 02
 * PriceFinder.java
 * By: Angel Villalpando
 * Instructor: Yoonsik Cheon
 * Last Modified: March 6 , 2019
 */


package pricewatcher.base;

import java.util.Random;

public class PriceFinder{

    public static float newPrice;

    public static float returnNewPrice(){

        Random rando = new Random();

        return 100 + rando.nextFloat() * (300 - 100);

    }
}
