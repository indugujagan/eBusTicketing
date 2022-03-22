package za.co.jooce.ebus.model.card;

public class TravelTokenArea {

    private byte[] bytes;

    private TravelTokenFormat travelTokenFormat;

    private byte tokenFormat;
    private byte[] nextTokenPointer;
    private byte[] driverNumber;
    private byte[] driverSignOnDateTime;
    private byte[] driverSignOffDateTime;
    private byte[] driverGrossCash;
    private byte[] driverNetCash;
    private byte[] driverGrossTickets;
    private byte[] driverNetTickets;
    private byte driverStatusByte;
    private byte[] grossSVCash;
    private byte[] netSVCash;
    private byte[] grossSVTickets;
    private byte[] netSVTickets;
    private byte[] driverDuty;

    public TravelTokenArea(byte[] cardData) {
        travelTokenFormat = new TravelTokenFormat(cardData);

        bytes = new byte[56];
        System.arraycopy(cardData, 28, bytes, 0, 56);

        tokenFormat = bytes[0];

        nextTokenPointer = new byte[2];
        System.arraycopy(bytes, 0, nextTokenPointer, 0, 2);

        driverNumber = new byte[3];
        System.arraycopy(bytes, 0, driverNumber, 0, 3);

        driverSignOnDateTime = new byte[3];
        System.arraycopy(bytes, 0, driverSignOnDateTime, 0, 3);

        driverSignOffDateTime = new byte[3];
        System.arraycopy(bytes, 0, driverSignOffDateTime, 0, 3);

        driverGrossCash = new byte[3];
        System.arraycopy(bytes, 0, driverGrossCash, 0, 3);

        driverNetCash = new byte[3];
        System.arraycopy(bytes, 0, driverNetCash, 0, 3);

        driverGrossTickets = new byte[2];
        System.arraycopy(bytes, 0, driverGrossTickets, 0, 2);

        driverNetTickets = new byte[2];
        System.arraycopy(bytes, 0, driverNetTickets, 0, 2);

        driverStatusByte = bytes[22];

        grossSVCash = new byte[3];
        System.arraycopy(bytes, 0, grossSVCash, 0, 3);

        netSVCash = new byte[3];
        System.arraycopy(bytes, 0, netSVCash, 0, 3);

        grossSVTickets = new byte[2];
        System.arraycopy(bytes, 0, grossSVTickets, 0, 2);

        netSVTickets = new byte[2];
        System.arraycopy(bytes, 0, netSVTickets, 0, 2);

        driverDuty = new byte[3];
        System.arraycopy(bytes, 0, driverDuty, 0, 3);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public TravelTokenFormat getTravelTokenFormat() {
        return travelTokenFormat;
    }

    public void setTravelTokenFormat(TravelTokenFormat travelTokenFormat) {
        this.travelTokenFormat = travelTokenFormat;
    }

    public byte getTokenFormat() {
        return tokenFormat;
    }

    public void setTokenFormat(byte tokenFormat) {
        this.tokenFormat = tokenFormat;
    }

    public byte[] getNextTokenPointer() {
        return nextTokenPointer;
    }

    public void setNextTokenPointer(byte[] nextTokenPointer) {
        this.nextTokenPointer = nextTokenPointer;
    }

    public byte[] getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(byte[] driverNumber) {
        this.driverNumber = driverNumber;
    }

    public byte[] getDriverSignOnDateTime() {
        return driverSignOnDateTime;
    }

    public void setDriverSignOnDateTime(byte[] driverSignOnDateTime) {
        this.driverSignOnDateTime = driverSignOnDateTime;
    }

    public byte[] getDriverSignOffDateTime() {
        return driverSignOffDateTime;
    }

    public void setDriverSignOffDateTime(byte[] driverSignOffDateTime) {
        this.driverSignOffDateTime = driverSignOffDateTime;
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

    public byte[] getDriverGrossTickets() {
        return driverGrossTickets;
    }

    public void setDriverGrossTickets(byte[] driverGrossTickets) {
        this.driverGrossTickets = driverGrossTickets;
    }

    public byte[] getDriverNetTickets() {
        return driverNetTickets;
    }

    public void setDriverNetTickets(byte[] driverNetTickets) {
        this.driverNetTickets = driverNetTickets;
    }

    public byte getDriverStatusByte() {
        return driverStatusByte;
    }

    public void setDriverStatusByte(byte driverStatusByte) {
        this.driverStatusByte = driverStatusByte;
    }

    public String getDriverStatusText() {
        if (driverStatusByte == ((byte) 0x00)) {
            return "Card Signed Off";
        } else if (driverStatusByte == ((byte) 0x01)) {
            return "Card Signed On";
        }

        return "NOT IMPLEMENTED";
    }

    public byte[] getGrossSVCash() {
        return grossSVCash;
    }

    public void setGrossSVCash(byte[] grossSVCash) {
        this.grossSVCash = grossSVCash;
    }

    public byte[] getNetSVCash() {
        return netSVCash;
    }

    public void setNetSVCash(byte[] netSVCash) {
        this.netSVCash = netSVCash;
    }

    public byte[] getGrossSVTickets() {
        return grossSVTickets;
    }

    public void setGrossSVTickets(byte[] grossSVTickets) {
        this.grossSVTickets = grossSVTickets;
    }

    public byte[] getNetSVTickets() {
        return netSVTickets;
    }

    public void setNetSVTickets(byte[] netSVTickets) {
        this.netSVTickets = netSVTickets;
    }

    public byte[] getDriverDuty() {
        return driverDuty;
    }

    public void setDriverDuty(byte[] driverDuty) {
        this.driverDuty = driverDuty;
    }

    /**
     * 28 == 1C && 29 == FF {driver card}
     * 28 - 55 == driver token
     * driver number 31 - 33
     * status byte toggle
     * x0 crc
     */
}
