package com.pantrychef.application;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHook implements ApplicationListener<ContextClosedEvent> {

    private Logger logger = Logger.getLogger(ShutdownHook.class);

    @Override public void onApplicationEvent(ContextClosedEvent event) {

        logger.info("Stopping thread pools ...");

        LogManager.shutdown();
    }
}
