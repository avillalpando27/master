/**
 * CS 3331 -- Advanced Object Oriented Programming
 * HW 03
 * Main.java
 * By: Angel Villalpando / Edgar Escobedo / Jorge Quinonez
 * Instructor: Yoonsik Cheon
 * Last Modified: April 22, 2019
 */

package pricewatcher.base;

import javax.swing.*;
import java.awt.*;

public class ItemViewRenderer extends ItemView implements ListCellRenderer<Item>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,boolean cellHasFocus) {


        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }
        else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}
