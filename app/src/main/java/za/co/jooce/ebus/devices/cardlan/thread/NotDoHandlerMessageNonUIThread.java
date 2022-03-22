package za.co.jooce.ebus.devices.cardlan.thread;

/**
 * Threads that do not need to process handler messages. Just override the doRun method.
 * {@link DefaultBaseNonUIThread#doRun()},
 * Created by cardlan on 18-6-23.
 */

public class NotDoHandlerMessageNonUIThread extends DefaultBaseNonUIThread {

    @Override
    public void doHandlerMsg(Object handlerEntity) {

    }

    @Override
    public void doRun() {

    }
}
