package HerdManager;

import java.util.Random;

/**
 * This class uses your Gate class to manage a herd of snails. We have supplied you will the code
 * necessary to execute as an app. You must fill in the missing logic below.
 */
public
class HerdManager extends Gate {
    /** Reference to the output. */
    // private OutputInterface mOut;

    public static final int sRANDOM_SEED=1234;
    public static final int HERD=24;
    /** Maximum number of iterations to run the simulation. */
    private static final int MAX_ITERATIONS=10;
    /** The input Gate object. */
    private final Gate mEastGate;
    /** The output Gate object. */
    private final Gate mWestGate;

    /** Constructor initializes the fields. */
    public
    HerdManager ( Gate westGate , Gate eastGate ) {

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

        HerdManager mHerdManager=new HerdManager(westGate , eastGate);

        mHerdManager.simulateHerd(randomNumber);
    }

    // TODO -- Fill your code in here

    public
    void simulateHerd ( Random rand ) {
        int snailQty = HERD;
        int pasture = 0;
        System.out.println(
                "There are currently "
                        + snailQty
                        +" snails in the pen and "
                        + pasture
                        +" snails in the pasture");

        for ( int i=0; i<MAX_ITERATIONS; i++ ) {
            if (pasture == 0) {
                mEastGate.open(Gate.OUT);   // Opened gate for snails exiting from pen.
                snailQty+=mEastGate.thru(rand.nextInt(snailQty)+1);
            } else if (snailQty == 0) {
                mWestGate.open(Gate.IN);    // Opened Gate for entry of snails in pen.
                snailQty+=mWestGate.thru(rand.nextInt(pasture)+1);
            } else {
                if (rand.nextBoolean()) {
                    mEastGate.open(Gate.OUT);   // Opened gate for snails exiting from pen.
                    snailQty+=(mEastGate.thru(rand.nextInt(snailQty)+1));
                } else {
                    mWestGate.open(Gate.IN);    // Opened Gate for entry of snails in pen
                    snailQty+=mWestGate.thru(rand.nextInt(pasture)+1);
                }
            }
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

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      