package Base;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import execution.platform.Executors;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import pages.HomePage.SubwayAppHomePage;

/**
 * Created by test-user on 1/30/17.
 */
public class SubwayAppBaseTest extends BaseTest {
    ApplicationContext context;
    String driverName;
    private Object driver;

    @BeforeSuite(alwaysRun = true)
    public void setupSuite1(ITestContext testContext) throws Exception {
        context = new FileSystemXmlApplicationContext("src/test/resources/MobileAppBeans.xml");
        executors = (Executors) context.getBean("executors");
        driverName = testContext.getCurrentXmlTest().getParameter("driverName");
        BaseTest.EXPLICIT_WAIT_TIME = 300;
    }
}