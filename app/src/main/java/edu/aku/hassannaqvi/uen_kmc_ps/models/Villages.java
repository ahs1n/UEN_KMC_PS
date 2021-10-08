package edu.aku.hassannaqvi.uen_kmc_ps.models;


import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_kmc_ps.contracts.TableContracts.TableVillage;


public class Villages {

    private static final String TAG = "Villages_CONTRACT";

    Long id;
    String ucname;
    String villagename;
    String villagecode;
    String uccode;
    String tehsilname;
    String tehsilcode;

    public Villages() {
        // Default Constructor
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUcname() {
        return ucname;
    }

    public void setUcname(String ucname) {
        this.ucname = ucname;
    }


    public String getVillagename() {
        return villagename;
    }

    public void setVillagename(String villagename) {
        this.villagename = villagename;
    }


    public String getVillagecode() {
        return villagecode;
    }

    public void setVillagecode(String villagecode) {
        this.villagecode = villagecode;
    }


    public String getUccode() {
        return uccode;
    }

    public void setUccode(String uccode) {
        this.uccode = uccode;
    }

    public String getTehsilname() {
        return tehsilname;
    }

    public void setTehsilname(String tehsilname) {
        this.tehsilname = tehsilname;
    }

    public String getTehsilcode() {
        return tehsilcode;
    }

    public void setTehsilcode(String tehsilcode) {
        this.tehsilcode = tehsilcode;
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();
        try {
            json.put(TableVillage._ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(TableVillage.COLUMN_UCNAME, this.ucname == null ? JSONObject.NULL : this.ucname);
            json.put(TableVillage.COLUMN_VILLAGE_NAME, this.villagename == null ? JSONObject.NULL : this.villagename);
            json.put(TableVillage.COLUMN_VILLAGE_CODE, this.villagecode == null ? JSONObject.NULL : this.villagecode);
            json.put(TableVillage.COLUMN_UC_CODE, this.villagecode == null ? JSONObject.NULL : this.villagecode);
            json.put(TableVillage.COLUMN_TEHSIL_NAME, this.tehsilname == null ? JSONObject.NULL : this.tehsilname);
            json.put(TableVillage.COLUMN_TEHSIL_CODE, this.tehsilcode == null ? JSONObject.NULL : this.tehsilcode);
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Villages Sync(JSONObject jsonObject) throws JSONException {
        this.ucname = jsonObject.getString(TableVillage.COLUMN_UCNAME);
        this.villagename = jsonObject.getString(TableVillage.COLUMN_VILLAGE_NAME);
        String seemVID = jsonObject.getString(TableVillage.COLUMN_VILLAGE_CODE);
        this.villagecode = seemVID.substring(seemVID.length() - 3);
        this.uccode = "0" + seemVID.charAt(0);
        this.tehsilname = jsonObject.getString(TableVillage.COLUMN_TEHSIL_NAME);
        this.tehsilcode = jsonObject.getString(TableVillage.COLUMN_TEHSIL_CODE);
        return this;
    }

    public Villages HydrateUc(Cursor cursor) {
        this.ucname = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_UCNAME));
        this.villagecode = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_VILLAGE_CODE));
        this.uccode = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_UC_CODE));
        this.tehsilcode = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_TEHSIL_CODE));
        return this;
    }

    public Villages HydrateVil(Cursor cursor) {
        this.villagename = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_VILLAGE_NAME));
        this.villagecode = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_VILLAGE_CODE));
        return this;
    }

    public Villages HydrateTeh(Cursor cursor) {
        this.tehsilname = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_TEHSIL_NAME));
        this.tehsilcode = cursor.getString(cursor.getColumnIndexOrThrow(TableVillage.COLUMN_TEHSIL_CODE));
        return this;
    }
}