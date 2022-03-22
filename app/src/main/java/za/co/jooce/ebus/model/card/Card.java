package za.co.jooce.ebus.model.card;

import java.util.Arrays;

public class Card {

    private byte[] cardBytes;

    private ManufacturingBlock manufacturingBlock;
    private CardDataCopyCRC crc;
    private IssuerArea issuerArea;
    private CustomerCode customerCode;
    private DirectoryArea directoryArea;
    private TravelTokenArea travelTokenArea;
    private UseHistoryArea useHistoryArea;
    private CreateHistoryArea createHistoryArea;



    private HistoryRecord historyRecord;

    public Card(byte[] manufacturingBlockBytes, byte[] cardBytes) {
        this.cardBytes = cardBytes;

        this.manufacturingBlock = new ManufacturingBlock(manufacturingBlockBytes);
        this.crc = new CardDataCopyCRC(cardBytes);
        this.issuerArea  = new IssuerArea(cardBytes);
        this.customerCode = new CustomerCode(cardBytes);
        this.directoryArea = new DirectoryArea(cardBytes);
        this.travelTokenArea = new TravelTokenArea(cardBytes);
        this.historyRecord = new HistoryRecord(cardBytes);
        // UseHistoryArea
        // CreateHistoryArea
    }


    public ManufacturingBlock getManufacturingBlock() {
        return manufacturingBlock;
    }

    public void setManufacturingBlock(ManufacturingBlock manufacturingBlock) {
        this.manufacturingBlock = manufacturingBlock;
    }

    public byte[] getCardBytes() {
        return cardBytes;
    }

    public void setCardBytes(byte[] cardBytes) {
        this.cardBytes = cardBytes;
    }

    public CardDataCopyCRC getCrc() {
        if (crc == null) {
            crc = new CardDataCopyCRC(cardBytes);
        }

        return crc;
    }

    public void setCrc(byte[] crc) {
        this.crc.setBytes(crc);
    }

    public IssuerArea getIssuerArea() {
        if (issuerArea == null) {
            issuerArea = new IssuerArea(cardBytes);
        }

        return issuerArea;
    }

    public void setIssuerArea(byte[] issuerArea) {
        this.issuerArea.setBytes(issuerArea);
    }

    public CustomerCode getCustomerCode() {
        if (customerCode == null) {
            customerCode = new CustomerCode(cardBytes);
        }

        return customerCode;
    }

    public void setCustomerCode(byte[] customerCode) {
        this.customerCode.setBytes(customerCode);
    }

    public DirectoryArea getDirectoryArea() {
        if (directoryArea == null) {
            directoryArea = new DirectoryArea(cardBytes);
        }

        return directoryArea;
    }

    public void setDirectoryArea(byte[] directoryArea) {
        this.directoryArea.setBytes(directoryArea);
    }

    public TravelTokenArea getTravelTokenArea() {
        if (travelTokenArea == null) {
            travelTokenArea = new TravelTokenArea(cardBytes);
        }

        return travelTokenArea;
    }

    public void setTravelTokenArea(byte[] travelTokenArea) {
        this.travelTokenArea.setBytes(travelTokenArea);
    }

    public UseHistoryArea getUseHistoryArea() {
        if (useHistoryArea == null) {
            useHistoryArea = new UseHistoryArea(cardBytes);
        }

        return useHistoryArea;
    }

    public void setUseHistoryArea(byte[] useHistoryArea) {
        this.useHistoryArea.setBytes(useHistoryArea);
    }

    public CreateHistoryArea getCreateHistoryArea() {
        if (createHistoryArea == null) {
            createHistoryArea = new CreateHistoryArea(cardBytes);
        }

        return createHistoryArea;
    }

    public void setCreateHistoryArea(byte[] createHistoryArea) {
        this.createHistoryArea.setBytes(createHistoryArea);
    }

    public HistoryRecord getHistoryRecord() {
        if(historyRecord == null){
            historyRecord =  new HistoryRecord(cardBytes);
        }
        return historyRecord;
    }

    public void setHistoryRecord(HistoryRecord historyRecord) {
        this.historyRecord = historyRecord;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardData=" + Arrays.toString(cardBytes) +
                ", crc=" + crc +
                ", issuerArea=" + issuerArea.toString() +
                ", customerCode=" + customerCode +
                ", directoryArea=" + directoryArea +
                ", travelTokenArea=" + travelTokenArea +
                ", useHistoryArea=" + useHistoryArea +
                ", createHistoryArea=" + createHistoryArea +
                ", HistoryRecord=" + historyRecord +
                '}';
    }

    public byte[] getCardCopyOneBytes() {
        return null;
    }
}
