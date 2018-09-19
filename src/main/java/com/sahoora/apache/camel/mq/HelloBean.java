package com.sahoora.apache.camel.mq;

import java.text.SimpleDateFormat;

/**
 * A bean which we use in the route
 */
public class HelloBean implements Hello {

    private String say = "Hello World";

    public String hello() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "{\"age\":100, \"name\":\"John\"}";
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }
}
