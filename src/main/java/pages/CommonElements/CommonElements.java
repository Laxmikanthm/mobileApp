package pages.CommonElements;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCardPage.AddCardPage;
import pages.AddCardPage.AddCardPageAndroid;
import pages.AddCardPage.AddCardPageIOS;
import pages.HomePage.HomePage;
import sun.rmi.runtime.Log;
import utils.Logz;

import java.util.List;

public class CommonElements<T extends AppiumDriver> extends MobileBasePage {
    String platform = SubwayAppBaseTest.platformName;
    TouchAction action = new TouchAction( (AppiumDriver) driver );
    boolean flag = false;
    Dimension dimensions = driver.manage().window().getSize();

    public CommonElements(AppiumDriver driver) {
        super( driver );
    }


    public void popUpClick(By locator, MobileButton controlButton) throws Exception {
        try {
            clickButton( controlButton );

        } catch (Exception ex) {
            throw new Exception( "Unable to get element list\n" + ex.getMessage() );
        }

    }

    public void clickButton(MobileButton controlButton) throws Exception {
        Logz.step( "Clicking the " + controlButton + " button" );
        controlButton.isReady();
        controlButton.click();
        Logz.step( "Clicked the " + controlButton + " button" );
    }


    public HomePage scrollAndClick(By locatorIOS, By locatorAndroid, String itemName) throws Exception {
        Logz.step( "Scrolling to element and get element list" );
        List<WebElement> allElements = getElements( locatorIOS, locatorAndroid );
        try {
            flag = false;
            if (allElements.size() == 0) {
                throw new Exception( "No element is available\n" + allElements.size() );
            }
            allElements = getElements( locatorIOS, locatorAndroid );
            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get( i ).getText().contains( itemName )) {
                    allElements.get( i ).click();
                    flag = true;
                    break;
                }
            }
            int count = 0;
            while (flag == false) {
                WebElement element = allElements.get( allElements.size() - 1 );
                MobileElement ele = (MobileElement) element;
                int startY = ele.getLocation().getY();
                int endY = (int) (startY * 0.3);
                action.longPress( 0, startY ).moveTo( 0, endY ).release().perform();
                allElements = getElements( locatorIOS, locatorAndroid );
                for (int j = 0; j < allElements.size(); j++) {
                    if (allElements.get( j ).getText().contains( itemName )) {
                        allElements.get( j ).click();
                        flag = true;
                        break;
                    }
                }
                count++;
                Logz.step( "count:" + count );
                if (count > 3) {
                    flag = false;
                    //break;
                    throw new Exception( "Unable to scroll and click element \n" );
                }
            }


            /*if(flag == false) {

                allElements.get(3).click();
                    Logz.step("selected random " +allElements.get(3).getText());
            }*/


        } catch (Exception ex) {
            throw new Exception( "Unable to scroll and click element \n" + ex.getMessage() );
        }
        Logz.step( "Scrolled to element and get element list" );
        return HomePage.get( (AppiumDriver) driver );
    }

    public boolean isAvailable(By locatorIOS, By locatorAndroid) throws Exception {
        try {
            switch (platform) {
                case "iOS":

                    return ((IOSDriver) driver).findElement( locatorIOS ).isDisplayed();
                case "Android":

                    return ((AndroidDriver) driver).findElement( locatorAndroid ).isDisplayed();

                default:
                    throw new Exception( "Unable to get element for platform " + platform );
            }
        } catch (Exception ex) {
            return false;
            // throw new Exception("Unable to get element list\n" + ex.getMessage());
        }

    }

    public List<WebElement> getElements(By locatorIOS, By locatorAndroid) throws Exception {
        try {
            switch (platform) {
                case "iOS":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, (AppiumDriver) driver, locatorIOS )) {
                        return ((IOSDriver) driver).findElements( locatorIOS );

                    }

                case "Android":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, (AppiumDriver) driver, locatorAndroid )) {
                        return ((AndroidDriver) driver).findElements( locatorAndroid );

                    }

                default:
                    throw new Exception( "Unable to get element for platform " + platform );
            }
        } catch (Exception ex) {
            throw new Exception( "Unable to get element list\n" + ex.getMessage() );
        }

    }

    protected boolean exits(int seconds, AppiumDriver driver, By by) {
        try {
            (new WebDriverWait( driver, (long) seconds )).until( ExpectedConditions.visibilityOfElementLocated( by ) );
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public WebElement getElement(By locatorIOS, By locatorAndroid, AppiumDriver driver) throws Exception {
        try {
            switch (platform) {
                case "iOS":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, driver, locatorIOS )) {
                        return ((IOSDriver) driver).findElement( locatorIOS );
                    }

                case "Android":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, driver, locatorAndroid )) {
                        return ((AndroidDriver) driver).findElement( locatorAndroid );
                    }

                default:
                    throw new Exception( "Unable to get for platform " + platform );
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to get element\n" + ex.getMessage() );
        }
    }

    public boolean getElementStatus(WebElement webElement, By locatorIOS, By locatorAndroid, AppiumDriver driver) throws Exception {
        try {
            switch (platform) {
                case "iOS":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, driver, locatorIOS )) {
                        return webElement.findElement( locatorIOS ).isEnabled();

                    }

                case "Android":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, driver, locatorAndroid )) {
                        return webElement.findElement( locatorAndroid ).isEnabled();

                    }

                default:
                    throw new Exception( "Unable to get element status for platform " + platform );
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to get element status \n" + ex.getMessage() );
        }


    }

    public int getElementListCount(By locatorIOS, By locatorAndroid, AppiumDriver driver) throws Exception {
        try {
            switch (platform) {
                case "iOS":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, driver, locatorIOS )) {
                        return driver.findElements( locatorIOS ).size();

                    }

                case "Android":
                    if (exits( SubwayAppBaseTest.EXPLICIT_WAIT_TIME, driver, locatorAndroid )) {
                        return driver.findElements( locatorAndroid ).size();

                    }

                default:
                    throw new Exception( "Unable to get element count for platform " + platform );
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to get element  count \n" + ex.getMessage() );
        }
    }

    public String getElementTextByClassName(String locatorIOS, String locatorAndroid, AppiumDriver driver, int index) throws Exception {
        try {
            switch (platform) {
                case "iOS":
                    return getElementByClass( locatorIOS, driver, index );
                case "Android":
                    return getElementByClass( locatorAndroid, driver, index );
                default:
                    throw new Exception( "Unable to get element for platform " + platform );
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to get element \n" + ex.getMessage() );
        }
    }

    private String getElementByClass(String locator, AppiumDriver driver, int index) throws Exception {
        List elementList = driver.findElementsByClassName( locator );
        AndroidElement element = (AndroidElement) elementList.get( index );
        return element.getText();
    }

    public List<WebElement> getElementListByClass(String locatorIOS, String locatorAndroid, AppiumDriver driver) throws Exception {
        try {
            switch (platform) {
                case "iOS":
                    return driver.findElementsByClassName( locatorIOS );
                case "Android":
                    return driver.findElementsByClassName( locatorAndroid );
                default:
                    throw new Exception( "Unable to get element for platform " + platform );
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to get element \n" + ex.getMessage() );
        }


    }

    public void scrollToElement(By locatorIOS, By locatorAndroid, double startPoint, double endPoint) throws Exception {
        Logz.step( "Scrolling to the element" );
        while (getElements( locatorIOS, locatorAndroid ).size() == 0) {
            flag = false;
            int StartPoint = (int) (dimensions.getHeight() * startPoint);//0.9
            int EndPoint = (int) (dimensions.getHeight() * endPoint);//0.5
            action.longPress( 0, StartPoint ).moveTo( 0, EndPoint ).release().perform();
        }
        Logz.step( "Scrolled to the element" );
    }

    public List<WebElement> scrollToElement(By locatorIOS, By locatorAndroid, String itemName) throws Exception {
        Logz.step( "Scrolling to element and get element list" );
        List<WebElement> allElements = getElements( locatorIOS, locatorAndroid );
        try {
            flag = false;
            if (allElements.size() == 0) {
                throw new Exception( "No element is available\n" + allElements.size() );
            }
            allElements = getElements( locatorIOS, locatorAndroid );
            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get( i ).getText().contains( itemName )) {
                    flag = true;
                    break;
                }
            }
            while (flag == false) {
                WebElement element = allElements.get( allElements.size() - 1 );
                MobileElement ele = (MobileElement) element;
                int startY = ele.getLocation().getY();
                int endY = (int) (startY * 0.3);
                action.longPress( 0, startY ).moveTo( 0, endY ).release().perform();
                allElements = getElements( locatorIOS, locatorAndroid );
                for (int j = 0; j < allElements.size(); j++) {
                    if (allElements.get( j ).getText().contains( itemName )) {
                        flag = true;
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            throw new Exception( "Unable to scroll to element \n" + ex.getMessage() );
        }
        allElements = getElements( locatorIOS, locatorAndroid );
        Logz.step( "Scrolled to element and get element list" );
        return allElements;
    }

    public String scrollAndGetText(WebElement element, String itemName) throws Exception {
        flag = false;

        if (element.getText().contains( itemName )) {
            flag = true;
        } else {

            Double screenHeightStart = dimensions.getHeight() * 0.9;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimensions.getHeight() * 0.5;
            int scrollEnd = screenHeightEnd.intValue();
            //driver.swipeAndClick(0,scrollStart,0,scrollEnd,2000);

            while (!element.isDisplayed()) {
                action.longPress( 0, scrollStart ).moveTo( 0, scrollEnd ).release().perform();
            }
        }
        return element.getText();


    }

    public int scrollAndGetElementCount(WebElement element) throws Exception {
        Double screenHeightStart = dimensions.getHeight() * 0.9;
        int scrollStart = screenHeightStart.intValue();
        Double screenHeightEnd = dimensions.getHeight() * 0.5;
        int scrollEnd = screenHeightEnd.intValue();
        //driver.swipeAndClick(0,scrollStart,0,scrollEnd,2000);

        while (!element.isDisplayed()) {
            action.longPress( 0, scrollStart ).moveTo( 0, scrollEnd ).release().perform();
        }

        return 0;


    }


    public void swipe(AppiumDriver driver, String direction) throws Exception {
        Logz.step( "Swiping to element" );

        try {
            dimensions = driver.manage().window().getSize();
            int startX = (int) (dimensions.width * 0.90);
            int startY = dimensions.height / 2;
            int endX = (int) (dimensions.width * 0.10);
            if (direction.equalsIgnoreCase( "Left" )) {
                action.longPress( startX, startY ).moveTo( endX, 0 ).release().perform();
            } else {
                action.longPress( endX, startY ).moveTo( startX, 0 ).release().perform();
            }
        } catch (Exception ex) {
            throw new Exception( "Unable to scroll and click element \n" + ex.getMessage() );
        }
        Logz.step( "Scrolled to element and get element list" );
    }


    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }


}
