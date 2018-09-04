package nebula.platform;

import nebula.config.JHipsterProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JHipsterProperties.class})
public class NebulaPlatformApplication {

    private static final Logger log = LoggerFactory.getLogger(NebulaPlatformApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(NebulaPlatformApplication.class, args);
        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }


}
