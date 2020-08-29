package HerdManager;

import java.util.Random;

/**
 * This class uses your Gate class to fill the corral with snails. We have supplied you will the
 * code necessary to execute as an app. You must fill in the missing logic below.
 */
public class FillTheCorral extends Gate {

  /** Select a predictable seed for the RandomNumber generator. */
  public static final int sRANDOM_SEED = 1234;

  /** The maximum number of Gate objects. */
  private static final int sMAX_GATES = 4;

  // TODO -- Fill your code in here

  public static void main(String[] args) {
    final Random randomNumber = new Random(sRANDOM_SEED);
    final FillTheCorral mFillTheCorral = new FillTheCorral();
    final Gate[] corral = new Gate[sMAX_GATES];
    for (int i = 0; i < corral.length; i++) corral[i] = new Gate();

    do {
      // Randomly set the direction of each gate's swing in
      // the corral array.
      mFillTheCorral.setCorralGates(corral, randomNumber);
    } while (!mFillTheCorral.anyCorralAvailable(corral));

    // Corral all the snails.
    mFillTheCorral.corralSnails(corral, randomNumber);
  }

  // sets random directions for each gate
  public void setCorralGates(Gate[] gate, Random selectDirection) {
    for (Gate ignored : gate) {
      setSwing(selectDirection.nextInt(3) - 1);
    }
  }

  // checks if there is at least one IN open gate
  public boolean anyCorralAvailable(Gate[] corral) {
    for (Gate ignored : corral) {
      if (getSwingDirection() == IN) {
        return true;
      }
    }
    return false;
  }

  // methods finds number of iterations to corral all snails
  public int corralSnails(Gate[] corral, Random rand) {
    // variable to track number of snails
    int totalNumSnails = 5;
    // variable to track number of iterations
    int counter = 0;
    // loop for iterations which terminates where all snails are in a corral
    while (totalNumSnails > 0) {
      // picks a random corral

      // picks a random number of snails from the pasture
      int currentCorral = rand.nextInt(corral.length);
      int numSnails = rand.nextInt(totalNumSnails) + 1;
      // updates the total number of snails
      totalNumSnails = totalNumSnails - corral[currentCorral].thru(numSnails);
      // prints out the state
      System.out.print(numSnails + " are trying to move through corral " + currentCorral + "\n");
      // increments the counter
      counter++;
    }
    return counter;
  }
}
