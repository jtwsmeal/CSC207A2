package fishtank;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public abstract class FloatingObject {
  
  /** The font used to draw instances of this class. */
  private static final Font FONT = new Font("Monospaced", Font.PLAIN, 10);
  
  /** My colour. Ah, the vagaries of British vs. US spelling. */
  private Color colour;

  /** This FloatingObject's horizontal coordinate. */
  private int coordinateOne;
  
  /** This FloatingObject's vertical coordinate. */
  private int coordinateTwo;
  
  /** This FloatingObject's tank. */ 
  private FishTank tank;
  
  /**
   * Set this item's location.  Note that (0, 0) is at the top left of the screen.
   * 
   * @param locationOne the FloatingObject's horizontal coordinate.
   * @param locationTwo the FloatingObject's vertical coordinate.
   */
  protected void setLocation(int locationOne, int locationTwo) {
    // set coordinateOne to locationOne.
    coordinateOne = locationOne;
    // set coordinateTwo to locationTwo.
    coordinateTwo = locationTwo;
  }
  
  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param g the graphics context in which to draw the string.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location.
   * @param y the y-coordinate of the string's cursor location.
   */
  protected void drawString(Graphics graphics, String appearance, int coordinateOne, 
      int coordinateTwo) {
    graphics.setColor(colour);
    graphics.setFont(FONT);
    FontMetrics fm = graphics.getFontMetrics(FONT);
    graphics.drawString(appearance, coordinateOne * fm.charWidth('W'), 
        coordinateTwo * fm.getAscent());
  }
  
  /** Returns the horizontal coordinate of this FloatingObject. 
   * 
   * @return the horizontal coordinate of this FloatingObject.
   */
  protected int getCoordinateOne() { 
    return this.coordinateOne;
  }
  
  /** Sets the horizontal coordinate of this FloatingObject. 
   * 
   * @param coordinateOne the horizontal coordinate of this FloatingObject.
   */
  protected void setCoordinateOne(int coordinateOne) { 
    this.coordinateOne = coordinateOne;
  }
  
  /** Returns the vertical coordinate of this FloatingObject. 
   * 
   * @return the vertical coordinate of this FloatingObject.
   */
  protected int getCoordinateTwo() { 
    return this.coordinateTwo;
  }
  
  /** Sets the vertical coordinate of this FloatingObject. 
   * 
   * @param coordinateTwo the vertical coordinate of this FloatingObject.
   */
  protected void setCoordinateTwo(int coordinateTwo) { 
    this.coordinateTwo = coordinateTwo;
  }
  
  /** Returns the colour of this FloatingObject. 
   * 
   * @return the colour of this FloatingObject.
   */
  protected Color getColour() { 
    return this.colour;
  }
  
  /** Sets the colour of this FloatingObject. 
   * 
   * @param colour the new colour of this FloatingObject.
   */
  protected void setColour(Color colour) { 
    this.colour = colour;
  }
  
  /** Returns the FishTank of this FloatingObject. 
   * 
   * @return the FishTank of this FloatingObject.
   */
  protected FishTank getTank() { 
    return this.tank;
  }
  
  /** Sets the FishTank of this FloatingObject. 
   * 
   * @param tank the FishTank of this FloatingObject.
   */
  protected void setTank(FishTank tank) { 
    this.tank = tank;
  }
  
  /**
   * Draws this fish tank item.
   *
   * @param graphics the graphics context in which to draw this item.
   */
  protected abstract void draw(Graphics graphics);
  
  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  protected abstract void move();
}
