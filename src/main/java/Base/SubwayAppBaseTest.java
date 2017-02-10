package Base;

import base.test.BaseTest;
import execution.platform.Executors;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

/**
 * Created by test-user on 1/30/17.
 */
public class SubwayAppBaseTest extends BaseTest {
    ApplicationContext context;
    String driverName;
    @BeforeSuite(alwaysRun = true)
    public void setupSuite1(ITestContext testContext) throws Exception {
        context = new FileSystemXmlApplicationContext("src/test/resources/MobileAppBeans.xml");
        executors = (Executors) context.getBean("executors");
        driverName = testContext.getCurrentXmlTest().getParameter("driverName");
        BaseTest.EXPLICIT_WAIT_TIME = 300;
    }
}
