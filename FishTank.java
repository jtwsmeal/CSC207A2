package fishtank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * A fish tank simulation.
 */
public class FishTank {

  /** The width of a character. */
  protected static final int CHAR_WIDTH = 6;
  
  /** The height of a character. */
  protected static final int CHAR_HEIGHT = 10;
  
  protected FishFrame frame;
  
  /** (int)(640/6) columns, (int)(480/10) rows. */
  private ArrayList<FloatingObject> myLittleFishies = new ArrayList<FloatingObject>();
  
  /** 
   * Constructs a new FishTank. 
   */
  public FishTank() { 
    // Initializes this ArrayList of FloatingObjects. 
    myLittleFishies.add(new Fish(this, 23, 18)); 
    myLittleFishies.add(new Fish(this, 6, 12));
    myLittleFishies.add(new Fish(this, 17, 4));
    myLittleFishies.add(new Fish(this, 15, 28));
    myLittleFishies.add(new Fish(this, 23, 21));
    myLittleFishies.add(new Fish(this, 16, 35));
    myLittleFishies.add(new Fish(this, 17, 35));
    myLittleFishies.add(new Fish(this, 16, 22));
    myLittleFishies.add(new Fish(this, 23, 27));
    myLittleFishies.add(new Fish(this, 5, 12));
    myLittleFishies.add(new Fish(this, "><MEHUNGRY>", 10, 20));
    myLittleFishies.add(new Seaweed(this, 6, 24, 33));
    myLittleFishies.add(new Seaweed(this, 7, 32, 25));
    myLittleFishies.add(new Seaweed(this, 5, 13, 25));
    myLittleFishies.add(new Seaweed(this, 6, 65, 19));
    myLittleFishies.add(new Seaweed(this, 7, 79, 11));
    myLittleFishies.add(new GrowingFish(this, 10, 15));
    myLittleFishies.add(new Bubble(this, 25, 20));
  }

  /**
   * Start the fishies.
   * 
   * @param args the command line arguments.
   * @throws InterruptedException if the Thread.sleep(300) command does not execute.
   */
  public static void main(String[] args) throws InterruptedException {

    // The window in which the fish swim.
    FishFrame frame = new FishFrame();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }   
    });
    
    // Show it all!
    frame.setSize(640, 480);
    frame.setLocation(10, 10);
    frame.setVisible(true);

    // Every .3 seconds, tell each item in the fishtank to take
    // a turn.
    while (true) {

      // Tell the fishtank to redraw itself.
      frame.repaint();

      // Wait .3 seconds before redoing the queue.
      Thread.sleep(300);
    }
  }

  /** 
   * Adds a new Bubble to the Frame.
   * 
   * @param newBubble the Bubble to be added to this Frame. 
   */
  protected void addBubble(Bubble newBubble) { 
    this.myLittleFishies.add(newBubble);
  }
  
  /** Returns the ArrayList myLittleFishies. 
   * 
   * @return myLittleFishies.
   */
  protected ArrayList<FloatingObject> getMyLittleFishies() { 
    return this.myLittleFishies;
  }
}