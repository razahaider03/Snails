// package mooc.vandy.java4android.gate.logic;
package HerdManager;

import HerdManager.Gate;

// import android.util.Log;

import java.util.Random;

/** import mooc.vandy.java4android.gate.ui.OutputInterface; */

/**
 * This class uses your Gate class to manage a herd of snails. We have supplied you will the code
 * necessary to execute as an app. You must fill in the missing logic below.
 */
public class HerdManager extends Gate {
  /** Reference to the output. */
  // private OutputInterface mOut;

  public static final int sRANDOM_SEED = 1234;

  /** The input Gate object. */
  private Gate mEastGate;

  /** The output Gate object. */
  private Gate mWestGate;

  /** Maximum number of iterations to run the simulation. */
  private static final int MAX_ITERATIONS = 10;

  public static final int HERD = 24;

  public static void main(String[] args) {
 // System.out.println(getSwingDirection());
    Random randomNumber = new Random(sRANDOM_SEED);
    Gate westGate = new Gate();
    
    Gate eastGate = new Gate();
   
    HerdManager mHerdManager = new HerdManager(westGate, eastGate);
    
    mHerdManager.simulateHerd(randomNumber);
  }

  /** Constructor initializes the fields. */
  public HerdManager(Gate westGate, Gate eastGate) {
    // mOut = out;

    mWestGate = westGate;
    mWestGate.open(Gate.IN);
//System.out.println(getSwingDirection());
    mEastGate = eastGate;
    mEastGate.open(Gate.OUT);
  //  System.out.println(getSwingDirection());
    //System.out.println(mWestGate.toString());
    //System.out.println(mEastGate.toString());
  }

  // TODO -- Fill your code in here

  public void simulateHerd(Random rand) {
    int snailQty = HERD;
    int pasture=0;
    int randomSnails;
    int rngate;
    rngate = rand.nextInt(2);
    System.out.println(
        "There are currently "
            + snailQty
            + " snails in the pen and "
            + pasture
            + " snails in the pasture");
            
    for (int i = 0; i < MAX_ITERATIONS; i++) {
    // System.out.println(snailQty);
      if (pasture == 0){
      mEastGate.open(Gate.OUT);
     System.out.println("pasture is 0 :"+getSwingDirection());
      randomSnails = rand.nextInt(snailQty)+1;
        snailQty += mEastGate.thru(randomSnails);
        // System.out.println("east out :"+getSwingDirection());
       // System.out.println(snailQty+"_"+pasture);
      } else 
         if (snailQty == 0){
         System.out.println("dir In: "+getSwingDirection());
       // System.out.println(snailQty+"_" + pasture);
        mWestGate.open(Gate.IN);
        randomSnails = rand.nextInt(pasture)+1;
        snailQty += mWestGate.thru(randomSnails);
       // System.out.println("IN= "+getSwingDirection());
      } else 
         if (rngate == 0) {
           // System.out.println(snailQty+"_"+pasture);
          System.out.println("snail less :"+getSwingDirection());
          mEastGate.open(Gate.OUT);
           randomSnails = rand.nextInt(snailQty)+1;
          snailQty += (mEastGate.thru(randomSnails));
           } else{
          // System.out.println(snailQty+"_"+pasture);
          System.out.println("pasture less :"+getSwingDirection());
           randomSnails = rand.nextInt(pasture)+1;
           mWestGate.open(Gate.IN);
          snailQty += mWestGate.thru(randomSnails);
        }
        //System.out.println("pasture= "+pasture);
           pasture = HERD - snailQty;
           System.out.println(
        "There are currently "
            + snailQty
            + " snails in the pen and "
            + pasture
            + " snails in the pasture");
        }
      }  
   
}
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      