package com.gsheng.homeapi.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class ApplicationConfig {

    @PreDestroy
    public void onShutDown() {

    }
}
