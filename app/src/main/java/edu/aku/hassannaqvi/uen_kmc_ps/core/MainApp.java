package edu.aku.hassannaqvi.uen_kmc_ps.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import net.sqlcipher.database.SQLiteDatabase;

import org.json.JSONArray;

import java.io.File;
import java.util.List;

import edu.aku.hassannaqvi.uen_kmc_ps.BuildConfig;
import edu.aku.hassannaqvi.uen_kmc_ps.R;
import edu.aku.hassannaqvi.uen_kmc_ps.models.Households;
import edu.aku.hassannaqvi.uen_kmc_ps.models.MWRA;
import edu.aku.hassannaqvi.uen_kmc_ps.models.Users;


public class MainApp extends Application {

    public static final String PROJECT_NAME = "UEN KMC PS";
    public static final String DIST_ID = null;
    public static final String SYNC_LOGIN = "sync_login";
    //    public static final String _IP = "https://pedres2.aku.edu/";// .LIVE server
    public static final String _IP = "https://vcoe1.aku.edu";// .LIVE server
    // public static final String _IP = "http://cls-pae-fp51764";// .TEST server

    public static final String _HOST_URL = MainApp._IP + "/uen_kmc_ps/api/";// .TEST server;
    public static final String _SERVER_URL = "syncenc.php";
    public static final String _SERVER_GET_URL = "getDataenc.php";
    public static final String _PHOTO_UPLOAD_URL = _HOST_URL + "uploads.php";
    public static final String _UPDATE_URL = MainApp._IP + "/uen_kmc_ps/app/";

    public static final Integer MONTHS_LIMIT = 11;
    public static final Integer DAYS_LIMIT = 29;
    private static final String TAG = "MainApp";
    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
    private static final int TWENTY_MINUTES = 1000 * 60 * 20;
    private static final int TWO_MINUTES = 1000 * 60 * 2;
    private static final long MILLIS_IN_SECOND = 1000;
    private static final long SECONDS_IN_MINUTE = 60;
    private static final long MINUTES_IN_HOUR = 60;
    private static final long HOURS_IN_DAY = 24;
    public static final long MILLISECONDS_IN_DAY = MILLIS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY;
    public static String IBAHC = "";
    public static File sdDir;
    public static String[] downloadData;
    public static Households households;
    public static MWRA mwra;
    public static String DeviceURL = "devices.php";
    public static AppInfo appInfo;
    public static Users user;
    public static Boolean admin = false;
    public static List<JSONArray> uploadData;
    public static SharedPreferences.Editor editor;
    public static SharedPreferences sharedPref;
    public static String deviceid;
    public static int versionCode = BuildConfig.VERSION_CODE;
    public static String versionName = BuildConfig.VERSION_NAME;
    public static int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 2;
    //    public static long TWO_MINUTES = 1000 * 60 * 2;
    public static boolean permissionCheck = false;
    public static int idType = 0;
    public static String round = "0";

    public static List<MWRA> mwraList;
    public static String hdssid;
    public static int mwraCount = 0;
    public static boolean fmComplete;
    public static int selectedFemale;
    public static int selectedHousehold;
    public static int mwraCountComplete = 0;
    public static List<Households> householdList;
    public static int householdCount = 0;
    public static int householdCountComplete = 0;
    public static String previousAddress = "";
    public static String dateOfVisit = "";
    public static String selectedVillage = "0000";
    public static String leaderCode;
    public static String selectedUC = "00";

    public static void hideSystemUI(View decorView) {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public static String getDeviceId(Context context) {
        String deviceId;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            deviceId = Settings.Secure.getString(
                    context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        } else {
           /* final TelephonyManager mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (mTelephony.getDeviceId() != null) {
                deviceId = mTelephony.getDeviceId();
            } else {
                deviceId = Settings.Secure.getString(
                        context.getContentResolver(),
                        Settings.Secure.ANDROID_ID);
            }*/
        }
        return "deviceId";
    }


    @Override
    public void onCreate() {
        super.onCreate();
/*        RootBeer rootBeer = new RootBeer(this);
        if (rootBeer.isRooted()) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }*/
        //Initiate DateTime
        //Initializ App info
        appInfo = new AppInfo(this);
        sharedPref = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPref.edit();
        MainApp.editor
                .putString("mh01", "")
                .apply();
        deviceid = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        initSecure();
    }

    private void initSecure() {
        // Initialize SQLCipher library
        SQLiteDatabase.loadLibs(this);

        // Prepare encryption KEY
        ApplicationInfo ai = null;
        try {
            ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            int TRATS = bundle.getInt("YEK_TRATS");
            IBAHC = bundle.getString("YEK_REVRES").substring(TRATS, TRATS + 16);
            Log.d(TAG, "onCreate: YEK_REVRES = " + IBAHC);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
