package fishtank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A bubble.
 */
public class Bubble extends FloatingObject {

  /** How this bubble appears on the screen. */
  private String appearance;
  
  /**
   * Constructs a new bubble with location specified by locationOne and locationTwo.
   * 
   * @param locationOne the initial horizontal coordinate of the bubble.
   * @param locationTwo the initial vertical coordinate of the bubble.
   */
  Bubble(FishTank tank, int locationOne, int locationTwo) {
    // Get a nice-looking grey for the bubble.
    this.setColour(Color.blue.darker().darker().darker());
    // Start off with . as the appearance.
    appearance = ".";
    // Set the Bubble's location as soon as it is created.
    this.setTank(tank);
    this.setLocation(locationOne, locationTwo);
  }

  /**
   * Draws this fish tank item.
   *
   * @param graphics the graphics context in which to draw this item.
   */
  protected void draw(Graphics graphics) {
    drawString(graphics, appearance, this.getCoordinateOne(), this.getCoordinateTwo());
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation, moving straight up.
   */
  void floatStraightUp() {
    // Move upwards.
	if (this.getCoordinateTwo() < -1) { 
      this.getTank().getMyLittleFishies().remove(this);
      return;
	}
    this.setCoordinateTwo(this.getCoordinateTwo() - 1);
    
    // Figure out whether to grow, if at all.
    double movement = Math.random();
    // Occasionally change a . to a o or a o to a O.
    if (movement < 0.05) {
      if (appearance.equals(".")) {
        // If the appearance is a ., change it to an o.
        appearance = "o";
      } else if (appearance.equals("o")) {
        // If the appearance is an o, change it to a O.
        appearance = "O";
      }
    }
  }
  
  /** 
   * Moves this Bubble up, up and left, or up and right. 
   */
  protected void move() {
    // Figure out direction of movement.
    double movement = Math.random();
    if (movement < 0.33) {
      this.floatStraightUp();
    } else if (movement < 0.66) {
      this.floatRightUp();
    } else {  // movement >= 0.66  
      this.floatLeftUp();
    }
  }

  /**
   * Causes this item to move up and left.
   */
  void floatLeftUp() {
    // Moves this object to the left. 
    this.setCoordinateOne(this.getCoordinateOne() - 1);
    // Moves this object up.
    floatStraightUp();
  }

  /**
   * Causes this item to move up and right..
   */
  void floatRightUp() {
    // Moves this object to the right.
    this.setCoordinateOne(this.getCoordinateOne() + 1);
    // Moves this object up.
    floatStraightUp();
  }
}
