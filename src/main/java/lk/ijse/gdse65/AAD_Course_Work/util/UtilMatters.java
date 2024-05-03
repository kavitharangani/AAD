package lk.ijse.gdse65.AAD_Course_Work.util;

import java.util.Base64;
import java.util.UUID;


public class UtilMatters {
    public static String convertBase64(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
