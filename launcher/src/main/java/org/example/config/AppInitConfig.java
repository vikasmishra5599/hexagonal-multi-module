package org.example.config;


import org.example.port.APIServicePort;
import org.example.port.DBServicePort;
import org.example.port.WebServicePort;
import org.example.service.HexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitConfig {

    private DBServicePort dbServicePort;
    private WebServicePort webServicePort;

    @Autowired
    public AppInitConfig(DBServicePort dbServicePort, WebServicePort webServicePort) {
        this.dbServicePort = dbServicePort;
        this.webServicePort = webServicePort;
    }

    @Bean
    public APIServicePort initAPIPortBean() {
        return new HexaService(dbServicePort, webServicePort);
    }
}
