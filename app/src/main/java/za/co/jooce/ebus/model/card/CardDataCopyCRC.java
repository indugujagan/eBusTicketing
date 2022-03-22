package za.co.jooce.ebus.model.card;

import java.util.Arrays;

public class CardDataCopyCRC {

    private byte[] bytes;

    public CardDataCopyCRC(byte[] cardData) {
        bytes = new byte[2];
        System.arraycopy(cardData, 0, bytes, 0, 2);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "CardDataCopyCRC{" +
                "bytes=" + Arrays.toString(bytes) +
                '}';
    }
}
