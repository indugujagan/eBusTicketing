package za.co.jooce.ebus.dao;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

public interface CardDevice {

    String scanCardESN();

    String scanCardSectors();

    String readCardCopyOne();

    String signOnCard();

    String signOffCard();

    String scanCardSectorsTwo();

    String checkDeviceNFCCapable();

    String playBuzzer();

    String playSounds(AssetFileDescriptor afd, Context context);

    String redLED();

    String greenLED();

    String HistoryRecA(byte[] manufacturingBlock);
}
