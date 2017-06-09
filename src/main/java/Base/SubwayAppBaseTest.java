package Base;

import base.test.BaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import execution.platform.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import utils.Logz;

import java.lang.reflect.Method;

/**
 * Created by test-user on 1/30/17.
 */

@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class SubwayAppBaseTest extends BaseTest {
    ApplicationContext context;
    String driverName;
    private Object driver;
    public MobileUser mobileUser;


    @BeforeSuite(alwaysRun = true)
    public void setupSuite1(ITestContext testContext) throws Exception {
        context = new FileSystemXmlApplicationContext("src/test/resources/MobileAppBeans.xml");
        executors = (Executors) context.getBean("executors");
        driverName = testContext.getCurrentXmlTest().getParameter("driverName");
        BaseTest.EXPLICIT_WAIT_TIME = 300;
    }

    /*@BeforeMethod
    protected void methodSetup(Method method, ITestContext testContext) throws Exception {
        Logz.startTestCase(method.getName());
        String[] platform = testContext.getCurrentXmlTest().getParameter("platform").split(",");
        String[] browserOrDevice = testContext.getCurrentXmlTest().getParameter("browserOrDevice").split(",");
        String[] version = testContext.getCurrentXmlTest().getParameter("version").split(",");
        String[] os = testContext.getCurrentXmlTest().getParameter("os").split(",");
        String[] driverName = testContext.getCurrentXmlTest().getParameter("driverName").split(",");
        System.setProperty("testName", method.getName());
        System.setProperty("suiteName", testContext.getCurrentXmlTest().getSuite().getName());
        if(!driverName.equals("Windows")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
            RegisterUser.registerAUserWithoutCardLink(mobileUser);
            this.initializeDrivers(platform, browserOrDevice, version, os, driverName);
        }

    }*/


}