package com.example.demo.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class HelloWorldApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return HelloWorld.class;
    }

    @Override
    protected void init() {
        super.init();
        mountPage("/HelloWorld", HelloWorld.class);
    }
}
