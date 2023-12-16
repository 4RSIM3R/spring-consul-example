package id.nexteam.consulan.controller;

import id.nexteam.consulan.ConsulanApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${my.prop}")
    String value;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping()
    public String serviceDiscovery() {

        Optional<URI> uri = discoveryClient.getInstances("FirstApp")
                .stream()
                .findFirst()
                .map(ServiceInstance::getUri);

        return uri.isPresent() ? uri.get().toString() : "Kosong";
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/remote")
    public String getRemoteConfig() {
        return value;
    }

}
