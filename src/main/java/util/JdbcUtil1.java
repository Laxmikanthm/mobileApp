package util;

import cardantApiFramework.pojos.Menu;
import cardantApiFramework.pojos.MenuGroupOption;
import cardantApiFramework.pojos.MenuOption;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.Orders;
import cardantApiFramework.utils.JdbcUtil;
import cardantApiFramework.utils.NumberUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by subway on 12/1/17.
 */
public class JdbcUtil1 {
    static Connection conn = null;
    static Statement statement = null;
    static ResultSet rs = null;
    static Properties dbProperties = null;

    public JdbcUtil1() {
    }

    private static void getConnection() {
        try {
            getDbConnection();
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }

    private static List<Store> getListOfStores(String queryString) {
        ArrayList storeList = new ArrayList();

        try {
            getConnection();
            rs = statement.executeQuery(queryString);
            boolean found = false;

            while(rs.next()) {
                Store store = new Store();
                found = true;
                store.setStoreNumber(String.valueOf(rs.getInt("LocationCode")));
                store.setLocationCode(rs.getInt("LocationCode"));
                store.setAddress1(rs.getString("Address1"));
                store.setAddress2(rs.getString("Address2"));
                store.setCity(rs.getString("City"));
                store.setStateProvCode(rs.getString("StateProvCode"));
                store.setZipCode(rs.getString("ZipCode"));
                store.setCountryCode(rs.getString("CountryCode"));
                store.setTimeZone(rs.getString("TimeZone"));
                store.setBreakStartTime(rs.getString("dtBreakfastBegin"));
                store.setBreakEndTime(rs.getString("dtBreakfastEnd"));
                store.setBreakStartTime(rs.getString("dtBreakfastBegin"));
                store.setBreakEndTime(rs.getString("dtBreakfastEnd"));
                store.setPickUpAvalability(rs.getBoolean("HasPickup"));
                store.setLatitude(rs.getString("Lat"));
                store.setLongitude(rs.getString("Lon"));
                store.setPickUpAvalability(rs.getBoolean("HasPickup"));
                storeList.add(store);
            }

            if(!found) {
                System.out.println("No Online Stores Available");
            }

            closeConnection();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return storeList;
    }

    private static Store getRandomStore(List<Store> storeList) {
        for(Store store : storeList){
            if(store.getAddress1().contains("4903 Sheridan St")){
                return store;
            }
        }
        return null;
        //return (Store)storeList.get(NumberUtil.getRandomInt(0, storeList.size() - 1));
    }

    public static Store getStoreDetails() {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        String queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where MerchantID='" + intMerchantID + "' AND StateProvCode NOT IN ('GU','PR') AND LocationCode != 19056";
        return getRandomStore(getListOfStores(queryString));
    }

    public static Store getStoreDetails(String Provcode, boolean IsR2Pilot) {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        int iIsR2pilot = IsR2Pilot?1:0;
        String queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc  join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where l.MerchantID=" + intMerchantID + " and l.IsR2_pilot = " + iIsR2pilot + "  and l.StateProvCode='" + Provcode + "' and l.hasDineIN = 1 AND l.LocationCode != 19056";
        List<Store> lststores = getListOfStores(queryString);
        Store onlinestre = null;
        if(lststores.size() > 0) {
            onlinestre = getRandomStore(lststores);
        }

        return onlinestre;
    }

    public static Store getStateSpecificStoreDetails(String ProvinceCode, boolean Loyalty) {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        String queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where MerchantID='" + intMerchantID + "' AND StateProvCode IN ('" + ProvinceCode + "') AND LocationCode != 19056 AND IsR2_Pilot = 1";
        if(!Loyalty) {
            queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where MerchantID='" + intMerchantID + "' AND StateProvCode IN ('" + ProvinceCode + "') AND LocationCode != 19056 AND IsR2_Pilot = 0";
        }

        return getRandomStore(getListOfStores(queryString));
    }

    public static Store getNonLoyaltyStoreDetails() {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        String queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where MerchantID='" + intMerchantID + "' AND StateProvCode NOT IN ('GU','PR') AND LocationCode != 19056 AND IsR2_Pilot = 0";
        return getRandomStore(getListOfStores(queryString));
    }

    public static Store getLoyaltyStoreDetails() {
        Store store = new Store();
        store.setZipCode("33021");
        store.setAddress1("4903 Sheridan St");
        store.setStoreNumber("10799");
        return store;
//        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
//        String queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where MerchantID='" + intMerchantID + "' AND StateProvCode NOT IN ('GU','PR') AND LocationCode != 19056 AND IsR2_Pilot = 1";
//        return getRandomStore(getListOfStores(queryString));

    }

    public static Store getStoreDetails(String strStoreNumber) {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        String queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where MerchantID='" + intMerchantID + "' AND StateProvCode NOT IN ('GU','PR') AND LocationCode != 19056 AND LocationCode = '" + strStoreNumber + "'";
        return getRandomStore(getListOfStores(queryString));
    }

    public static Store getDineInStoreDetails() {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        String queryString = "select top 10 * from [Catering].[dbo].[SmartPOSClients] spc join [Catering].[dbo].[Locations] l on spc.LocationID = l.LocationID where MerchantID='" + intMerchantID + "' AND StateProvCode NOT IN ('GU','PR') AND LocationCode != 19056 AND IsR2_Pilot = 1 AND HasDineIn= 1";
        return getRandomStore(getListOfStores(queryString));
    }

    public static int getOnlineStore() {
        int LocationCode = 0;

        try {
            Store store = getStoreDetails();
            LocationCode = store.getLocationCode();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return LocationCode;
    }

    public static Orders getOrder(String orderNum) {
        getConnection();
        Orders order = new Orders();

        try {
            String queryString = "select top 1 * from [Catering].[dbo].[Orders] where TrackingNumber='" + orderNum + "'";
            rs = statement.executeQuery(queryString);
            if(rs.next()) {
                order.setOrderID(rs.getInt("OrderID"));
                order.setCartID(rs.getString("CartID"));
                order.setNotes(rs.getString("Notes"));
                order.setSubTotal(rs.getDouble("SubTotal"));
                order.setTotalTaxAmount(rs.getDouble("TotalTaxAmount"));
                order.setTotal(rs.getDouble("Total"));
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return order;
    }

    public static void main(String[] args) {
        System.setProperty("environmentR1R2", "r2");
        System.setProperty("country", "US");
        new JdbcUtil();
        Store store = getLoyaltyStoreDetails();
        int StoreDt = getOnlineStore();
        Orders order = getOrder("632BE564-FA");
        System.out.println(order.getCartID());
    }

    public static void closeConnection() throws Exception {
        rs.close();
        statement.close();
        conn.close();
    }

    private static void getDbConnection() {
        try {
            dbProperties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            String envrn = System.getProperty("environmentR1R2");
            String environment = envrn.toUpperCase();
            String proprtyFile = "dbConfig" + environment + ".properties";
            System.out.println("property file name " + proprtyFile);
            InputStream stream = loader.getResourceAsStream(proprtyFile);
            dbProperties.load(stream);
            if(conn == null || conn.isClosed()) {
                Class.forName(dbProperties.getProperty("dbclassstring"));
                conn = DriverManager.getConnection(dbProperties.getProperty("cateringdb_url"), dbProperties.getProperty("cateringdb_uname"), dbProperties.getProperty("cateringdb_pwd"));
                if(conn == null) {
                    throw new Exception("Failed to connect to the database");
                }

                System.out.println("connected");
                statement = conn.createStatement();
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    private static Menu getMenuDetails(String queryString) {
        ArrayList menuList = new ArrayList();

        try {
            getConnection();
            rs = statement.executeQuery(queryString);
            boolean found = false;

            while(rs.next()) {
                Menu menu = new Menu();
                found = true;
                menu.setProductClassGroupName(rs.getString("ProductClassGroupName"));
                menu.setLocationID(rs.getInt("LocationID"));
                menu.setProductID(rs.getInt("ProductID"));
                menu.setProductName(rs.getString("ProductName"));
                menu.setProductPrice(rs.getDouble("ProductPrice"));
                menuList.add(menu);
            }

            if(!found) {
                System.out.println("No Online Stores Available");
            }

            closeConnection();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return (Menu)menuList.get(NumberUtil.getRandomInt(0, menuList.size() - 1));
    }

    private static Menu prepareMenuOptions(String strQuery, Menu menuItem) {
        List<MenuGroupOption> lstMenuGroup = getMenuOptions(strQuery);
        List<MenuOption> lstMenuOption = new ArrayList();
        List<String> lstmenuGroup = new ArrayList();
        Iterator var6 = lstMenuGroup.iterator();

        while(var6.hasNext()) {
            MenuGroupOption groupOption = (MenuGroupOption)var6.next();
            if(!lstmenuGroup.contains(groupOption.getOptionGroupCode())) {
                lstmenuGroup.add(groupOption.getOptionGroupCode());
            }
        }

        var6 = lstmenuGroup.iterator();

        while(var6.hasNext()) {
            String strgroupOption = (String)var6.next();
            MenuOption menuOption = new MenuOption();
            List<MenuGroupOption> filterGroup = new ArrayList();
            menuOption.setStrGroupTitle(strgroupOption);
            Iterator var10 = lstMenuGroup.iterator();

            while(var10.hasNext()) {
                MenuGroupOption menuGroupOption = (MenuGroupOption)var10.next();
                if(strgroupOption.contains(menuGroupOption.getOptionGroupCode())) {
                    filterGroup.add(menuGroupOption);
                }
            }

            menuOption.setLstMenuGroupOption(filterGroup);
            lstMenuOption.add(menuOption);
        }

        menuItem.setMenuOptoins(lstMenuOption);
        return menuItem;
    }

    private static List<MenuGroupOption> getMenuOptions(String queryString) {
        ArrayList menuOptionList = new ArrayList();

        try {
            getConnection();
            rs = statement.executeQuery(queryString);
            boolean found = false;

            while(rs.next()) {
                MenuGroupOption menuOption = new MenuGroupOption();
                found = true;
                menuOption.setOptionID(rs.getInt("OptionID"));
                menuOption.setProductOptionID(rs.getInt("ProductOptionID"));
                menuOption.setCalories(rs.getString("Calories"));
                menuOption.setOptionName(rs.getString("OptionName"));
                menuOption.setOptionType(rs.getString("OptionType"));
                menuOption.setOptionGroupCode(rs.getString("OptionGroupCode"));
                menuOptionList.add(menuOption);
            }

            if(!found) {
                System.out.println("No Product Options are available");
            }

            closeConnection();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return menuOptionList;
    }

    public static Menu getMenu(String strLocationCode, String strMenuClassName, String strOrderType) {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        int intMenuID;
        if(intMerchantID == 1) {
            intMenuID = strOrderType.toUpperCase().equalsIgnoreCase("INDIVIDUAL")?10:1;
        } else {
            intMenuID = strOrderType.toUpperCase().equalsIgnoreCase("INDIVIDUAL")?6:60;
        }

        String queryString = "select lp.LocationID, lp.ProductID, lp.ProductName, lp.ProductPrice, lp.ProductClassGroupName, lp.ProductAvailable  from mv_locationproducts lp join Locations l on l.LocationID = lp.LocationID where l.Locationcode = '" + strLocationCode + "' and lp.ProductClassGroupName like '%" + strMenuClassName + "%' and lp.MerchantID = " + intMerchantID + " and lp.MenuID = " + intMenuID + " and lp.ProductAvailable in (1,-1,0)";
        Menu menu = getMenuDetails(queryString);
        queryString = "select po.ProductID, po.OptionID, po.ProductOptionID, po.Calories, po.OptionName, po.OptionType, po.OptionGroupCode from LocationOptions lo join mv_ProductOptions po on lo.OptionID = po.OptionID join Locations l on lo.LocationID = l.LocationID  where po.ProductID = " + menu.getProductID() + " and lo.menuID = " + intMenuID + " and lo.Available = 1 and l.LocationCode = '" + strLocationCode + "'";
        menu = prepareMenuOptions(queryString, menu);
        return menu;
    }

    public static Menu getMenu(String strLocationCode, String strMenuClassName, boolean isIndividual) {
        int intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?1:100;
        int intMenuID;
        if(intMerchantID == 1) {
            intMenuID = isIndividual?10:1;
        } else {
            intMenuID = isIndividual?60:6;
        }

        String queryString = "select lp.LocationID, lp.ProductID, lp.ProductName, lp.ProductPrice, lp.ProductClassGroupName, lp.ProductAvailable  from mv_locationproducts lp join Locations l on l.LocationID = lp.LocationID where l.Locationcode = '" + strLocationCode + "' and lp.ProductClassGroupName like '%" + strMenuClassName + "%' and lp.MerchantID = " + intMerchantID + " and lp.MenuID = " + intMenuID + " and lp.ProductAvailable in (1,-1,0)";
        Menu menu = getMenuDetails(queryString);
        queryString = "select po.ProductID, po.OptionID, po.ProductOptionID, po.Calories, po.OptionName, po.OptionType, po.OptionGroupCode from LocationOptions lo join mv_ProductOptions po on lo.OptionID = po.OptionID join Locations l on lo.LocationID = l.LocationID  where po.ProductID = " + menu.getProductID() + " and lo.menuID = " + intMenuID + " and lo.Available = 1 and l.LocationCode = '" + strLocationCode + "'";
        menu = prepareMenuOptions(queryString, menu);
        return menu;
    }

    public static Menu getHotColdMenuItem(String strLocationCode, String strProductClassGroupName, Boolean isHotItem, Boolean isIndividual) {
        boolean intMerchantID = System.getProperty("country").equalsIgnoreCase("US")?true:true;
        int intMenuID = isIndividual.booleanValue()?10:1;
        int intTaxID = isHotItem.booleanValue()?1:2;
        String queryString = "select l.LocationID,lp.ProductId, lp.ProductName, lp.ProductPrice, lp.ProductClassGroupName from [SubExMenuItems] s  join  (select LocationId from Locations nolock where LocationCode = '" + strLocationCode + "') l on s.LocationID = l.LocationID join (select  PLUSubwayPOS, ProductId from PLUs nolock where MenuID = " + intMenuID + " and AttributeValue1 is NULL group by ProductId,PLUSubwayPOS) p on s.PLU = p.PLUSubwayPOS  join (select * from mv_locationproducts where  ProductClassGroupName like '%" + strProductClassGroupName + "%' and MenuID = " + intMenuID + ") lp  on p.ProductID = lp.ProductID and lp.LocationID = l.LocationID where s.TaxCategoryTypeId = " + intTaxID + "";
        Menu menu = getMenuDetails(queryString);
        queryString = "select po.ProductID, po.OptionID, po.ProductOptionID, po.Calories, po.OptionName, po.OptionType, po.OptionGroupCode from LocationOptions lo join mv_ProductOptions po on lo.OptionID = po.OptionID join Locations l on lo.LocationID = l.LocationID  where po.ProductID = " + menu.getProductID() + " and lo.menuID = " + intMenuID + " and lo.Available = 1 and l.LocationCode = '" + strLocationCode + "'";
        menu = prepareMenuOptions(queryString, menu);
        return menu;
    }
}
