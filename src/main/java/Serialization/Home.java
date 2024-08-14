package Serialization;

import java.io.Serializable;

public class Home implements Serializable {
    private String home;

    public Home() {
    }

    public Home(String home) {
        this.home = home;
    }

    public String getHome() {
        return home;
    }
}
