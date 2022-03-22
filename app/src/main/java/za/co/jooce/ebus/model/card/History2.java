package za.co.jooce.ebus.model.card;

public class History2 {

    private byte [] bytes;


    public History2(byte[] cardData) {
        bytes = new byte[17];
        System.arraycopy(cardData, 149, bytes, 0, 17);

    }


    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
