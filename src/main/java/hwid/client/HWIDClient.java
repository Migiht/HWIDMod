package hwid.client;

import java.net.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

public class HWIDClient {

    public static String getHWID() {
        StringBuilder hwid = new StringBuilder(64);
        hwid.append(System.getProperty("user.name"));
        hwid.append('^');
        try {
            hwid.append(Arrays.toString(NetworkInterface.getByInetAddress(Inet4Address.getLocalHost()).getHardwareAddress()));
        } catch (Throwable throwable) {
            hwid.append("empty");
        }
        hwid.append('^');
        hwid.append(Locale.getDefault());
        hwid.append('^');
        hwid.append(TimeZone.getDefault());
        hwid.append('^');
        hwid.append(Runtime.getRuntime().availableProcessors());
        hwid.append('^');
        hwid.append(System.getProperty("os.arch"));
        hwid.append('^');
        hwid.append(System.getProperty("os.name"));
        hwid.append('^');
        hwid.append(System.getProperty("os.version"));
        return hwid.toString();
    }
}
