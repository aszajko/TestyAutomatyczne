package listener;

import app.enums.AppBrowser;
import app.AppInitializer;
import org.testng.*;

public class AppListner implements ITestListener, ISuiteListener, IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    public void onStart(ISuite iSuite) {

    }

    public void onFinish(ISuite iSuite) {

    }

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        AppInitializer appInitializer = new AppInitializer();
        appInitializer.addFromSystemProperty(System.getProperty("browser"), AppBrowser.FIREFOX);
    }

    public void onFinish(ITestContext iTestContext) {

    }
}
