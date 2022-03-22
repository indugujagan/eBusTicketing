package za.co.jooce.ebus.devices.cardlan;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.cardlan.twoshowinonescreen.CardLanStandardBus;
import com.cardlan.utils.ByteUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import za.co.jooce.ebus.dao.CardDevice;
import za.co.jooce.ebus.devices.cardlan.data.TerminalConsumeDataForSystem;
import za.co.jooce.ebus.devices.cardlan.util.CardReadWriteUtil;
import za.co.jooce.ebus.model.card.Card;

public class CardLanCardDevice implements CardDevice {

    private static final String OPEN_LED_RED = "d_26_0_1";
    private static final String CLOSE_LED_RED = "d_26_0_0";
    private static final String OPEN_LED_GREEN = "c_5_1_1";
    private static final String CLOSE_LED_GREEN = "c_5_1_0";
    private static final String PROC_PATH = "/proc/gpio_set/rp_gpio_set";

    private final CardReadWriteUtil mReadWriteUtil = new CardReadWriteUtil();
    private final TerminalConsumeDataForSystem terminal = new TerminalConsumeDataForSystem();
    private final CardLanStandardBus mCardLanDevCtrl = new CardLanStandardBus();

    public CardLanCardDevice() {

    }

    @Override
    public String scanCardESN() {
        try {
            byte[] resetBytes = mReadWriteUtil.getCardResetBytes();
            if (!ByteUtil.notNull(resetBytes)) {
                return "Cannot find card";
            }

//            String esnString = ByteUtil.readCardCopyOnebyteArrayToHexString(resetBytes);
            String esnString = "";
            return "ESN: " + esnString;
        } catch (Exception e) {
            e.printStackTrace();
            return "An error reading the card has occurred";
        }
    }

    @Override
    public String scanCardSectors() {
        try {
            byte[] resetByte = mReadWriteUtil.getCardResetBytes();

            char readSector = 0;
            char readIndex = 0;
            char one = 1;
            byte[] readKey = terminal.calculateNormalCardKey(resetByte);
            char readAreaKey = 0x0a;
            String mReadOrWriteKeyHexStr = ByteUtil.byteArrayToHexString(terminal.calculateNormalCardKey(resetByte));

            byte[] sectorBytes = mCardLanDevCtrl.callReadOneSectorDataFromCard(readSector, readIndex, one, readKey, readAreaKey);
            String sectorString = ByteUtil.byteArrayToHexString(sectorBytes);
            return "Sector: " + sectorString + "\n" + mReadOrWriteKeyHexStr + "\n" + sectorBytes.length;
        } catch (Exception e) {
            e.printStackTrace();
            return "An error reading the card has occurred \n" + e;
        }
    }

    @Override
    public String readCardCopyOne() {
        try {
            String readKey = "FFFFFFFFFFFF";
            String readAreaKey = "0a";

            byte[] manufacturingBlock = new byte[48];
            byte[] cardBytes = null;
            int cardByteArrayPosition = 0;

            // Call read for sector 0 (Manufacturing block)
            for (int readBlockIndex = 0; readBlockIndex < 3; readBlockIndex++) {
                // Call read function for device
                byte[] bytes = mReadWriteUtil.callReadJNI("0", readBlockIndex + "", readKey, readAreaKey);

                if (bytes == null) {
                    throw new Exception("Card is not present or failed to read card");
                }

                // Write read bytes[] to manufacturing block array, we read 16 bytes at a time and we store it so
                System.arraycopy(bytes, 0, manufacturingBlock, cardByteArrayPosition, 16);
                cardByteArrayPosition += 16;
            }

            if (manufacturingBlock[21] == 0x00) {
                cardBytes =readCardCopy(1);
            }else if  (manufacturingBlock[21] == 0x10) {
                //manufacturingBlock[21] == 0x01
                cardBytes = readCardCopy(5);
            }

            Card card = new Card(manufacturingBlock, cardBytes);

            StringBuilder info = new StringBuilder();
           // appendTextWithHeading(info, "Manufacturing [21]", manufacturingBlock[21]);


            appendTextWithHeading(info, "Driver Status", card.getTravelTokenArea().getDriverStatusByte());
            appendTextWithHeading(info, "Driver Status Text", card.getTravelTokenArea().getDriverStatusText());

            appendTextWithHeading(info, "Driver Type Byte", card.getIssuerArea().getOptionsByte());
            appendTextWithHeading(info, "Driver Type", card.getIssuerArea().getOptions());
            appendSpace(info);
            appendTextWithHeading(info, "ESN Bytes", card.getManufacturingBlock().getEsn());
            appendTextWithHeading(info, "ESN", ByteUtil.byteArrayToIntLowToHigh(card.getManufacturingBlock().getEsn()) + "");
            appendSpace(info);

            appendTextWithHeading(info, "Driver Token Format", card.getTravelTokenArea().getTokenFormat());
            appendTextWithHeading(info, "Driver Number Byte", card.getTravelTokenArea().getDriverNumber());
            appendSpace(info);
            appendTextWithHeading(info, "Driver Status Text", card.getTravelTokenArea().getDriverStatusText());
            appendSpace(info);
            appendTextWithHeading(info, "Driver Sign On Date Time", toDate(card.getTravelTokenArea().getDriverSignOnDateTime()));
            //  appendSpace(info);
            appendTextWithHeading(info, "Driver Sign Off Date Time", toDate(card.getTravelTokenArea().getDriverSignOffDateTime()));
            //appendSpace(info);

            appendTextWithHeading(info, "HistoryRecord", card.getHistoryRecord().getBytes());


            appendTextWithHeading(info, "History Record2", card.getHistoryRecord().getHistory2());
            appendTextWithHeading(info, "History Record3", card.getHistoryRecord().getHistory3());
            appendTextWithHeading(info, "History Record4", card.getHistoryRecord().getHistory4());
            appendTextWithHeading(info, "History Record5", card.getHistoryRecord().getHistory5());




            /*
             if readingmethod( 21 == 0)
             * {
             */

            /*
            }else if (readingmethod 21 == 1)
            {
            //historyrecordb
           appendTextWithHeading(info, "HistoryRecord", card.getHistoryRecord().getBytes());
           // appendSpace(info);
            appendTextWithHeading(info, "History Record2", card.getHistoryRecord().getHistory2());
            appendTextWithHeading(info,"History Record3", card.getHistoryRecord().getHistory3());
            appendTextWithHeading(info, "History Record4", card.getHistoryRecord().getHistory4());
            appendTextWithHeading(info, "History Record5", card.getHistoryRecord().getHistory5());

            }
             */


            return "Sector: " + "\n" + info;
        } catch (Exception e) {
            e.printStackTrace();
            return "An error reading the card has occurred \n" + e;
        }
    }

    public String HistoryRecA(byte[] manufacturingBlock) {

        try {

            byte[] cardBytes = null;


            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return "An error reading the card has occurred \n" + e;
        }
    }

    private  byte[] readCardCopy(int startSector) throws Exception {
        String readKey = "FFFFFFFFFFFF";
        String readAreaKey = "0a";
        byte[] cardBytes = new byte[192];
        int cardByteArrayPosition = 0;

        // 1 = 1 + 4 =5
        // 5 = 9 =
        for (int readSector = startSector; readSector < startSector + 4; readSector++) {
            for (int readBlockIndex = 0; readBlockIndex < 3; readBlockIndex++) {
                // Call read function for device
                byte[] bytes = mReadWriteUtil.callReadJNI(readSector + "", readBlockIndex + "", readKey, readAreaKey);
                if (bytes == null) {
                    throw new Exception("Card is not present or failed to read card");
                }
                System.arraycopy(bytes, 0, cardBytes, cardByteArrayPosition, 16);
                cardByteArrayPosition += 16;
            }
        }

        return cardBytes;
    }


    @Override
    public String signOnCard() {

        String writeSector = "2";
        String writeIndex = "3";
        String signOnHex = "01";
        String writeKey = "FFFFFFFFFFFF";
        String writeAreaKey = "0b";

        return "Sign Off Write Status: " + mReadWriteUtil.callWriteJNI(writeSector, writeIndex, signOnHex, writeAreaKey, writeKey);

        //return null;
    }

    @Override
    public String signOffCard() {
        return null;
    }

    @Override
    public String scanCardSectorsTwo() {
        return null;
    }

    private String toDate(byte[] bytes) {
        String text = toBinary(bytes);

        int day = Integer.parseInt(text.substring(0, 5), 2);
        int month = Integer.parseInt(text.substring(5, 9), 2);
        int year = Integer.parseInt(text.substring(9, 13), 2) + 2007;
        int minutes = Integer.parseInt(text.substring(13), 2);

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = day + "/" + month + "/" + year;

            Date date = formatter.parse(dateString);
            if (date == null) {
                throw new Exception("Date is null");
            }

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MINUTE, minutes);

            SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            date.setTime(cal.getTimeInMillis());
            return outputFormatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return day + " - " + month + " - " + year;
        }
    }

    private void appendSpace(StringBuilder stringBuilder) {
        stringBuilder.append("\n");
    }

    private void appendTextWithHeading(StringBuilder stringBuilder, String heading, String value) {
        stringBuilder.append(heading);
        stringBuilder.append(": ");
        stringBuilder.append(value);
        stringBuilder.append("\n");
    }

    private void appendTextWithHeading(StringBuilder stringBuilder, String heading, byte[] value) {
        appendTextWithHeading(stringBuilder, heading, ByteUtil.byteArrayToHexString(value));
    }


    private void appendTextWithByteLines(StringBuilder stringBuilder, byte[] value) {
        String str = ByteUtil.byteArrayToHexString(value);
        appendTextWithHeading(stringBuilder, "Card Data", Arrays.toString(str.split("(?<=\\G.{16})")));
    }

    private String toBinary(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for (int i = 0; i < Byte.SIZE * bytes.length; i++)
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }

    private void appendTextWithHeading(StringBuilder stringBuilder, String heading, byte value) {
        appendTextWithHeading(stringBuilder, heading, ByteUtil.byteToHexString(value));
    }

    @Override
    public String checkDeviceNFCCapable() {
        return null;
    }

    @Override
    public String playBuzzer() {
        terminal.callProc();
        return "Playing buzzer";
    }

    @Override
    public String playSounds(AssetFileDescriptor afd, Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();

            return "Playing sound";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    public String redLED() {
        callProc(OPEN_LED_RED, CLOSE_LED_RED);
        return "Red LED on.";
    }

    @Override
    public String greenLED() {
        callProc(OPEN_LED_GREEN, CLOSE_LED_GREEN);
        return "Green LED on.";
    }


    private void callProc(String openCmd, String closeCmd) {
        writeProc(PROC_PATH, openCmd.getBytes());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writeProc(PROC_PATH, closeCmd.getBytes());
    }

    private void writeProc(String path, byte[] buffer) {
        try {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(buffer);
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
