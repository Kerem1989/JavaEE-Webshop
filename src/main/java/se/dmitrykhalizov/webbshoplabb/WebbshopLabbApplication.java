package se.dmitrykhalizov.webbshoplabb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WebbshopLabbApplication {


    public static void main(String[] args) {

        SpringApplication.run(WebbshopLabbApplication.class, args);
    }

}
