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
import org.testng.annotations.BeforeSuite;
import pojos.user.MobileUser;


import java.lang.reflect.Method;

/**
 * Created by test-user on 1/30/17.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class SubwayAppBaseTest extends BaseTest {
    ApplicationContext context;
    String driverName;
    private Object driver;
    public MobileUser mobileUser;
    public static String platformName=System.getProperty("mobilePlatform");
    public static String countryName=System.getProperty("country");






    @BeforeSuite(alwaysRun = true)
    public void createSuite(ITestContext testContext) throws Exception {
        context = new FileSystemXmlApplicationContext("src/test/resources/MobileAppBeans.xml");
        executors = (Executors) context.getBean("executors");
        driverName = testContext.getCurrentXmlTest().getParameter("driverName");
        BaseTest.EXPLICIT_WAIT_TIME = 300;

    }


}