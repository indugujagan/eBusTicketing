package za.co.jooce.ebus.devices.cardlan.data;

import com.cardlan.utils.ByteUtil;

/**
 * Created by cardlan on 18-6-9.
 */

public class KeyConstant {

    /**
     * The key calculated by the authorization card
     */
    public static byte[] mAuthCardKey = ByteUtil.hexStringToByteArray("1122334455667788");

}
