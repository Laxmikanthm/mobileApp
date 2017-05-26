package pages.AddCardPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.PayPalPage.PayPalPage;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pojos.user.MobileUser;

/**
 * Created by e002243 on 01-03-2017.
 */
public abstract class AddCardPage <T extends AppiumDriver> extends MobileBasePage {

    public AddCardPage(AppiumDriver driver){ super(driver);}

    abstract MobileTextBox getCardNumber() throws Exception;
    abstract MobileTextBox getExpiresOn() throws Exception;
    abstract MobileTextBox getCCV() throws Exception;
    abstract MobileTextBox getPin() throws Exception;
    abstract MobileTextBox getNameOnCard() throws Exception;
    abstract MobileButton getNextButton() throws  Exception;
    abstract MobileTextBox getBillingStreetAddress() throws Exception;
    abstract MobileTextBox getBillingZipCode() throws Exception;
    abstract MobileButton getReviewDetails() throws  Exception;
    abstract MobileButton getSavePaymentMethod() throws  Exception;
    abstract MobileButton getGiftCardSavePayment() throws  Exception;
    abstract MobileButton getBackButton() throws Exception;
    abstract MobileLabel getCreditCardType() throws Exception;
    abstract MobileLabel getDebitCardType() throws Exception;
    abstract MobileLabel getGiftCardType() throws Exception;
    abstract MobileLabel getPayPalType() throws Exception;
    abstract MobileButton getAddPaymentMethod() throws Exception;


    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public static AddCardPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new AddCardPageIOS((IOSDriver) driver);
            case "Android":
                return new AddCardPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public ChoosePaymentMethodPage addPaymentMethod() throws Exception
    {
        try{
            getAddPaymentMethod().click();

            return ChoosePaymentMethodPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }
    public PaymentMethodsPage addCardDetails(MobileUser mobileUser) throws Exception
    {
        try{
            getCardNumber().isReady();
            //getCardNumber().setText(mobileUser.getCreditCards().get(0).getCardNumber());
            getCardNumber().setText("4111111111111111");
            HideKeyboard();
            //getNameOnCard().setText(mobileUser.getFirstName()+mobileUser.getLastName());
           // HideKeyboard();
            getNextButton().click();
            String date = mobileUser.getCreditCards().get(0).getExpirationDate();
            String cardExpiryDate = date.substring(0,2)+"/"+date.substring(4,6);
            /*String ExpiryDate[] = date.split("/");
            String year = ExpiryDate[2].substring(2,4);
            String cardExpiryDate = ExpiryDate[0]+"/"+year;*/
            getExpiresOn().setText(cardExpiryDate);
            getCCV().setText(mobileUser.getCreditCards().get(0).getCsvCode());
            HideKeyboard();
            getNextButton().click();
            getBillingStreetAddress().isReady();
            getBillingStreetAddress().setText(mobileUser.getStreetAddresss());
            getBillingZipCode().setText(mobileUser.getPostalCode());
            getReviewDetails().click();
            getSavePaymentMethod().isReady();
            getSavePaymentMethod().click();
            return PaymentMethodsPage.get((AppiumDriver) driver);

        }catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }

    public PaymentMethodsPage addSubwayCardDetails(MobileUser mobileUser) throws Exception
    {
        try{
            getCardNumber().isReady();
            getCardNumber().setText(mobileUser.getSubwayCards().get(0).getCardNumber());
            HideKeyboard();
            getPin().setText(mobileUser.getSubwayCards().get(0).getCode());
            HideKeyboard();
            getGiftCardSavePayment().click();
            return PaymentMethodsPage.get((AppiumDriver) driver);
        }catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }
    public void HideKeyboard()
    {
        AppiumDriver d = (AppiumDriver)driver;
        d.hideKeyboard();
    }

    public void selectBackButton()  throws Exception
    {

        getBackButton().isReady();
        getBackButton().click();

    }

    public void addCreditorDebitCard(MobileUser mobileUser) throws Exception
    {
        ChoosePaymentMethodPage choosePaymentMethodPage = addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
    }

    public void addGiftCard(MobileUser mobileUser) throws Exception
    {
        ChoosePaymentMethodPage choosePaymentMethodPage = addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodGiftCard();
        PaymentMethodsPage paymentMethodsPage=  addCardPage.addSubwayCardDetails(mobileUser);
    }

    public void addPayPal( MobileUser mobileUser) throws Exception
    {
        ChoosePaymentMethodPage choosePaymentMethodPage = addPaymentMethod();
        PayPalPage payPalPage = choosePaymentMethodPage.ChoosePaymentMethodPayPalCard();
        payPalPage.addPaypalDetails(mobileUser);
    }

    public void addPayment(MobileUser mobileUser,enums.PaymentMethod paymentType) throws Exception{
        ChoosePaymentMethodPage choosePaymentMethodPage;
        AddCardPage addCardPage;
        PaymentMethodsPage paymentMethodsPage;
        switch(paymentType){
            case CREDITCARD:
                choosePaymentMethodPage = addPaymentMethod();
                addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
                paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
                break;
            case DEBITCARD:
                choosePaymentMethodPage = addPaymentMethod();
                addCardPage = choosePaymentMethodPage.ChoosePaymentMethodDebitCard();
                paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
                break;
            case SUBWAYCARD:
                choosePaymentMethodPage = addPaymentMethod();
                addCardPage = choosePaymentMethodPage.ChoosePaymentMethodGiftCard();
                paymentMethodsPage= addCardPage.addSubwayCardDetails(mobileUser);
                break;
            case PAYPAL:
                choosePaymentMethodPage = addPaymentMethod();
                PayPalPage payPalPage = choosePaymentMethodPage.ChoosePaymentMethodPayPalCard();
                payPalPage.addPaypalDetails(mobileUser);
                break;

        }

    }

    public boolean checkCreditCardElementPresence()throws Exception
    {
        try{
            getCreditCardType().isReady();
            boolean creditCardDisplayed= getCreditCardType().getControl().isDisplayed();
            if(creditCardDisplayed){
                return true;
            }else{
                return false;
            }

        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

    public boolean checkDebitCardElementPresence()throws Exception
    {
        try{
            getDebitCardType().isReady();
            boolean debitCardDisplayed= getDebitCardType().getControl().isDisplayed();
            if(debitCardDisplayed){
                return true;
            }else{
                return false;
            }

        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

    public boolean checkGiftCardElementPresence()throws Exception
    {
        try{
            getGiftCardType().isReady();
            boolean giftCardDisplayed= getGiftCardType().getControl().isDisplayed();
            if(giftCardDisplayed){
                return true;
            }else{
                return false;
            }

        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

    public boolean checkPayPalElementPresence()throws Exception
    {
        try{
            getPayPalType().isReady();
            boolean paypalDisplayed= getPayPalType().getControl().isDisplayed();
            if(paypalDisplayed){
                return true;
            }else{
                return false;
            }

        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

}


