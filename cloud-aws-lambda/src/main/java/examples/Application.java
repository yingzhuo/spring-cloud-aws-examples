package examples;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final var app = new SpringApplicationBuilder(Application.class);
        app.run(args);
    }

}
