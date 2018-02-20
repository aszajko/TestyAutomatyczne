package app.utlis;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtils {

    private String input;
    private Properties properties = new Properties();

    private PropertiesUtils(String input) {
     this.input = input;
    }

    public static PropertiesUtils of(String file) {
       return new PropertiesUtils(file);
    }

    public Properties load() {
        File file = new File(input);
        try {
            properties.load(FileUtils.openInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
