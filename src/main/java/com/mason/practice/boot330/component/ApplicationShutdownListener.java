package com.mason.practice.boot330.component;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ApplicationShutdownListener {
    //Tomcat and Connection Pool will be closed after execution of this Listener.
    @EventListener
    @Order(999) // To be executed last, after all other Listeners(We can add more onContextClosed Listener to other components)
    public void onContextClosed(ContextClosedEvent event) {

        System.out.println("Received shutdown event:" + event);
        //Do whatever you want before shutdown
        System.out.println("Shutting down!!!");
    }
}
