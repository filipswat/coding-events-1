package org.launchcode.codingevents.classes;

public class Event {
    private static String currentEventID = "000001";
    private final String eventID;
    private String name;
    private String desc;
    private String pictureURL;

    public Event(String name) {
        this.name=name;

        //automatically initializes eventID and advances counter
        this.eventID = currentEventID;
        currentEventID = Integer.toString(Integer.parseInt(currentEventID) + 1);
        while (currentEventID.length() < 6) {
            currentEventID = "0" + currentEventID;
        }
    }

    public Event(String name, String desc) {
        this(name);
        this.desc=desc;
    }

    public Event(String name, String desc, String pictureURL) {
        this(name, desc);
        this.pictureURL=pictureURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return eventID.equals(event.eventID);
    }

    @Override
    public int hashCode() {
        return eventID.hashCode();
    }
}
