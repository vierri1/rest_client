package ru.innopolis.stc13.rest_client.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Response {
    private List<StopListItem> stopList;
    private Status status;

    public Response() {
    }

    public Response(List<StopListItem> stopList, Status status) {
        this.stopList = stopList;
        this.status = status;
    }

    public List<StopListItem> getStopList() {
        return stopList;
    }

    public void setStopList(List<StopListItem> stopList) {
        this.stopList = stopList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
