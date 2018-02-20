package app;

import app.enums.AppBrowser;
import app.enums.AppEnv;
import lombok.Data;

import javax.annotation.Nullable;

public class AppInitializer {

    private static AppStartData data = new AppStartData();

    public AppInitializer addFromSystemProperty(String browser , AppBrowser defualt){
        data.setBrowserFromProperty(browser, defualt);
        return this;
    }

    public AppBrowser getBrowser() {
        return data.getBrowser();
    }

    public AppEnv getEnv() {
        return data.getEnv();
    }

    public int getTimeOutWait() {
        AppProperties prop = new AppProperties();
       return prop.getWaitFromProperties(data.getBrowser());
    }

    public boolean isReRunTest() {
        AppProperties prop = new AppProperties();
        return prop.getRetryAnalizerFromProperties(data.getBrowser());
    }

    @Data
    public static class AppStartData {
        private AppBrowser browser;
        private AppEnv env;

        void setBrowserFromProperty(@Nullable String browser,
                                    AppBrowser defaultBrowser) {
            if (browser == null) {
                setBrowser(defaultBrowser);
            } else {
                setBrowser(AppBrowser.valueOf(browser.toUpperCase()));
            }
        }
    }

}

