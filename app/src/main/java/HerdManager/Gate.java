// package mooc.vandy.java4android.gate.logic;
package HerdManager;
import HerdManager.Gate;

/**
 * This file defines the Gate class.
 */
public
class Gate {
    // TODO -- Fill in your code here
    public static final int OUT=-1;
    public static final int IN=1;
    public static final int CLOSED=0;
    private static int mSwing;


    public static
    int getSwingDirection () {
        return mSwing;
    }

    public static
    boolean setSwing ( int dir ) {
        Gate.mSwing=dir;
        if (Gate.mSwing == IN) return true;
        if (Gate.mSwing == OUT) return true;
        return Gate.mSwing == CLOSED;
    }

    public
    boolean open ( int x ) {
        if (x == IN || x == OUT) {
            setSwing(x);
            return true;
        } else
            return false;
    }

    public
    int thru ( int count ) {
        if (getSwingDirection() == IN) {
            return count;
        } else if (getSwingDirection() == OUT) {
            return -count;
        } else count*=0;
        return count;
    }

    public
    void close () {
        setSwing(CLOSED);
    }

    @Override
    public
    String toString () {
        if (getSwingDirection() == CLOSED) return "This gate is closed";
        else if (getSwingDirection () == IN) return "This gate is open and swings to enter the pen only";
        else if (getSwingDirection () == OUT) return "This gate is open and swings to exit the pen only";
        else return "This gate has an invalid swing direction";
    }
}

