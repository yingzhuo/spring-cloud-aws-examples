package examples.handler;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;

import java.io.InputStream;
import java.util.function.Function;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@RequiredArgsConstructor
public class MainHandler implements Function<InputStream, String> {

    private static final String OK = "OK";

    private final ApplicationContext applicationContext;

    @Override
    @SneakyThrows
    public String apply(InputStream inputStream) {
        log.info("ApplicationContext Type = {}", applicationContext.getClass().getName());
        log.info("Message = {}", IOUtils.toString(inputStream, UTF_8));
        return OK;
    }

}
