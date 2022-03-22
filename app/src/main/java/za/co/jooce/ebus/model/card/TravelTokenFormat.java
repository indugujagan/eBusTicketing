package za.co.jooce.ebus.model.card;

public class TravelTokenFormat {

    private byte[] bytes;

    private byte cardFormat;
    private byte[] nextTokenPointer;
    private byte specialUserType;
    private byte[] specialUserValue;

    public TravelTokenFormat(byte[] cardData) {
        bytes = new byte[6];
        System.arraycopy(cardData, 22, bytes, 0, 6);
    }


    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte getCardFormat() {
        return cardFormat;
    }

    public void setCardFormat(byte cardFormat) {
        this.cardFormat = cardFormat;
    }

    public byte[] getNextTokenPointer() {
        return nextTokenPointer;
    }

    public void setNextTokenPointer(byte[] nextTokenPointer) {
        this.nextTokenPointer = nextTokenPointer;
    }

    public byte getSpecialUserType() {
        return specialUserType;
    }

    public void setSpecialUserType(byte specialUserType) {
        this.specialUserType = specialUserType;
    }

    public byte[] getSpecialUserValue() {
        return specialUserValue;
    }

    public void setSpecialUserValue(byte[] specialUserValue) {
        this.specialUserValue = specialUserValue;
    }
}
