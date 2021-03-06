package edu.aku.hassannaqvi.uen_kmc_ps.models;

import android.database.Cursor;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uen_kmc_ps.BR;
import edu.aku.hassannaqvi.uen_kmc_ps.contracts.TableContracts.HouseholdTable;
import edu.aku.hassannaqvi.uen_kmc_ps.core.MainApp;

public class Households extends BaseObservable implements Observable {

    private final String TAG = "Households";
    private String round = "";
    private String ra01 = "";
    private String ra01v2 = "";
    private String ra01v3 = "";
    private String ra02 = "";
//    private String ra04 = "";
    private String ra03 = "";
    //    private String ra05 = "";
    private String ra07 = "";
    private String ra06 = "";
    private String ra08 = "";
    private String ra09 = "";
    private String ra10 = "";
    private String ra11 = "";
    private String ra11x = "";
    private String ra12 = "";
    private String ra12x = "";
    private String ra13 = "";
    private String ra13x = "";
    private String ra14 = "";
    private String ra15 = "";
    private String ra16 = "";
    private String ra17_a1 = "";
    private String ra17_b1 = "";
    private String ra17_c1 = "";
    private String ra17_d1 = "";
    private String ra17_a2 = "";
    private String ra17_b2 = "";
    private String ra17_c2 = "";
    private String ra17_d2 = "";
    private String ra18 = "";
    private String ra19 = "";
    private String ra20 = "";
    private String ra21 = "";
    private String ra22 = "";

    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    private boolean exist = false;
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String hdssId = StringUtils.EMPTY;
    private String ucCode = StringUtils.EMPTY;
    private String villageCode = StringUtils.EMPTY;
    private String hhNo = StringUtils.EMPTY;
    private String structureNo = StringUtils.EMPTY;
    private String visitNo = "0";


    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;

    // SECTION VARIABLES
    private String sA = StringUtils.EMPTY;


    public Households() {

        setRound(MainApp.round);
        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());
        setAppver(MainApp.appInfo.getAppVersion());
        setRa06(MainApp.selectedUC);
        setRa07(MainApp.selectedVillage);
//        setRa04(MainApp.leaderCode);
//        setRa05(MainApp.leaderCode);

    }

    public Households(Households households) {

        setUserName(households.getUserName());
        setDeviceId(households.getDeviceId());
        setAppver(households.getAppver());
        setRa06(households.getRa06());
        setRa07(households.getRa07());
        setRa08(households.getRa08());
        setRa10(households.getRa10());
        setRound(households.getRound());

    }


/*
    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }*/

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

/*    public PropertyChangeRegistry getPropertyChangeRegistry() {
        return propertyChangeRegistry;
    }

    public void setPropertyChangeRegistry(PropertyChangeRegistry propertyChangeRegistry) {
        this.propertyChangeRegistry = propertyChangeRegistry;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }


    public String getUcCode() {
        return ucCode;
    }

    public void setUcCode(String ucCode) {

        this.ucCode = ucCode;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getHhNo() {
        return hhNo;
    }

    public void setHhNo(String hhNo) {
        this.hhNo = hhNo;
        setHdssId(getUcCode() + "-" + getVillageCode() + "-" + getHhNo());
    }

    public String getStructureNo() {
        return structureNo;
    }

    public void setStructureNo(String structureNo) {
        this.structureNo = structureNo;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public void resetHousehold() {
        setRa01("");
        setRa09("");
        setRa11("");
        setRa12("");
        setRa13("");
        setRa11x("");
        setRa12x("");
        setRa13x("");
        setRa14("");
        setRa15("");
        setRa16("");
        setRa17_a1("");
        setRa17_b1("");
        setRa17_c1("");
        setRa17_d1("");
        setRa17_a2("");
        setRa17_b2("");
        setRa17_c2("");
        setRa17_d2("");
        setRa18("");
        setRa19("");
        setRa20("");
        setsA("");
    }


    @Bindable
    public String getRa01() {
        return ra01;
    }

    public void setRa01(String ra01) {
        this.ra01 = ra01;
        notifyChange(BR.ra01);
    }

    @Bindable
    public String getRa01v2() {
        return ra01v2;
    }

    public void setRa01v2(String ra01v2) {
        this.ra01v2 = ra01v2;
        notifyChange(BR.ra01v2);
    }

    @Bindable
    public String getRa01v3() {
        return ra01v3;
    }

    public void setRa01v3(String ra01v3) {
        this.ra01v3 = ra01v3;
        notifyChange(BR.ra01v3);
    }


    @Bindable
    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
        notifyPropertyChanged(BR.round);
    }

    @Bindable
    public String getRa02() {
        return ra02;
    }

    public void setRa02(String ra02) {
        this.ra02 = ra02;
        notifyChange(BR.ra02);
    }

/*    @Bindable
    public String getRa04() {
        return ra04;
    }

    public void setRa04(String ra04) {
        this.ra04 = ra04;
        notifyChange(BR.ra04);
    }*/

    @Bindable
    public String getRa03() {
        return ra03;
    }

    public void setRa03(String ra03) {
        this.ra03 = ra03;
        notifyChange(BR.ra03);
    }

/*    @Bindable
    public String getRa05() {
        return ra05;
    }

    public void setRa05(String ra05) {
        this.ra05 = ra05;
        notifyChange(BR.ra05);
    }*/

    @Bindable
    public String getRa07() {
        return ra07;
    }

    public void setRa07(String ra07) {
        this.ra07 = ra07;
        setVillageCode(this.ra07);
        notifyChange(BR.ra07);
    }

    @Bindable
    public String getRa06() {
        return ra06;
    }

    public void setRa06(String ra06) {
        this.ra06 = String.format("%02d", Integer.parseInt(ra06));
        setUcCode(this.ra06);
        notifyChange(BR.ra06);
    }

    @Bindable
    public String getRa08() {
        return ra08;
    }

    public void setRa08(String ra08) {
        this.ra08 = ra08;

        notifyChange(BR.ra08);
    }

    @Bindable
    public String getRa09() {
        return ra09;
    }

    public void setRa09(String ra09) {
        this.ra09 = String.format("%03d", Integer.parseInt(ra09));
        setHhNo(this.ra09);
        notifyChange(BR.ra09);
    }

    @Bindable
    public String getRa10() {
        return ra10;
    }

    public void setRa10(String ra10) {
        this.ra10 = ra10;
        this.structureNo = ra10;
        notifyChange(BR.ra10);
    }

    @Bindable
    public String getRa11() {
        return ra11;
    }

    public void setRa11(String ra11) {
        this.ra11 = ra11;
        setiStatus(ra11);
        notifyChange(BR.ra11);
    }

    @Bindable
    public String getRa11x() {
        return ra11x;
    }

    public void setRa11x(String ra11x) {
        this.ra11x = ra11x;
        notifyChange(BR.ra11x);
    }

    @Bindable
    public String getRa12() {
        return ra12;
    }

    public void setRa12(String ra12) {
        this.ra12 = ra12;
        setiStatus(ra12);
        notifyChange(BR.ra12);
    }

    @Bindable
    public String getRa12x() {
        return ra12x;
    }

    public void setRa12x(String ra12x) {
        this.ra12x = ra12x;
        notifyChange(BR.ra12x);
    }

    @Bindable
    public String getRa13() {
        return ra13;
    }

    public void setRa13(String ra13) {
        this.ra13 = ra13;
        setiStatus(ra13);
        notifyChange(BR.ra13);
    }

    @Bindable
    public String getRa13x() {
        return ra13x;
    }

    public void setRa13x(String ra13x) {
        this.ra13x = ra13x;
        notifyChange(BR.ra13x);
    }


    @Bindable
    public String getRa14() {
        return ra14;
    }

    public void setRa14(String ra14) {
        this.ra14 = ra14;
        notifyChange(BR.ra14);
    }

    @Bindable
    public String getRa15() {
        return ra15;
    }

    public void setRa15(String ra15) {
        this.ra15 = ra15;
        notifyChange(BR.ra15);
    }

    @Bindable
    public String getRa16() {
        return ra16;
    }

    public void setRa16(String ra16) {
        this.ra16 = ra16;
        notifyChange(BR.ra16);
    }

    @Bindable
    public String getRa17_a1() {
        return ra17_a1;
    }

    public void setRa17_a1(String ra17_a1) {
        this.ra17_a1 = ra17_a1;
        notifyChange(BR.ra17_a1);
    }

    @Bindable
    public String getRa17_b1() {
        return ra17_b1;
    }

    public void setRa17_b1(String ra17_b1) {
        this.ra17_b1 = ra17_b1;
        notifyChange(BR.ra17_b1);
    }

    @Bindable
    public String getRa17_c1() {
        return ra17_c1;
    }

    public void setRa17_c1(String ra17_c1) {
        this.ra17_c1 = ra17_c1;
        notifyChange(BR.ra17_c1);
    }

    @Bindable
    public String getRa17_d1() {
        return ra17_d1;
    }

    public void setRa17_d1(String ra17_d1) {
        this.ra17_d1 = ra17_d1;
        notifyChange(BR.ra17_d1);
    }

    @Bindable
    public String getRa17_a2() {
        return ra17_a2;
    }

    public void setRa17_a2(String ra17_a2) {
        this.ra17_a2 = ra17_a2;
        notifyChange(BR.ra17_a2);
    }

    @Bindable
    public String getRa17_b2() {
        return ra17_b2;
    }

    public void setRa17_b2(String ra17_b2) {
        this.ra17_b2 = ra17_b2;
        notifyChange(BR.ra17_b2);
    }

    @Bindable
    public String getRa17_c2() {
        return ra17_c2;
    }

    public void setRa17_c2(String ra17_c2) {
        this.ra17_c2 = ra17_c2;
//        setRa18(this.ra17_c2);
        notifyChange(BR.ra17_c2);
    }

    @Bindable
    public String getRa17_d2() {
        return ra17_d2;
    }

    public void setRa17_d2(String ra17_d2) {
        this.ra17_d2 = ra17_d2;
        notifyChange(BR.ra17_d2);
    }

    @Bindable
    public String getRa18() {
        return ra18;
    }

    public void setRa18(String ra18) {
        this.ra18 = ra18;
        notifyChange(BR.ra18);
    }

    @Bindable
    public String getRa19() {
        return ra19;
    }

    public void setRa19(String ra19) {
        this.ra19 = ra19;
        notifyChange(BR.ra19);
    }

    @Bindable
    public String getRa20() {
        return ra20;
    }

    public void setRa20(String ra20) {
        this.ra20 = ra20;
        if (!this.ra20.equals("1")) {
            setRa17_a1("");
            setRa17_a2("");
            setRa17_b1("");
            setRa17_b2("");
            setRa17_c1("");
            setRa17_c2("");
            setRa17_d1("");
            setRa17_d2("");

        }
        notifyChange(BR.ra20);
    }

    @Bindable
    public String getRa21() {
        return ra21;
    }

    public void setRa21(String ra21) {
        this.ra21 = ra21;
        notifyChange(BR.ra21);
    }

    @Bindable
    public String getRa22() {
        return ra22;
    }

    public void setRa22(String ra22) {
        this.ra22 = ra22;
        notifyChange(BR.ra22);
    }

    @Bindable
    public String getHdssId() {
        return hdssId;
    }

    public void setHdssId(String hdssId) {
        this.hdssId = hdssId;
        setRa22(hdssId);
        //notifyChange(BR.ra22);
    }


    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }

    public Households Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_SYSDATE));
        this.hdssId = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_HDSSID));
        this.ucCode = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_UC_CODE));
        this.villageCode = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_VILLAGE_CODE));
        this.hhNo = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_HOUSEHOLD_NO));
        this.structureNo = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_STRUCTURE_NO));
        this.visitNo = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_VISIT_NO));

        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(HouseholdTable.COLUMN_SA)));


        return this;
    }

    public void s1Hydrate(String string) throws JSONException {

        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
            this.round = json.getString("round");
            this.ra01 = json.getString("ra01");
            this.ra01v2 = json.getString("ra01v2");
            this.ra01v3 = json.getString("ra01v3");
            this.ra02 = json.getString("ra02");
//            this.ra04 = json.getString("ra04");
            this.ra03 = json.getString("ra03");
//            this.ra05 = json.getString("ra05");
            this.ra07 = json.getString("ra07");
            this.ra06 = json.getString("ra06");
            this.ra08 = json.getString("ra08");
            this.ra09 = json.getString("ra09");
            this.ra10 = json.getString("ra10");
            this.ra11 = json.getString("ra11");
            this.ra11x = json.getString("ra11x");
            this.ra12 = json.getString("ra12");
            this.ra12x = json.getString("ra12x");
            this.ra13 = json.getString("ra13");
            this.ra13x = json.getString("ra13x");
            this.ra14 = json.getString("ra14");
            this.ra15 = json.getString("ra15");
            this.ra16 = json.getString("ra16");
            this.ra17_a1 = json.getString("ra17_a1");
            this.ra17_b1 = json.getString("ra17_b1");
            this.ra17_c1 = json.getString("ra17_c1");
            this.ra17_d1 = json.getString("ra17_d1");
            this.ra17_a2 = json.getString("ra17_a2");
            this.ra17_b2 = json.getString("ra17_b2");
            this.ra17_c2 = json.getString("ra17_c2");
            this.ra17_d2 = json.getString("ra17_d2");
            this.ra18 = json.getString("ra18");
            this.ra19 = json.getString("ra19");
            this.ra20 = json.getString("ra20");
            this.ra21 = json.getString("ra21");
            this.ra22 = json.getString("ra22");


        }
    }


    public String sAtoString() throws JSONException {
        JSONObject json = new JSONObject();

        json.put("ra01", ra01)
                .put("ra01v3", ra01v3)
                .put("ra01v2", ra01v2)
                .put("round", round)
                .put("ra02", ra02)
//                .put("ra04", ra04)
                .put("ra03", ra03)
//                .put("ra05", ra05)
                .put("ra07", ra07)
                .put("ra06", ra06)
                .put("ra08", ra08)
                .put("ra09", ra09)
                .put("ra10", ra10)
                .put("ra11", ra11)
                .put("ra11x", ra11x)
                .put("ra12", ra12)
                .put("ra12x", ra12x)
                .put("ra13", ra13)
                .put("ra13x", ra13x)
                .put("ra14", ra14)
                .put("ra15", ra15)
                .put("ra16", ra16)
                .put("ra17_a1", ra17_a1)
                .put("ra17_b1", ra17_b1)
                .put("ra17_c1", ra17_c1)
                .put("ra17_d1", ra17_d1)
                .put("ra17_a2", ra17_a2)
                .put("ra17_b2", ra17_b2)
                .put("ra17_c2", ra17_c2)
                .put("ra17_d2", ra17_d2)
                .put("ra18", ra18)
                .put("ra19", ra19)
                .put("ra20", ra20)
                .put("ra21", ra21)
                .put("ra22", ra22);

        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();


        json.put(HouseholdTable.COLUMN_ID, this.id);
        json.put(HouseholdTable.COLUMN_PROJECT_NAME, this.projectName);
        json.put(HouseholdTable.COLUMN_UID, this.uid);
        json.put(HouseholdTable.COLUMN_USERNAME, this.userName);
        json.put(HouseholdTable.COLUMN_SYSDATE, this.sysDate);
        json.put(HouseholdTable.COLUMN_HDSSID, this.hdssId);
        json.put(HouseholdTable.COLUMN_UC_CODE, this.ucCode);
        json.put(HouseholdTable.COLUMN_VILLAGE_CODE, this.villageCode);
        json.put(HouseholdTable.COLUMN_HOUSEHOLD_NO, this.hhNo);
        json.put(HouseholdTable.COLUMN_STRUCTURE_NO, this.structureNo);
        json.put(HouseholdTable.COLUMN_VISIT_NO, this.visitNo);
        json.put(HouseholdTable.COLUMN_DEVICEID, this.deviceId);
        json.put(HouseholdTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(HouseholdTable.COLUMN_ISTATUS, this.iStatus);
        json.put(HouseholdTable.COLUMN_APPVERSION, this.appver);
        //  json.put(HouseholdTable.COLUMN_SYNCED, this.synced);
        //  json.put(HouseholdTable.COLUMN_SYNCED_DATE, this.syncDate);

        json.put(HouseholdTable.COLUMN_SA, new JSONObject(sAtoString()));
        //Log.d(TAG, "toJSONObject: "+new JSONObject(s2toString()));


        return json;

    }


}
