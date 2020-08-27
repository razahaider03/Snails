// package mooc.vandy.java4android.gate.logic;
package HerdManager;


// import android.util.Log;

import java.util.Random;

/* import mooc.vandy.java4android.gate.ui.OutputInterface; */

/**
 * This class uses your Gate class to manage a herd of snails. We have supplied you will the code
 * necessary to execute as an app. You must fill in the missing logic below.
 */
public
class HerdManager extends Gate {
    /**
     * Reference to the output.
     */
    // private OutputInterface mOut;

    public static final int sRANDOM_SEED=1234;
    public static final int HERD=24;
    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS=10;
    /**
     * The input Gate object.
     */
    private final Gate mEastGate;
    /**
     * The output Gate object.
     */
    private final Gate mWestGate;

    /**
     * Constructor initializes the fields.
     */
    public
    HerdManager ( Gate westGate , Gate eastGate ) {
        // mOut = out;

        mWestGate=westGate;
        mWestGate.open(Gate.IN);

        mEastGate=eastGate;
        mEastGate.open(Gate.OUT);
    }

    public static
    void main ( String[] args ) {
        Random randomNumber=new Random(sRANDOM_SEED);
        Gate westGate=new Gate();
        Gate eastGate=new Gate();

      HerdManager mHerdManager=new HerdManager(westGate,eastGate);
        mHerdManager.simulateHerd(randomNumber);
    }

    // TODO -- Fill your code in here

    public
    void simulateHerd ( Random rand ) {
        int snailQty=HERD;
        int pasture=0;
        int randomSnails;
        int rngate;
        rngate=rand.nextInt(2);
        System.out.println(
                "There are currently "
                        +snailQty
                        +" snails in the pen and "
                        +pasture
                        +" snails in the pasture");

        for ( int i=0; i<MAX_ITERATIONS; i++ ) {
            if (pasture == 0) {
                randomSnails=rand.nextInt(snailQty)+1;
                snailQty+=mEastGate.thru(randomSnails);
                System.out.println(snailQty);
            } else if (snailQty == 0) {
                randomSnails=rand.nextInt(pasture)+1;
                snailQty+=mWestGate.thru(randomSnails);
            } else if (rngate == 0) {
                randomSnails=rand.nextInt(pasture)+1;
                snailQty+=mEastGate.thru(randomSnails);
            } else {
                randomSnails=rand.nextInt(snailQty)+1;
            snailQty+=mWestGate.thru(randomSnails); }

            pasture=HERD-snailQty;
            System.out.println(
                    "There are currently "
                            +snailQty
                            +" snails in the pen and "
                            +pasture
                            +" snails in the pasture");
        }
    }

}
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      