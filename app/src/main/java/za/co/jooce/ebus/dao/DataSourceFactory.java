package za.co.jooce.ebus.dao;

import za.co.jooce.ebus.devices.cardlan.CardLanCardDevice;

public class DataSourceFactory {

    public static CardDevice getCardDevice() {
        return new CardLanCardDevice();
    }
}
