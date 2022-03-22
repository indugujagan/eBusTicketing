package za.co.jooce.ebus.devices.cardlan.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import za.co.jooce.ebus.devices.cardlan.util.CardlanLog;


/**
 * Non-UI thread, not blocking main thread.
 * <p>
 * Created by cardlan on 18-6-20.
 */

public abstract class BaseNonUIThread<T> extends Thread {

    private Looper baseLooper;
    private Handler mBaseHandler;

    private boolean needInitHandler = true;

    @Override
    public void run() {
        Looper.prepare();
        synchronized (this) {
            baseLooper = Looper.myLooper();
            notifyAll();
        }
        if (needInitHandler) {
            getThreadHandler(this);
        }
        doRun();
        CardlanLog.debugOnConsole(this.getClass(), this.getName() + " Thread out");
    }

    /**
     * @return Looper
     */
    public Looper getLooper() {
        if (!isAlive()) {
            return null;
        }

        // If the thread has been started, wait until the looper has been created.
        synchronized (this) {
            while (isAlive() && baseLooper == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return baseLooper;
    }

    /**
     * GET handler
     * @param baseNonUIThread
     * @return Handler
     */
    public Handler getThreadHandler(BaseNonUIThread<T> baseNonUIThread) {
        if (mBaseHandler == null) {
            mBaseHandler = new BaseHandler(baseNonUIThread.getLooper());
        }
        return mBaseHandler;
    }

    /**
     * Send message
     *
     * @param consumeEntity
     * @param baseNonUIThread
     * @param msgWhat
     */
    public void addMessage(T consumeEntity, BaseNonUIThread<T> baseNonUIThread, int msgWhat) {
        Message message = new Message();
        message.what = msgWhat;
        message.obj = consumeEntity;
        baseNonUIThread.getThreadHandler(baseNonUIThread).sendMessage(message);
    }


    private class BaseHandler extends Handler {

        public BaseHandler(Looper looper) {

        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            doHandlerMsg(msg);
        }
    }

    /**
     * quit
     *
     * @return boolean
     */
    public boolean quit() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quit();
            return true;
        }
        return false;
    }

    /***
     * set initialize handler
     * @param needInitHandler
     */
    public void setNeedInitHandler(boolean needInitHandler) {
        this.needInitHandler = needInitHandler;
    }

    /**
     *  Just do what you need to do
     */
    public abstract void doRun();

    /***
     * deal with message
     * @param msg
     */
    public abstract void doHandlerMsg(Message msg);
}

