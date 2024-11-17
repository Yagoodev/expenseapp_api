package com.exapanse_tracker.ExapanseTrackerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExapanseTrackerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExapanseTrackerAppApplication.class, args);
    }

}
