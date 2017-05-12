package fishtank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A fish.
 */
public class Fish extends FloatingObject {
  
  /** How this fish appears on the screen. */
  private String appearance;
  
  /** How this fish appears when swimming to the right. */
  private String forwardAppearance;
  
  /** How this fish appears when swimming to the left. */
  private String reverseAppearance;

  /** Indicates whether this fish is moving right. */
  private boolean goingRight;  

  /**
   * Constructs a new fish.
   */
  protected Fish(FishTank tank, int locationOne, int locationTwo) {
    // Decides the colour of this Fish.  
    double colourChooser = Math.random();
    if (colourChooser < 0.2) { 
      this.setColour(Color.cyan.darker());
    } else if (colourChooser < 0.4) {
      this.setColour(Color.orange.darker());
    } else if (colourChooser < 0.6) {
      this.setColour(Color.red);
    } else if (colourChooser < 0.8) {
      this.setColour(Color.green);
    } else {
      this.setColour(Color.magenta);
    }
    // Default appearance of this Fish.
    forwardAppearance = "><>";
    // Initializes this Fish's reverseAppearance.
    reverseAppearance = reverseAppearance(forwardAppearance);
    // Sets the initial appearance of this Fish to forwardAppearance.
    appearance = forwardAppearance;
    // This fish starts out swimming to the right.
    goingRight = true;
    // Sets the Fish's location. 
    this.setTank(tank);
    this.setLocation(locationOne, locationTwo);
  }
  
  /**
   * Constructs a new fish, with a different appearance.
   * 
   * @param appearance how the fish appears.
   * @param coordinateOne the Fish's horizontal coordinate.
   * @param coordinateTwo the Fish's vertical coordinate.
   */
  protected Fish(FishTank tank, String appearance, int coordinateOne, int coordinateTwo) {
    // Calls the other constructor.
    this(tank, coordinateOne, coordinateTwo);
    // Sets the initial appearance of this fish to the appearance specified.
    forwardAppearance = appearance;
    // Initializes this Fish's reverseAppearance.
    reverseAppearance = reverseAppearance(forwardAppearance);
    // Sets the initial appearance of this Fish to forwardAppearance.
    this.appearance = forwardAppearance;
  }

  /**
   * Causes this fish to blow a bubble.
   */
  protected void blowBubble() {
    Bubble bubble = new Bubble(this.getTank(), this.getCoordinateOne(), 
        this.getCoordinateTwo() - 1);
    // Adds the newly created Bubble to the frame.
    this.getTank().addBubble(bubble);
  }

  /**
   * Initialize this fish's reverse appearance.
   * 
   * @param appearance the fish's original appearance.
   * @return the fish's reverse appearance.
   */
  protected String reverseAppearance(String appearance) {
    String reverse = "";
    for (int i = appearance.length() - 1; i >= 0; i--) {
      switch (appearance.charAt(i)) {
        case ')':
          reverse += '(';
          break;
        case '(':
          reverse += ')';
          break;
        case '>':
          reverse += '<';
          break;
        case '<':
          reverse += '>';
          break;
        case '}':
          reverse += '{';
          break;
        case '{':
          reverse += '}';
          break;
        case '[':
          reverse += ']';
          break;
        case ']':
          reverse += '[';
          break;
        default:
          reverse += appearance.charAt(i);
          break;
      }
    }
    return reverse;
  }

  /**
   * Turns this fish around, causing it to reverse direction.
   */
  private void turnAround() {
    // Modifies the value of the boolean goingRight.
    goingRight = !goingRight;
    if (appearance == forwardAppearance) { 
      appearance = reverseAppearance;
    } else {
      appearance = forwardAppearance;
    }
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
   * Causes this item to take its turn in the fish-tank simulation.
   */
  protected void move() {
    // Move one spot to the right or left.
    if ((this.getCoordinateOne() > 0) && (this.getCoordinateOne() < 106)) { 
      // The fish moves normally if it is not at the edge of the window. 
      if (goingRight) {
        this.setCoordinateOne(this.getCoordinateOne() + 1);
      } else {
        this.setCoordinateOne(this.getCoordinateOne() - 1);
      }
    /* If the fish is at the end of the window, it turns around and moves a 
     * unit away from the edge of the window.
     */ 
    } else { 
      turnAround();
      if (this.getCoordinateOne() == 0) {
        this.setCoordinateOne(this.getCoordinateOne() + 1);
      } else if (this.getCoordinateOne() == 106) {
        this.setCoordinateOne(this.getCoordinateOne() - 1);
      }
    }

    // Figure out whether I blow a bubble.
    double movement = Math.random();
    // If it's less than 10%, blow a bubble.
    if (movement < 0.1) {
      blowBubble();
    }

    // Figure out whether I turn around.
    movement = Math.random();
    // If it's less than 10%, turn around.
    if (movement < 0.1) {
      turnAround();
    }

    // Figure out whether to move up or down, or neither.
    movement = Math.random();
    // If it's less than 10%, move up or down.
    if ((movement < 0.1) && (this.getCoordinateTwo() < 48)) {
      // Move down
      this.setCoordinateTwo(this.getCoordinateTwo() + 1);
    } else if ((movement < 0.2) && (this.getCoordinateTwo() > 0)) {
      // Move up
      this.setCoordinateTwo(this.getCoordinateTwo() - 1);
    }    
  }
  
  /** 
   * Returns the appearance of this Fish. 
   * @return appearance of this Fish.
   */
  protected String getAppearance() { 
    return appearance;
  }
  
  /** 
   * Sets the appearance of this Fish. 
   * @param appearance the appearance of this Fish.
   */
  protected void setAppearance(String appearance) { 
    this.appearance = appearance;
  }
  
  /** 
   * Returns the forward appearance of this Fish. 
   * @return the forward appearance of this Fish.
   */
  protected String getForwardAppearance() { 
    return forwardAppearance;
  }
  
  /** 
   * Sets the forward appearance of this Fish. 
   * @param forwardAppearance the forward appearance of this Fish.
   */
  protected void setForwardAppearance(String forwardAppearance) { 
    this.forwardAppearance = forwardAppearance;
  }
  
  /** 
   * Returns the reverse appearance of this Fish. 
   * @return the reverse appearance of this Fish.
   */
  protected String getReverseAppearance() { 
    return reverseAppearance;
  }
  
  /** 
   * Sets the reverse appearance of this Fish. 
   * @param reverseAppearance the reverse appearance of this Fish.
   */
  protected void setReverseAppearance(String reverseAppearance) { 
    this.reverseAppearance = reverseAppearance;
  }
}
