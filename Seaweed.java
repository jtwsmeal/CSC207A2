package fishtank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Seaweed.
 */
public class Seaweed extends FloatingObject {

  /** The number of weed segments. */
  private int numSegments;

  /** Indicates whether the bottom segment is leaning right. */
  private boolean leanRight;  

  /**
   * Constructs a new seaweed item at the specified cursor location (x,y), l segments tall.
   *
   * @param height the number of segments this seaweed is tall.
   */
  public Seaweed(FishTank tank, int height, int coordinateOne, int coordinateTwo) {
    this.numSegments = height;
    this.setColour(Color.green.darker().darker());
    this.setLocation(coordinateOne, coordinateTwo);
    this.setTank(tank);
  }



  /**
   * Draws this fish tank item. Looks lovely waving in the current, doesn't it?
   *
   * @param graphics the graphics context in which to draw this item.
   */
  public void draw(Graphics graphics) {
    for (int i = 0; i < numSegments; i++) {
      /* Draw a "/" seaweed segment: even 
       * numbered and leaning to the right.
       */ 
      if (((i % 2 == 0) && (leanRight)) || ((i % 2 == 1) && !(leanRight))) {
        drawString(graphics, "/", this.getCoordinateOne(), (this.getCoordinateTwo() - i));
      } else { 
        drawString(graphics, "\\", this.getCoordinateOne(), (this.getCoordinateTwo() - i));
      }
    }
  }


  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void move() {
    // Causes the seaweed to wave.
    leanRight = !leanRight;
  }
}
