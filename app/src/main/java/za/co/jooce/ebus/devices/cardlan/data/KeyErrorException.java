package za.co.jooce.ebus.devices.cardlan.data;

/**
 * Created by cardlan on 18-6-9.
 */

public class KeyErrorException extends Exception {
    public KeyErrorException() {
        super("Key create error!");
    }

    public KeyErrorException(String message) {
        super(message);
    }
}
