package za.co.jooce.ebus.model.card;

public class DirectoryArea {

    private byte[] bytes;

    public DirectoryArea(byte[] cardData) {
        bytes = new byte[10];
        System.arraycopy(cardData, 12, bytes, 0, 10);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte getCardFormat(){
        return bytes[0];
    }

    public byte getUseHistoryPointer(){
        return bytes[1];
    }

    public byte getCreateHistoryPointer(){
        return bytes[2];
    }

    public byte getMultiJourneyTravelTokenPointer(){
        return bytes[3];
    }

    public byte getPassTravelTokenPointer(){
        return bytes[4];
    }

    public byte getEPassTokenPointer(){
        return bytes[5];
    }

    /**
     * hex15 = driver card
     * 1 = 1C
     * @return
     */
    public byte getSpecialTokenPointer(){
        return bytes[6];
    }

    public byte[] getTransactionID(){
        byte[] transactionID = new byte[2];
        System.arraycopy(bytes, 7, transactionID, 0, 2);
        return transactionID;
    }

    public byte getDirectoryAreaLRC(){
        return bytes[9];
    }
}
