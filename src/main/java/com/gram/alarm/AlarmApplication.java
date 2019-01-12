package com.gram.alarm;

import com.gram.alarm.domain.Crawler;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlarmApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AlarmApplication.class, args);
    }

}

