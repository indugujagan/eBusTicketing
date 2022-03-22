package za.co.jooce.ebus.devices.cardlan.thread;

import android.os.Message;

/**
 * Default abstract thread, added default message{@link #SF_ADD_MSG}
 * Created by cardlan on 18-6-20.
 */

public abstract class DefaultBaseNonUIThread<T> extends BaseNonUIThread<T> {

    private static final int SF_ADD_MSG = 101;

    /**
     * Send the default message. The default message is{@link #SF_ADD_MSG}
     *
     * @param consumeEntity Consumer entities
     * @param baseThread
     */
    public void addMessage(T consumeEntity, DefaultBaseNonUIThread<T> baseThread) {
        addMessage(consumeEntity, baseThread, SF_ADD_MSG);
    }

    /**
     * add message;
     * Calls in multiple threads are not supported because the message is
     * sent by the thread calling the method, not by the native thread.
     *
     * @param consumeEntity Consumer entities
     * @param msgWhat  what this message is about.
     */
    public void addMessage(T consumeEntity, int msgWhat) {
        addMessage(consumeEntity, this, msgWhat);
    }

    @Override
    public void doHandlerMsg(Message msg) {
        switch (msg.what) {
            case SF_ADD_MSG:
                //
                T handlerEntity = (T) msg.obj;
                if (handlerEntity != null) {
                    doHandlerMsg(handlerEntity);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Handles messages sent in the handler that are of generic type and not null.
     * @param handlerEntity
     */
    public abstract void doHandlerMsg(T handlerEntity);

}

