package homePageTest;

import Base.SubwayAppBaseTest;
import org.testng.annotations.Test;

public class HomePage extends SubwayAppBaseTest {
    @Test
    public void testHomePageLayoutNewUserSignedIn(){
        //assert Subway header in lending page
        //assert eat, earn rewards, repeat text
        //assert hungry text
        //assert find your subway text
        //assert loyalty card, scan tat register cart
        //assert mywaay Subway cart
        //assert Start order button
    }

    @Test
    public void testRecentOrdersInHomePage(){

    }
    @Test
    public void testDealOrder(){

    }
    @Test
    public void testCustomizedDealOrder(){

    }
    @Test
    public void testYorePickupCartDetails(){
        //place few orders from API
        //assert all your prick up cart details
        //see details, get direction button
    }
    @Test
    public void testYourOrderAddSomethingElse() throws Exception {
        //try to place an order from recent orders in home page - click on add to bag icon
        //return back from your order page
        // click anther order add to bag button
        //assert pop up alert message(should we clear your carat and reorder these items?)
        //click never mind
        // click anther order add to bag button
        //assert pop up alert message(should we clear your carat and reorder these items?)
        //click continue
        // click x icon in your order page
        // assert and select add somethingelse button
        //select an item and place order
        //assert placed order in home page


    }

}
