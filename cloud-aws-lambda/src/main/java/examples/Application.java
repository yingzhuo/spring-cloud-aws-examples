package examples;

import examples.handler.MainHandler;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.function.Consumer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final var app = new SpringApplicationBuilder(Application.class);
        app.bannerMode(Banner.Mode.OFF);
        app.profiles("dev");
        app.run(args);
    }

    @Bean
    public Consumer<InputStream> mainHandler(final ApplicationContext applicationContext) {
        return new MainHandler(applicationContext);
    }

}
