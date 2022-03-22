package za.co.jooce.ebus.util;

public class WtsUtils {

    public static byte getEsnCheck(byte[] esn) {
        byte crc = 0;
        for (byte b : esn) {
            crc ^= b;
        }
        return crc;
    }
}
