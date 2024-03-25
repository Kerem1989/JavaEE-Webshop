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

    @Autowired
    private EmailSenderService senderService;


    public static void main(String[] args) {

        SpringApplication.run(WebbshopLabbApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
		senderService.sendEmail("kerem.tazedal89@gmail.com",
                				"Hello from Kerem Dmitry Webbshop Labb!",
								"This is a test email from Spring Boot as part of the Webbshop Labb project.");
	}
}
