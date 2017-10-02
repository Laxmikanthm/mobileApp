package util;

import base.test.BaseTest;
import utils.Logz;

import java.text.DecimalFormat;
import java.util.Random;

public class Utils {

    public static int selectRandomItem(int givenValue) throws Exception{
        Random rand = new Random();
        return rand.nextInt(givenValue);
    }
    public static String removeTrailingZero(String value)  {
        value = value.replaceAll("\\$","").trim();
        DecimalFormat decimalFormat = new DecimalFormat("0.#####");
        String result = decimalFormat.format(Double.valueOf(value));
        //      System.out.println(result);
        return result;
//
//            String value = "10.010"
//            String s = new DecimalFormat("0.####").format(Double.parseDouble(value));
//            System.out.println(s);

    }
    public static String convert12inchToFootLong(String itemName) throws Exception{
        try{
            if(itemName.contains("12\""))
                return itemName.replace("12\"", BaseTest.getStringfromBundleFile("FootLong"));
            else
                return itemName;
        }catch(Exception ex){
            Logz.step("Unable to convert 12 inch to footlong.\\n" + ex.getMessage());
            throw new Exception(("Unable to convert 12 inch to footlong.\n" + ex.getMessage()));
        }

    }
}
