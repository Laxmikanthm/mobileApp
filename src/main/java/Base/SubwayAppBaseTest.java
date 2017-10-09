package Base;

import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import execution.platform.Executors;
import io.appium.java_client.AppiumDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pojos.user.MobileUser;
import util.ZephyrClient;
import utils.CommonUtils;
import utils.Logz;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by test-user on 1/30/17.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class SubwayAppBaseTest extends BaseTest {
    ApplicationContext context;
    String driverName;
    public static String platformName=System.getProperty("mobilePlatform");
    Date date = new Date();
    DateFormat dateFormatee = new SimpleDateFormat("yyyy-MMM-dd-HH_mm");
    ZephyrClient jwt = new ZephyrClient("10001", "10401");
    public static Map<String, List<String>> map = null;
    public static String cycleID,cloneCycleId;
    Boolean flag = Boolean.parseBoolean(System.getProperty("zephyrUpdate"));
    MobileUser mobileUser;
    Store store= JdbcUtil.getLoyaltyStoreDetails();
    public static String countryName;

    @BeforeSuite(alwaysRun = true)
    public void setupSuite1(ITestContext testContext) throws Exception {
        context = new FileSystemXmlApplicationContext("src/test/resources/MobileAppBeans.xml");
        executors = (Executors)context.getBean("executors");
        driverName = testContext.getCurrentXmlTest().getParameter("driverName");
        BaseTest.EXPLICIT_WAIT_TIME = 300;
        if(flag) {
            cloneCycleId=jwt.getAllCycle("Regression Test Clone cycle");
           cycleID = jwt.createCycle("Regression cycle - " + dateFormatee.format(date));
           jwt.addTestsToCycle(cycleID,cloneCycleId);
           map = jwt.getExecutionsByCycleId(cycleID);

        }
    }


    @Override
    @AfterMethod
    protected void methodTearDown(ITestResult result) throws IOException {

        /*
           We are using driver.quit(), not driver.close(). As a general rule of thumb, you should
           not use driver.close() to clean up. It will throw an error if something happened during
           your test that caused the WebDriver instance to close early. The close and clean up
           command in the WebDriver API is driver.quit(). You would normally use driver.close()
           if your test opens multiple windows and you want to shut some of them.*/
        try {
           // eyes.close();
            if(flag) {
                for (int i = 0; i < result.getMethod().getMethodName().split("_").length-1; i++) {
                    jwt.updateExecutions(map.get("DFA-" + result.getMethod().getMethodName().split("_")[i + 1]), cycleID,result);
                }
            }
            drivers = driverThread.get();
            drivers.forEach((k, v) -> {
                if (!(v instanceof AppiumDriver)) {

                    if (v != null) {
                        if (System.getProperty("spring.profiles.active").equalsIgnoreCase("sauce")) {
                            updateSauceLabTestStatus(result, v);
                        }
                        Logz.info("Quitting driver: " + k);

                        v.quit();
                    }
                }
            });
            Logz.endTestCase(result);
         //   eyes.abortIfNotClosed();
        }
        catch (Exception e){
            Logz.fatal("After method failed");
        }

    }
    @Override
    @AfterSuite(alwaysRun = true)
    protected void endSuite(ITestContext testContext) throws Exception{
        // ArduinoClient.closePort();
        drivers.forEach((k,v)->{
            if ((v instanceof AppiumDriver)) {

                if (v != null) {
                    Logz.info("Quitting drivers");
                    v.quit();
                }
            }
        });        Logz.info("Completed running the test suite " + testContext.getCurrentXmlTest().getSuite().getName());
        executors.terminate();
        CommonUtils.archiveTestResults();
    }

    public MobileUser setCountryName() throws Exception {
        countryName = System.getProperty("country");
        Logz.step("Country " +countryName+ " is selected");
        String localeName = System.getProperty("locale");
        Logz.step("Locale " +localeName+ " is selected");
        if(countryName.equalsIgnoreCase("US") && localeName.equalsIgnoreCase("us_En")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        }
        else if(countryName.equals("CA") && localeName.equalsIgnoreCase("ca_En")) {
            mobileUser = new MobileUser(false, Country.Canada, store.getLocationCode());
        }
        return mobileUser;
    }


}