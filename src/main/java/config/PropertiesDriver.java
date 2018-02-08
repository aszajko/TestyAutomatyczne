package config;

public final class PropertiesDriver {

    public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_LOCATION = "C:\\Program Files (x86)\\Google\\Chrome"
            + "\\Application\\chrome.exe";
    public static final String CHROME_OPTIONS_ENABLE_AUTOMATION = "enable-automation";
    public static final String CHROME_DRIVER_DISABLE_INFOBARS = "--disable-infobars";

    public static final String FIREFOX_DRIVER_LOCATION = "/usr/local/bin/geckodriver";
    public static final String FIREFOX_DRIVER_PROPERTY= "webdriver.gecko.driver";

    private PropertiesDriver() {
        throw new AssertionError();
    }
}
