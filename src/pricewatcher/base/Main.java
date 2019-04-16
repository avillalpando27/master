/**
 * CS 3331 -- Advanced Object Oriented Programming
 * HW 02
 * Main.java
 * By: Angel Villalpando
 * Instructor: Yoonsik Cheon
 * Last Modified: March 6, 2019
 */

package pricewatcher.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Desktop;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.*;


/**
 * A dialog for tracking the price of an item.
 *
 * @author Yoonsik Cheon
 */
@SuppressWarnings("serial")
public class Main extends JFrame {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_SIZE = new Dimension(400, 300);

    /** Special panel to display the watched item. */
    private ItemView itemView;


    /** Message bar to display various messages. */
    private JLabel msgBar = new JLabel(" ");

    /** Create a new dialog. */
    public Main() {
        this(DEFAULT_SIZE);
    }

    /** Create a new dialog of the given screen dimension. */
    public Main(Dimension dim) {
        super("Price Watcher");
        setSize(dim);

        configureUI();
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        //setResizable(false);
        showMessage("Welcome to Price Watcher!");
    }

    /** Callback to be invoked when the refresh button is clicked.
     * Find the current price of the watched item and display it
     * along with a percentage price change. */
    private void refreshButtonClicked(ActionEvent event) {

        PriceFinder refreshedPrice = new PriceFinder(); // generates a new price to set as a temp item's new price
        ItemView tempItem = new ItemView();
        tempItem.testItem.setPrice(refreshedPrice.returnNewPrice());
        configureUI();  // essentially pushes the new item information to the panel

        showMessage("Item price updated! ");
    }

    /** Callback to be invoked when the view-page icon is clicked.
     * Launch a (default) web browser by supplying the URL of
     * the item. */
    private void viewPageClicked(ActionEvent event) {

        Item tempItem = new Item();
        String itemURL = tempItem.getURL();
        Desktop dk = Desktop.getDesktop();
        try{
            dk.browse(new java.net.URI(itemURL));
        }catch(IOException | URISyntaxException e){
            System.out.println("The URL on file is invalid.");
        }

        showMessage("Visiting Item Web Page");

    }

    /** Configure UI. */
    private void configureUI() {

        setLayout(new BorderLayout());
        JPanel control = makeControlPanel();
        control.setBorder(BorderFactory.createEmptyBorder(10,16,0,16));
        add(control, BorderLayout.NORTH);
        JPanel board = new JPanel();
        board.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,16,0,16),
                BorderFactory.createLineBorder(Color.CYAN)));
        board.setLayout(new GridLayout(1,1));
        itemView = new ItemView();
        // itemView.setClickListener(this::viewPageClicked);
        board.add(itemView);
        add(board, BorderLayout.CENTER);
        msgBar.setBorder(BorderFactory.createEmptyBorder(10,16,10,0));
        add(msgBar, BorderLayout.SOUTH);
    }

    /** Create a control panel consisting of a refresh button. */
    private JPanel makeControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JButton checkButton = new JButton(new ImageIcon(imageMaker("checkprice.png")));
        JButton viewLink = new JButton("View Item");
        checkButton.setFocusPainted(false);
        viewLink.setFocusPainted(false);
        checkButton.addActionListener(this::refreshButtonClicked);
        viewLink.addActionListener(this::viewPageClicked);
        panel.add(viewLink);
        panel.add(checkButton);
        return panel;
    }

    /** Show briefly the given string in the message bar. */
    private void showMessage(String msg) {
        msgBar.setText(msg);
        new Thread(() -> {
            try {
                Thread.sleep(3 * 1000); // 3 seconds
            } catch (InterruptedException e) {
            }
            if (msg.equals(msgBar.getText())) {
                SwingUtilities.invokeLater(() -> msgBar.setText(" "));
            }
        }).start();
    }

    public static void main(String[] args) {
        new Main();
    }

    public BufferedImage imageMaker(String file){
        try{
            return ImageIO.read(new File("image/" + file));

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
