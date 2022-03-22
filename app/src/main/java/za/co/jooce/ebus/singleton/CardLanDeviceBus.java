package za.co.jooce.ebus.singleton;

import com.cardlan.twoshowinonescreen.CardLanStandardBus;

public class CardLanDeviceBus {


    private static CardLanStandardBus cardLanStandardBus;



    public static CardLanStandardBus getInstance() {
        if (cardLanStandardBus == null) {


            cardLanStandardBus = new CardLanStandardBus();

        }

        return cardLanStandardBus;
    }
}
