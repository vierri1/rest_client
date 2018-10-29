package ru.innopolis.stc13.rest_client.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StopListItem {
    private String id;
    private String data;
    private String period;

    public StopListItem() {
    }

    public StopListItem(String id, String data, String period) {
        this.id = id;
        this.data = data;
        this.period = period;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
