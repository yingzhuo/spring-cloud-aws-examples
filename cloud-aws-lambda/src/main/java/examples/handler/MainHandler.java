package examples.handler;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@RequiredArgsConstructor
@Component
public class MainHandler implements java.util.function.Consumer<InputStream> {

    private final ApplicationContext applicationContext;

    @Override
    @SneakyThrows
    public void accept(InputStream inputStream) {
        log.info("ApplicationContext Type = {}", applicationContext.getClass().getName());
        log.info("message = {}", StreamUtils.copyToString(inputStream, UTF_8));
    }

}
