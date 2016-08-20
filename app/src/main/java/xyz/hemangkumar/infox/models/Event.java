package xyz.hemangkumar.infox.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hemang on 19/08/16.
 */
public class Event {

    /**
     * event_id : 39
     * name : Competitive Code Sprint
     * image : img/index/events/sprint.jpg
     * about : Coming soon
     * rules : coming soon
     * miscdetails : None.
     * doclink : http://infoxpression.in/competitivesprint.php
     * tagline : EventLine
     * FIELD9 :
     * FIELD10 : null
     * FIELD11 : null
     * max : 5
     * FIELD13 :
     * FIELD14 :
     * FIELD15 :
     * FIELD16 :
     */

    private String event_id;
    private String name;
    private String image;
    private String about;
    private String rules;
    private String miscdetails;
    private String doclink;
    private String tagline;
    private String FIELD9;
    private Object FIELD10;
    private Object FIELD11;
    private String max;
    private String FIELD13;
    private String FIELD14;
    private String FIELD15;
    private String FIELD16;

    private static ArrayList<Event> data;



    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getMiscdetails() {
        return miscdetails;
    }

    public void setMiscdetails(String miscdetails) {
        this.miscdetails = miscdetails;
    }

    public String getDoclink() {
        return doclink;
    }

    public void setDoclink(String doclink) {
        this.doclink = doclink;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFIELD9() {
        return FIELD9;
    }

    public void setFIELD9(String FIELD9) {
        this.FIELD9 = FIELD9;
    }

    public Object getFIELD10() {
        return FIELD10;
    }

    public void setFIELD10(Object FIELD10) {
        this.FIELD10 = FIELD10;
    }

    public Object getFIELD11() {
        return FIELD11;
    }

    public void setFIELD11(Object FIELD11) {
        this.FIELD11 = FIELD11;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getFIELD13() {
        return FIELD13;
    }

    public void setFIELD13(String FIELD13) {
        this.FIELD13 = FIELD13;
    }

    public String getFIELD14() {
        return FIELD14;
    }

    public void setFIELD14(String FIELD14) {
        this.FIELD14 = FIELD14;
    }

    public String getFIELD15() {
        return FIELD15;
    }

    public void setFIELD15(String FIELD15) {
        this.FIELD15 = FIELD15;
    }

    public String getFIELD16() {
        return FIELD16;
    }

    public void setFIELD16(String FIELD16) {
        this.FIELD16 = FIELD16;
    }

    public static Event fromJson(JSONObject j) throws JSONException {
        Event event = new Event();

        event.setAbout(j.getString("about"));
        event.setDoclink(j.getString("doclink"));
        event.setEvent_id(j.getString("event_id"));
        event.setMax(j.getString("max"));
        event.setName(j.getString("name"));
        event.setRules(j.getString("rules"));
        return event;
    }

    public static ArrayList<Event> fromJson(JSONArray j, ArrayList<Event> eventList ) throws JSONException {
        ArrayList<Event> events = new ArrayList<>();
        JSONObject jo = null;

        for (int i= 0; i< j.length(); i++){
            try {
                jo = j.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Event event = Event.fromJson(jo);
            if(event != null){
                eventList.add(event);
            }

        }
        return eventList;
    }

    public static ArrayList<Event> getData() {
        return data;
    }

    public static void setData(ArrayList<Event> dat) {
        data = dat;
    }
}
