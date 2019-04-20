/**
 * CS 3331 -- Advanced Object Oriented Programming
 * HW 02
 * Main.java
 * By: Angel Villalpando
 * Instructor: Yoonsik Cheon
 * Last Modified: March 6, 2019
 */

package pricewatcher.base;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.awt.event.*;


/**
 * A dialog for tracking the price of an item.
 *
 * @author Yoonsik Cheon
 */
@SuppressWarnings("serial")
public class Main extends JFrame {
    final private static String FILE_PATH = "/Users/angelvillalpando/Desktop/2-DGraphics/src/pricewatcher/base/image/";

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
        String itemURL = "https://www.google.com";
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
        //board.setBorder(BorderFactory.createCompoundBorder(
                //BorderFactory.createEmptyBorder(10,16,0,16),
               // BorderFactory.createLineBorder(Color.CYAN)));
        board.setLayout(new GridLayout(1,1));
        board.add(listMaker());
        itemView = new ItemView();
        // itemView.setClickListener(this::viewPageClicked);
        //board.add(itemView);
        add(board, BorderLayout.CENTER);
        msgBar.setBorder(BorderFactory.createEmptyBorder(10,16,10,0));
        add(msgBar, BorderLayout.SOUTH);
    }

    /** Create a control panel consisting of a refresh button. */
    private JPanel makeControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu =

//Build the first menu.
        menu = new JMenu("App");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);


        JButton refreshButton = new JButton(new ImageIcon(iconMaker("refreshREAL.png")));
        refreshButton.setToolTipText("Check Item Price");
        //checkButton.setPreferredSize(new Dimension(25,25));
        JButton viewLink = new JButton(new ImageIcon(iconMaker("visitSite.png")));
        viewLink.setToolTipText("Visit Item Website");
        JButton deleteItem = new JButton(new ImageIcon(iconMaker("delete.png")));
        deleteItem.setToolTipText("Remove Item");
        JButton addItem = buttonMaker("additem.png");
        addItem.setToolTipText("Add Item to Price Watcher");
        JButton editItem = buttonMaker("edititem.png");
        editItem.setToolTipText("Edit Item Details");


        refreshButton.setFocusPainted(false);
        viewLink.setFocusPainted(false);
        deleteItem.setFocusPainted(false);

        refreshButton.addActionListener(this::refreshButtonClicked);
        viewLink.addActionListener(this::viewPageClicked);
        panel.add(refreshButton);
        panel.add(viewLink);
        panel.add(deleteItem);
        panel.add(addItem);
        panel.add(editItem);

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

    public static BufferedImage iconMaker(String s){
        BufferedImage buttonIcon;
        try{
            buttonIcon = ImageIO.read(new File(FILE_PATH + s));
        }catch(IOException e){
            buttonIcon = null;
            System.out.println("BooHOO");
        }
        return buttonIcon;
    }

    public static JMenuBar createMenuBar() {

        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rdmi;
        JCheckBoxMenuItem cbmi;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the File Menu.
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("New Project...",
                new ImageIcon("images/newproject.png"));
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Project");
        menu.add(menuItem);

        menuItem = new JMenuItem("New File...",
                new ImageIcon("images/newfile.png"));
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbmi = new JCheckBoxMenuItem("A check box menu item");
        cbmi.setMnemonic(KeyEvent.VK_C);
        menu.add(cbmi);

        cbmi = new JCheckBoxMenuItem("Another one");
        cbmi.setMnemonic(KeyEvent.VK_H);
        menu.add(cbmi);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rdmi = new JRadioButtonMenuItem("Radio button menu item");
        rdmi.setSelected(true);
        rdmi.setMnemonic(KeyEvent.VK_R);
        group.add(rdmi);
        menu.add(rdmi);

        rdmi = new JRadioButtonMenuItem("Another radio button");
        rdmi.setMnemonic(KeyEvent.VK_O);
        group.add(rdmi);
        menu.add(rdmi);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("Menu item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another menu item");
        submenu.add(menuItem);
        menu.add(submenu);

        //Build Edit menu in the menu bar.
        menu = new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_E);
        menu.getAccessibleContext().setAccessibleDescription(
                "Edit Menu");
        menuBar.add(menu);
        return menuBar;

    }

    public static JList listMaker() {
        Item testItem = new Item();
        testItem.setItemDetails("Shoes", "https://www.google.com", 165.00f);
        Item testItem1 = new Item();
        testItem1.setItemDetails("Clothes", "https://www.ebay.com", 48.00f);
        String[] deets = {testItem.itemToString(), testItem1.itemToString()};
        System.out.println(testItem.itemToString());

        JList itemList = new JList(deets);

        return itemList;

    }

    public static JButton buttonMaker(String s){
        final JButton button;
        button = new JButton(new ImageIcon(iconMaker(s)));
        button.setFocusPainted(false);
        return button;
    }

}
