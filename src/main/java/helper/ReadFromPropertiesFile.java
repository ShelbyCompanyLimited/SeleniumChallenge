package helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {

    public Properties properties;
    public final String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\settings.properties";


    public ReadFromPropertiesFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getItemName() {
        String item = properties.getProperty("itemName");
        if (item != null) return item;
        else throw new RuntimeException("itemName is not specified in Property File");
    }

    public String getItemPrice() {
        String item = properties.getProperty("itemPrice");
        if (item != null) return item;
        else throw new RuntimeException("itemPrice is not specified in Property File");
    }

    public String getExpectedItemCount() {
        String item = properties.getProperty("expectedItemsCount");
        if (item != null) return item;
        else throw new RuntimeException("expectedItemsCount is not specified in Property File");
    }

    public String getShippingPrice() {
        String item = properties.getProperty("shippingPrice");
        if (item != null) return item;
        else throw new RuntimeException("shippingPrice is not specified in Property File");
    }


}