package za.co.jooce.ebus.devices.cardlan.secret;

import com.cardlan.twoshowinonescreen.CardLanStandardBus;

import za.co.jooce.ebus.devices.cardlan.util.CardlanLog;


public class DESTwo {


    /**
     * This method is used to encrypt the card{@link CardLanStandardBus#callDesCard(byte[], byte[])},
     * Leave it to the underlying hardware to process and get the results.
     * @param data card sn.
     * @param keyBytes encrypted card sn.
     * @return byte[]
     */
    public static byte[] encrypt(byte[] data, byte[] keyBytes) {
        try {
            return new CardLanStandardBus().callDesCard(keyBytes,data);
        } catch (Throwable e) {
            CardlanLog.debugOnConsole(DESTwo.class, new Exception(e));
            e.printStackTrace();
        }
        return null;
    }


}