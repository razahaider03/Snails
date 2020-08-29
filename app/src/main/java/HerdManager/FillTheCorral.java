package HerdManager;

import java.util.Random;

/**
 * This class uses your Gate class to fill the corral with snails. We have supplied you will the
 * code necessary to execute as an app. You must fill in the missing logic below.
 */
public class FillTheCorral extends Gate {

    /**
     * Select a predictable seed for the RandomNumber generator.
     */
    public final static int sRANDOM_SEED = 1234;

    /**
     * The maximum number of Gate objects.
     */
    private final static int sMAX_GATES = 4;


    // TODO -- Fill your code in here

    public static
    void main ( String[] args ) {
        final Random randomNumber =
                new Random(sRANDOM_SEED);
        final FillTheCorral mFillTheCorral =
                new FillTheCorral();
        final Gate[] corral =
                new Gate[sMAX_GATES];
        for (int i = 0; i < corral.length; i++)
            corral[i] = new Gate();

        do {
            // Randomly set the direction of each gate's swing in
            // the corral array.
            mFillTheCorral.setCorralGates(corral,
                    randomNumber);
        } while (!mFillTheCorral.anyCorralAvailable(corral));

        // Corral all the snails.
        mFillTheCorral.corralSnails(corral, randomNumber);
    }

    public void setCorralGates(Gate[] gate, Random selectDirection) {
        for (Gate ignored : gate) {

            Gate.setSwing(selectDirection.nextInt(1) - 1);
        }
    }
    public boolean anyCorralAvailable(Gate[] corral) {
        for ( Gate ignored :corral) {

            if (Gate.getSwingDirection() == Gate.IN) return true;
        }
        return false;
    }
    public void corralSnails(Gate [] corral, Random rand) {
        int snails = 5;
        System.out.println("Initial gate setup");
        int trying = 0;
        do {
            int randNum =rand.nextInt(corral.length)+1;
            int s = rand.nextInt(snails)+1;
            Gate gate = corral[randNum];
            snails -= gate.thru(s);
            System.out.println(snails+ "are trying to move through corral "+ randNum);
            trying ++;
        }while (snails != 0);
        System.out.println("It took "+ trying+ " attempts to corral all of the snails");

    }

}

