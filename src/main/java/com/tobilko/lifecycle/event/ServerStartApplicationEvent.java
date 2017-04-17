package com.tobilko.lifecycle.event;

import org.springframework.context.ApplicationEvent;

public class ServerStartApplicationEvent extends ApplicationEvent {

    public ServerStartApplicationEvent(Object source) {
        super(source);
    }

}
