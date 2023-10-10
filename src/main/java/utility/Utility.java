package utility;

import Base.TestBase_admin_portal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    private static final String DATA_CONFIG = "./Config/config.properties";
    private static Properties properties;

    /**
     * This method is used to Fetch values from the config files
     * @return
     */
    public static String fetchvalue(String value) {
        try {
            if (properties == null) {
                Utility.properties = new Properties();
                Utility.properties.load(new FileInputStream(DATA_CONFIG));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Utility.properties.getProperty(value);
    }
}