package se.dmitrykhalizov.webbshoplabb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.event.EventListener;
import se.dmitrykhalizov.webbshoplabb.service.EmailSenderService;

@SpringBootApplication
@ServletComponentScan
public class WebbshopLabbApplication {


    public static void main(String[] args) {

        SpringApplication.run(WebbshopLabbApplication.class, args);
    }

}
