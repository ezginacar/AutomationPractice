package utils;



import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    public static final Properties properties = new Properties();

    public static String getProperties(String propKey) {
        String property = "";
        String propAddress  = String.format("%s*src*test*resources*application.properties",System.getProperty("user.dir") );
        propAddress = propAddress.replace("*", System.getProperty("file.separator"));
        try {

            InputStream input = new FileInputStream(propAddress);
            try {
                properties.load(input);
                property = properties.getProperty(propKey);
                if (property == null) {
                    Assert.fail(String.format("No value found with %s key", propKey));
                }
            }
            catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (input != null) {
                    input.close();
                }
            }

            return property;
        }
        catch (Exception ex) {
            Assert.fail("\n\tException: " + ex.getMessage());
        }

        properties.clear();

        return property;
    }


}
