package id.nexteam.consulan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@ComponentScan(basePackages = {"id.nexteam"})
public class ConsulanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulanApplication.class, args);
    }

}
