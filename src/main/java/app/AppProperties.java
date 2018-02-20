package app;


import app.enums.AppBrowser;
import com.sun.istack.internal.NotNull;
import org.openqa.selenium.chrome.ChromeOptions;
import app.utlis.PropertiesUtils;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppProperties {

   private final static Properties LOCAL = PropertiesUtils.of("app.properties").load();
   private final static Properties REMOTE = PropertiesUtils.of("remote.properties").load();

    public Properties getFireFoxProperties() {
       return createFilterProperty(LOCAL , this::isFireFoxKey);
    }

    public Properties getChromeProperties() {
       return createFilterProperty(LOCAL, this::isChromeKey);
    }

    public ChromeOptions getChromeOptionFromProperties() {
        return createChromeOptionsOf(LOCAL);
    }

    public Properties getFireFoxRemoteProperties() {
        return createFilterProperty(REMOTE,this::isFireFoxKey);
    }

    public Properties getChromeRemoteProperties() {
        return createFilterProperty(REMOTE,this::isChromeKey);
    }

    public ChromeOptions getChromeRemoteOptionFromProperties() {
        return createChromeOptionsOf(REMOTE);
    }

    public int getWaitFromProperties(AppBrowser browser) {
        if (browser.equals(AppBrowser.FIREFOX)
                || browser.equals(AppBrowser.CHROME)) {
            return Integer.parseInt(LOCAL.getProperty("wait.timeout"));
        }
        return Integer.parseInt(REMOTE.getProperty("wait.timeout"));
    }

    public boolean getRetryAnalizerFromProperties(AppBrowser browser) {
        if (browser.equals(AppBrowser.FIREFOX)
                || browser.equals(AppBrowser.CHROME)) {
            return Boolean.parseBoolean(LOCAL.getProperty("retry.analizer"));
        }
       return Boolean.parseBoolean(REMOTE.getProperty("retry.analizer"));
    }

    private ChromeOptions createChromeOptionsOf(Properties pro) {
        Properties prop = createFilterProperty(pro, this::isChromeOptionKey);

        Set<String> values = new HashSet<>();
        for (Object key : prop.keySet()) {
            values.add(prop.getProperty((String) key));
        }

        ChromeOptions option = new ChromeOptions();

        values.forEach(option::addArguments);
        return option;
    }


    private  Properties createFilterProperty(@NotNull Properties p,
                                             Predicate<? super Object> pre) {
        Properties properties = new Properties();
        Set<Object> keys = p.keySet();
        Set<Object> chromeKeys = keys.stream()
                .filter(pre)
                .collect(Collectors.toSet());
        for (Object key:chromeKeys) {
            String k = (String) key;
            properties.setProperty(k, LOCAL.getProperty(k));
        }
        return properties;
    }

    private boolean isChromeKey(@NotNull Object k) {
        return ((String) k).contains("chrome");
    }

    private boolean isFireFoxKey(@NotNull Object k){
        return ((String) k).contains("firefox");
    }

    private boolean isChromeOptionKey(@NotNull Object k) {
        return ((String) k).contains("option.chrome");
    }
}
