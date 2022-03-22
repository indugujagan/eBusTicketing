package za.co.jooce.ebus.model.card;

public class ManufacturingBlock {

    private byte[] bytes;
    private byte[] esn;

    public ManufacturingBlock(byte[] bytes) {
        this.bytes = new byte[48];
        System.arraycopy(bytes, 0, this.bytes, 0, 48);


        esn = new byte[4];
        System.arraycopy(bytes, 0, esn, 0, 4);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getEsn() {
        return esn;
    }

    public void setEsn(byte[] esn) {
        this.esn = esn;
    }
}
