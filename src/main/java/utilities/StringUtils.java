package utilities;

public class StringUtils {

    public String getStringFromObject(Object obj) {
        if (obj instanceof Integer) {
            int value = (int) obj;
            return String.valueOf(value);
        } else if (obj instanceof Boolean) {
            boolean boo = (boolean) obj;
            return String.valueOf(boo);
        }
        else {
            return null;
        }
    }
}
