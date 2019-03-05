package pricewatcher.base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.text.DecimalFormat;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel {
    
	/** Interface to notify a click on the view page icon. */
	public interface ClickListener {
		
		/** Callback to be invoked when the view page icon is clicked. */
		void clicked();
	}
	
	/** Directory for image files: src/image in Eclipse. */
	private final static String IMAGE_DIR = "/image/";
        
	/** View-page clicking listener. */
    private ClickListener listener;
    
    /** Create a new instance. */
    public ItemView() {
    	setPreferredSize(new Dimension(100, 160));
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
            		listener.clicked();
            	}
            }
        });
    }
        
    /** Set the view-page click listener. */
    public void setClickListener(ClickListener listener) {
    	this.listener = listener;
    }
    
    /** Overridden here to display the details of the item. */
    @Override
	public void paintComponent(Graphics g) {
        Item testItem = new Item();
        testItem.setItemDetails("Five Ten Hiangle Men's Climbing Shoes", "https://amzn.to/2HlSGMH", 164.99f);

        super.paintComponent(g);
        DecimalFormat df = new DecimalFormat("###.##");
        //Dimension dim = getSize();

        Color red = Color.RED;
        Color green = Color.GREEN;

        int x = 100, y = 20;
        // g.drawImage(getImage("view.png"), x, y)
        g.drawString("Here are the item details! ", x, y);
        x = 10;
        y += 30;
        g.drawString("           Name: \t" + testItem.getName(), x, y);
        y += 20;
        g.drawString("              URL: \t" + testItem.getURL(), x, y);
        y += 20;
        g.drawString("    Start Price: \t$" + testItem.getInitialPrice(), x, y);
        y += 20;
        g.drawString("Current Price: \t$"+ df.format(testItem.getCurrentPrice()), x, y);
        y += 20;
        g.drawString("Price Change: \t% " + df.format(testItem.getChange()), x, y);
        y += 20;
        g.drawString("  Date Added: \t" + testItem.returnDate(),  x, y);
    }
    
    /** Return true if the given screen coordinate is inside the viewPage icon. */
    private boolean isViewPageClicked(int x, int y) {
    	//--
    	//-- WRITE YOUR CODE HERE
    	//--
    	return new Rectangle(20, 20, 30, 20).contains(x,  y);
    }
        
    /** Return the image stored in the given file. */
    public Image getImage(String file) {
        try {
        	URL url = new URL(getClass().getResource(IMAGE_DIR), file);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
