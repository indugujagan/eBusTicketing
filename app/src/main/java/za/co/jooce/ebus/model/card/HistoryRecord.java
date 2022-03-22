package za.co.jooce.ebus.model.card;

public class HistoryRecord {

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    private byte [] bytes;
    private byte [] history2;
    private byte [] history3;

    public byte[] getHistory4() {
        return history4;
    }

    public void setHistory4(byte[] history4) {
        this.history4 = history4;
    }

    public byte[] getHistory5() {
        return history5;
    }

    public void setHistory5(byte[] history5) {
        this.history5 = history5;
    }

    private byte [] history4;
    private byte [] history5;

    private byte tokenFormat;
    private byte[] previousHistoryPointer;
    private byte[] SignOnDateTime;
    private byte[] driverGrossCash;
    private byte[] driverNetCash;
    private byte[] Etm;
    private byte[] serialNumber;
    private byte[] driverHistory;



    public byte getTokenFormat() {
        return tokenFormat;
    }

    public void setTokenFormat(byte tokenFormat) {
        this.tokenFormat = tokenFormat;
    }


    public HistoryRecord(byte[] cardData) {//rename to historyrecord a
        bytes = new byte[17];
        System.arraycopy(cardData, 68, bytes, 0, 17);

        history2 = new byte[17];
       System.arraycopy(cardData,85, history2, 0,17);

       history3 = new byte[17];
        System.arraycopy(cardData,102, history3,0,17);

        history4 = new byte[17];
        System.arraycopy(cardData,119,history4,0,17);

        history5 = new byte[17];
        System.arraycopy(cardData,136,history5, 0, 17);

    }

    /*
    duplicate to historyrecordB
   public HistoryRecordB(byte[] cardData) {//rename to historyrecord a
        bytes = new byte[17];
        System.arraycopy(cardData, 232, bytes, 0, 17);

        history2 = new byte[17];
        System.arraycopy(cardData,XXX, history2, 0,17);

        history3 = new byte[17];
        System.arraycopy(cardData,150, history3,0,17);

        history4 = new byte[17];
        System.arraycopy(cardData,167,history4,0,17);

        history5 = new byte[17];
        System.arraycopy(cardData,184,history5, 0, 17);

    }
    * */




    //driverNumber = new byte[3];
        //System.arraycopy(bytes, 3, driverNumber, 0, 3);

    public byte[] getHistory2() {
        return history2;
    }

    public void setHistory2(byte[] history2) {
        this.history2 = history2;
    }

    public byte[] getHistory3() {
        return history3;
    }

    public void setHistory3(byte[] history3) {
        this.history3 = history3;
    }

    public byte[] getPreviousHistoryPointer() {
        return previousHistoryPointer;
    }

    public void setPreviousHistoryPointer(byte[] previousHistoryPointer) {
        this.previousHistoryPointer = previousHistoryPointer;
    }

    public byte[] getSignOnDateTime() {
        return SignOnDateTime;
    }

    public void setSignOnDateTime(byte[] signOnDateTime) {
        SignOnDateTime = signOnDateTime;
    }

    public byte[] getDriverGrossCash() {
        return driverGrossCash;
    }

    public void setDriverGrossCash(byte[] driverGrossCash) {
        this.driverGrossCash = driverGrossCash;
    }

    public byte[] getDriverNetCash() {
        return driverNetCash;
    }

    public void setDriverNetCash(byte[] driverNetCash) {
        this.driverNetCash = driverNetCash;
    }

    public byte[] getEtm() {
        return Etm;
    }

    public void setEtm(byte[] etm) {
        Etm = etm;
    }

    public byte[] getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(byte[] serialNumber) {
        this.serialNumber = serialNumber;
    }

    public byte[] getDriverHistory() {
        return driverHistory;
    }

    public void setDriverHistory(byte[] driverHistory) {
        this.driverHistory = driverHistory;
    }


}
