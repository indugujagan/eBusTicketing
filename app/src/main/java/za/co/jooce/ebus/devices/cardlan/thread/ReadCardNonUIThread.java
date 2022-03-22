package za.co.jooce.ebus.devices.cardlan.thread;

/**
 * Card read threads
 *
 * Created by cardlan on 18-6-23.
 */

public class ReadCardNonUIThread extends NotDoHandlerMessageNonUIThread {

    private Runnable mTarget;

    public ReadCardNonUIThread(Runnable target) {
        this.mTarget = target;
    }

    @Override
    public void doRun() {
        this.mTarget.run();
    }

}
