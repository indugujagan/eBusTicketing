package za.co.jooce.ebus.model.card;

public class CreateHistoryArea {

    private byte[] bytes;

   public CreateHistoryArea(byte[] cardData) {
        bytes = new byte[16];
        System.arraycopy(cardData, 10, bytes, 0, 16);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
