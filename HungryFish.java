package fishtank;

/*
 ***************************************
 * This class is not required anymore! *
 ***************************************
 */ 

/**
 * A Hungry fish.
 * This class inherits from the Fish class.
 */
public class HungryFish extends Fish {

  /**
   * Constructs a new hungry fish.
   */
  public HungryFish(FishTank tank) {
    super(tank, 0, 0);
    this.setAppearance("><MEHUNGRY>");
  }
}
