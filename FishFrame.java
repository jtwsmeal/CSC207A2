package fishtank;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Displays the fish tank.
 */
public class FishFrame extends JFrame {

  /** My Serializable id. */
  private static final long serialVersionUID = 1409191926708912242L;
  
  /** The fishtank. */
  private FishTank myFishTank = new FishTank();

  /**
   * Paints this fish tank.
   *
   * @param graphics the graphics context to use for painting.
   */
  public void paint(Graphics graphics) {

    // Get my width and height.
    int width = getBounds().width;
    int height = getBounds().height;

    // Paint the window white.
    graphics.setColor(Color.white.brighter().brighter().brighter().brighter());
    graphics.fillRect(0, 0, width, height);
    
    for (int i = 0; i != myFishTank.getMyLittleFishies().size(); i++) { 
      FloatingObject item = myFishTank.getMyLittleFishies().get(i);
      // Moves the item.
      item.move();
      /* If the item is a GrowingFish, and it collides 
       * with an item that is not seaweed or a GrowingFish, 
       * then it grows. 
       */
      if (item instanceof GrowingFish) { 
        for (FloatingObject fish : myFishTank.getMyLittleFishies()) { 
          if ((!(fish instanceof Seaweed)) && (!(fish instanceof GrowingFish)) 
              && (fish.getCoordinateOne() == item.getCoordinateOne()) 
              && (fish.getCoordinateTwo() == item.getCoordinateTwo())) { 
            ((GrowingFish) item).changeAppearance(); 
          }
        }
      }
      // Draws the item in the frame.
      item.draw(graphics);
    }
  }
}
