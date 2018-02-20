package analizer;

import app.AppInitializer;

public class RetryAnalizer {
    private AppInitializer appInit = new AppInitializer();
    private boolean isRerun = appInit.isReRunTest();
}
