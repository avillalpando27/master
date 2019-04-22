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
    /**
     *
     * @param list Uses JList as param for rendering
     * @param value Uses Item param for rendering
     * @param index Uses index param for
     * @param isSelected Uses isSelected for rendering
     * @param cellHasFocus Uses cellHasFocus for rendering
     * @return Component The newly configured cell rendering
     */

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
