package za.co.jooce.ebus.model.card;

import java.util.Arrays;

public class IssuerArea {

    private byte[] bytes;
    private byte[] machineOfIssueID;
    private byte[] printedCardSerialNumber;
    private byte optionsByte;
    private byte issueAreaLRC;

    public IssuerArea(byte[] cardData) {
        bytes = new byte[8];
        System.arraycopy(cardData, 2, bytes, 0, 8);

        machineOfIssueID = new byte[2];
        System.arraycopy(bytes, 0, machineOfIssueID, 0, 2);

        printedCardSerialNumber = new byte[4];
        System.arraycopy(bytes, 2, printedCardSerialNumber, 0, 4);

        optionsByte = bytes[6];

        issueAreaLRC = bytes[7];
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getMachineOfIssueID() {
        return machineOfIssueID;
    }

    public void setMachineOfIssueID(byte[] machineOfIssueID) {
        this.machineOfIssueID = machineOfIssueID;
    }

    public byte[] getPrintedCardSerialNumber() {
        return printedCardSerialNumber;
    }

    public void setPrintedCardSerialNumber(byte[] printedCardSerialNumber) {
        this.printedCardSerialNumber = printedCardSerialNumber;
    }

    /**
     * FF = driver card
     * 81 - 86 - see doc
     *
     * @return
     */
    public byte getOptionsByte() {
        return optionsByte;
    }

    public void setOptionsByte(byte optionsByte) {
        this.optionsByte = optionsByte;
    }

    /**
     * FF = driver card
     * 81 - 86 - see doc
     *
     * @return
     */
    public String getOptions() {
        if (optionsByte == ((byte) 0xFF)) {
            return "DRIVER";
        }

        return "OTHER";
    }

    public byte getIssueAreaLRC() {
        return issueAreaLRC;
    }

    public void setIssueAreaLRC(byte issueAreaLRC) {
        this.issueAreaLRC = issueAreaLRC;
    }

    @Override
    public String toString() {
        return "IssuerArea{" +
                "bytes=" + Arrays.toString(bytes) +
                ", machineOfIssueID=" + Arrays.toString(machineOfIssueID) +
                ", printedCardSerialNumber=" + Arrays.toString(printedCardSerialNumber) +
                ", optionsByte=" + optionsByte +
                ", issueAreaLRC=" + issueAreaLRC +
                '}';
    }
}
