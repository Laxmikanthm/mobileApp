package pages.AddCardPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.MenuPage.MenuPage;
import pages.PayPalPage.PayPalPage;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pages.SubwayPage.SubwayPage;
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

    public PaymentMethodsPage addCardDetails(MobileUser mobileUser) throws Exception
    {
        try{
            getCardNumber().isReady();
            getCardNumber().setText("4111111111111111");
            HideKeyboard();
            getNameOnCard().setText(mobileUser.getFirstName()+mobileUser.getLastName());
            HideKeyboard();
            getNextButton().click();
            String date = mobileUser.getCreditCards().get(0).getExpirationDate();
            String cardExpiryDate = date.substring(0,3)+date.substring(8,10);
            getExpiresOn().setText(cardExpiryDate);
           // getExpiresOn().setText("12/22");
            getCCV().setText(mobileUser.getCreditCards().get(0).getCsvCode());
            HideKeyboard();
            getNextButton().click();
            getBillingStreetAddress().isReady();
            getBillingStreetAddress().setText(mobileUser.getStreetAddresss());
            getBillingZipCode().setText(mobileUser.getPostalCode());
            getReviewDetails().click();
            //HideKeyboard();
            getSavePaymentMethod().isReady();
            getSavePaymentMethod().click();
            selectBackButton();
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

    public void addCreditorDebitCard(SubwayPage subwayPage, MobileUser mobileUser) throws Exception
    {
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
    }

    public void addGiftCard(SubwayPage subwayPage, MobileUser mobileUser) throws Exception
    {
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodGiftCard();
        PaymentMethodsPage paymentMethodsPage=  addCardPage.addSubwayCardDetails(mobileUser);
    }

    public void addPayPal(SubwayPage subwayPage, MobileUser mobileUser) throws Exception
    {
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        PayPalPage payPalPage = choosePaymentMethodPage.ChoosePaymentMethodPayPalCard();
        payPalPage.addPaypalDetails(mobileUser);
    }

    public void addMethodForPayment(SubwayPage subwayPage, MobileUser mobileUser,String paymentType) throws Exception{
        switch(paymentType){
            case "CreditCard":
                ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
                AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
                PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
                break;
            case "DebitCard":
                ChoosePaymentMethodPage choosePaymentPage = subwayPage.addPaymentMethod();
                AddCardPage cardPage = choosePaymentPage.ChoosePaymentMethodDebitCard();
                PaymentMethodsPage methodsPage= cardPage.addCardDetails(mobileUser);
                break;
            case "GiftCard":
                ChoosePaymentMethodPage paymentMethodPage = subwayPage.addPaymentMethod();
                AddCardPage addPage = paymentMethodPage.ChoosePaymentMethodGiftCard();
                PaymentMethodsPage paymentPage= addPage.addSubwayCardDetails(mobileUser);
                break;
            case "Paypal":
                ChoosePaymentMethodPage choosePage = subwayPage.addPaymentMethod();
                PayPalPage payPalPage = choosePage.ChoosePaymentMethodPayPalCard();
                payPalPage.addPaypalDetails(mobileUser);
                break;

        }

    }

}


