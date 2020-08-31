package HerdManager;

import java.util.Random;

/**
 * This class uses your Gate class to fill the corral with snails. We have supplied you will the
 * code necessary to execute as an app. You must fill in the missing logic below.
 */
public
class FillTheCorral extends Gate {

    /**
     * Select a predictable seed for the RandomNumber generator.
     */
    public static final int sRANDOM_SEED=1234;

    /**
     * The maximum number of Gate objects.
     */
    private static final int sMAX_GATES=4;

    // TODO -- Fill your code in here

    public static
    void main ( String[] args ) {
        Random randomNumber=new Random(sRANDOM_SEED);
        final FillTheCorral mFillTheCorral=new FillTheCorral();
        final Gate[] corral=new Gate[sMAX_GATES];
        for ( int i=0; i<corral.length; i++ ) {
            corral[i]=new Gate();
        }
        do {
            // Randomly set the direction of each gate's swing in
            // the corral array.
            mFillTheCorral.setCorralGates(corral , randomNumber);
        } while (mFillTheCorral.anyCorralAvailable(corral));

        // Corral all the snails.
        mFillTheCorral.corralSnails(corral , randomNumber);
    }


    public
    void setCorralGates ( Gate[] gate , Random selectDirection ) {
        System.out.println("Initial gate setup:");

        for ( int i=0; i<gate.length; i++ ) {
            int j=selectDirection.nextInt(3)-1;
            gate[i].setSwing(j);

            System.out.println("Gate " +i+" : "+gate[i].toString());
        }
    }

    public
    boolean anyCorralAvailable ( Gate[] corral ) {
        for ( int i=0; i<corral.length; i++ ) {
            if (corral[i].getSwingDirection() == IN) {
                return true;
            }
        }
        return false;
    }

    public
    int corralSnails ( Gate[] corral , Random rand ) {
        int pasture = 5;
        int attemptCount = 0;
        int randomGate;
        int randomNumber;
        //System.out.println("noe corral");
//        do {
//            // Randomly set the direction of each gate's swing in
//            // the corral array.
//            setCorralGates(corral , rand);
//        } while (!anyCorralAvailable(corral));

        do {
            randomGate=rand.nextInt(corral.length);
            // System.out.println(randomGate);
            // System.out.println(corral[randomGate].toString());
            randomNumber=rand.nextInt(pasture)+1;
            // System.out.println(randomNumber);
            System.out.println(randomNumber+" are trying to move through corral "+randomGate);
            pasture+=corral[randomGate].thru(randomNumber);
            // System.out.println("thru "+corral[randomGate].thru(randomNumber));
            attemptCount++;
        } while (pasture != 0);
        System.out.println("It took "+attemptCount+" attempts to corral all of the snails.");
        return attemptCount;
    }
}
