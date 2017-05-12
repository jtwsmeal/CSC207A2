package fishtank;

import java.awt.Color;

/** A fish that grows whenever another fish collides with it. */ 
public class GrowingFish extends Fish {

  /**
   * Constructs a new GrowingFish.
   */
  protected GrowingFish(FishTank tank, int coordinateOne, int coordinateTwo) {
    super(tank, "><=>", coordinateOne, coordinateTwo);
    this.setColour(Color.green);
  }
  
  /** 
   * Adds an extra "=" to the Fish's appearance. 
   */
  protected void changeAppearance() {
    // Ensures that the GrowingFish doesn't get too long! 
    if (this.getAppearance().length() == 30) {
      return; 
    } 
    if (this.getAppearance() == this.getForwardAppearance()) {
      // Adds an extra "=" to the Fish's appearance.
      this.setForwardAppearance(this.getAppearance().substring(0, 
          this.getAppearance().length() - 1) + "=>"); 
      this.setReverseAppearance(reverseAppearance(this.getForwardAppearance()));
      this.setAppearance(this.getForwardAppearance());
    } else { 
      // Adds an extra "=" to the Fish's appearance.
      this.setReverseAppearance(this.getAppearance().substring(0, 
          this.getAppearance().length() - 2) + "=><");
      this.setForwardAppearance(reverseAppearance(this.getReverseAppearance()));
      this.setAppearance(this.getReverseAppearance());
    }
  }
}

