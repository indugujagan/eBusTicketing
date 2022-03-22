package za.co.jooce.ebus.model.card;

public class CustomerCode {

    private byte[] bytes;

    public CustomerCode(byte[] cardData) {
        bytes = new byte[2];
        System.arraycopy(cardData, 10, bytes, 0, 2);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
