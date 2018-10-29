package ru.innopolis.stc13.rest_client.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Request {
    private String fio;
    private String age;
    private String passport;

    public Request() {
    }

    public Request(String fio, String age, String passport) {
        this.fio = fio;
        this.age = age;
        this.passport = passport;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
