package util;

import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import Enums.BreadSize;
import Enums.Menu;
import pojos.CustomizedItem.CustomizedItem;
import utils.Logz;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {
    private static Random rand;

    public static int selectRandomItem(int givenValue) throws Exception {
        rand = new Random();
        return rand.nextInt( givenValue );
    }

    public static String selectRandomMenu() throws Exception {
        Enum menuName = randomEnum( Menu.class );
        String menu = "";
        if (!(menuName.toString().contains( "Sides" ) || menuName.toString().contains( "Drinks" ))) {
            menu = menuName.toString();
        }
        return menu;
    }

    public static String removeTrailingZero(String value) {
        value = value.replaceAll( "\\$", "" ).trim();
        DecimalFormat decimalFormat = new DecimalFormat( "0.#####" );
        String result = decimalFormat.format( Double.valueOf( value ) );
        //      System.out.println(result);
        return result;
//
//            String value = "10.010"
//            String s = new DecimalFormat("0.####").format(Double.parseDouble(value));
//            System.out.println(s);

    }

    public static String convert12inchToFootLong(String itemName) throws Exception {
        try {
            if (itemName.contains( "12\"" ))
                return itemName.replace( "12\"", BreadSize.FOOTLONG.toString() );
            else
                return itemName;
        } catch (Exception ex) {
            Logz.step( "Unable to convert 12 inch to footlong.\\n" + ex.getMessage() );
            throw new Exception( ("Unable to convert 12 inch to footlong.\n" + ex.getMessage()) );
        }

    }

    public static String getConnectionString(String connection, String start, String end, int index) throws Exception {
        String value = connection.toString();
        int startPoint = value.indexOf( start ) + index;
        int endPoint = value.indexOf( end );
        return value.substring( startPoint, endPoint );
    }

    public static String getConnectionString(String connection, String start) throws Exception {
        String value = connection.toString();
        int startPoint = value.indexOf( start );
        return value.substring( startPoint );
    }

    public static String getConnectionString(String connection, int start, String end) throws Exception {
        String value = connection.toString();
        int endPoint = value.indexOf( end );
        return value.substring( start, endPoint );
    }

    public static String getConnectionString(String connection, String start, String end) throws Exception {
        String value = connection.toString();
        int startPoint = value.indexOf( start );
        int endPoint = value.indexOf( end );
        return value.substring( startPoint, endPoint );
    }

    public static String formatDateTime(String dt, String currentFormat, String newFormat) throws Exception {
        try {
            SimpleDateFormat oldFormat = new SimpleDateFormat( currentFormat );//"yyyy-MM-dd hh:mm:ss a"
            Date temDate = oldFormat.parse( dt );//"2017-05-03 05:35:03 PM"

            SimpleDateFormat formatter = new SimpleDateFormat( newFormat );//"MMM d, yyyy | h:m:a"
            Logz.step( "After date format: " + formatter.format( temDate ) );//May 3, 2017 | 5:35:PM
            return formatter.format( temDate );
        } catch (Exception ex) {
            Logz.step( "Unable to format date.\\n" + ex.getMessage() );
            throw new Exception( ("Unable to format date.\n" + ex.getMessage()) );
        }
    }

    public static boolean getTime(Store store) throws Exception {
        Boolean timePresent;
        String breakStartTime = store.getBreakStartTime();
        String breakEndTime = store.getBreakEndTime();
        Calendar currentDate = Calendar.getInstance();
        String split[] = currentDate.getTime().toString().split( " " );
        SimpleDateFormat parser = new SimpleDateFormat( "HH:mm:ss" );
        Date startTime = parser.parse( breakStartTime );
        Date endTime = parser.parse( breakEndTime );
        Date currentTime = parser.parse( split[3].toString() );
        Logz.step( "breakStartTime: " + startTime + " breakEndTime: " + endTime + " currentTime: " + currentTime );
        if (breakStartTime.contains( "00:00:00" ) || breakEndTime.contains( "00:00:00" )) {
            timePresent = true;
        } else if (currentTime.after( startTime ) && currentTime.before( endTime )) {
            timePresent = true;
        } else {
            timePresent = false;
        }

        return timePresent;
    }

    public static void setZipCode(Store store) throws Exception {
        String zipCode = store.getZipCode();
        if (zipCode.contains( "-" )) {
            zipCode = zipCode.split( "-" )[0];
            store.setZipCode( zipCode );
        }
        Logz.step( "ZipCode is: " + store.getZipCode() );
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = rand.nextInt( clazz.getEnumConstants().length );
        return clazz.getEnumConstants()[x];
    }

    public static String getRandomMenuName() throws Exception {
        List<String> menuNames = new ArrayList<>();
        menuNames.add( BaseTest.getStringfromBundleFile( "AllSandwiches" ) );
        menuNames.add( BaseTest.getStringfromBundleFile( "SUBWAYFreshFit" ) );
        menuNames.add( BaseTest.getStringfromBundleFile( "ChoppedSalads" ) );
        menuNames.add( BaseTest.getStringfromBundleFile( "KidsMeal" ) );
        Random random = new Random();
        int index = random.nextInt( menuNames.size() );
        return menuNames.get( index ).toString();
    }


    private static Date toNearestWholeHour(Date d) {
        Calendar c = new GregorianCalendar();
        c.setTime( d );

        if (c.get( Calendar.MINUTE ) >= 30)
            c.add( Calendar.HOUR, 1 );

        c.set( Calendar.MINUTE, 0 );
        c.set( Calendar.SECOND, 0 );

        return c.getTime();
    }

    public static String getBreakFastEndTimeRounded(Store store) throws Exception {
        SimpleDateFormat parser = new SimpleDateFormat( "HH:mm:ss" );
        Date endTime = parser.parse( store.getBreakEndTime() );
        Date breakEndTime = toNearestWholeHour( endTime );
        parser = new SimpleDateFormat( "H:mm a" );
        return parser.format( breakEndTime ).toString();
    }

    public static String getBreakFastStartTimeRounded(Store store) throws Exception {
        SimpleDateFormat parser = new SimpleDateFormat( "HH:mm:ss" );
        Date startTime = parser.parse( store.getBreakStartTime() );
        DateFormat df = new SimpleDateFormat( "h:'00' a" );
        return df.format( startTime ).toString();
        //return parser.format( startTime ).toString();
    }
    public static String getExpectedPrice(CustomizedItem customizedItem) throws Exception{
       return  "$" +String.format("%.2f", Double.valueOf( customizedItem.getCustomizedProductDetail().getPrice()));
    }

    public static String getExpectedCalories(CustomizedItem customizedItem) throws Exception{
        return  customizedItem.getCustomizedProductDetail().getCalories().trim()+" Cals*";
    }
}
