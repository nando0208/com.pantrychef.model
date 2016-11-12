package com.pantrychef.application;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 */
@ManagedResource
@Component
public class SickHealthIndicator extends AbstractHealthIndicator {

    private boolean shouldReportSick = false;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if(!shouldToReportSick()){
            builder.up();
        } else {
            builder.down();
        }
    }

    private boolean shouldToReportSick() {
        return this.shouldReportSick;
    }

    @ManagedOperation
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "sick", description = "Should report sick?")})
    public void startToReportSick(Boolean sick) {
        this.shouldReportSick = Boolean.TRUE.equals(sick);
    }
}
