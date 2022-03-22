package za.co.jooce.ebus.model.card;

public class UseHistoryArea {

    private byte[] bytes;



    public UseHistoryArea(byte[] cardData) {
        bytes = new byte[85];
        System.arraycopy(cardData, 84, bytes, 0, 51);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
