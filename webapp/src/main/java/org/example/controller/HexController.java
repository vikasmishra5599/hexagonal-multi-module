package org.example.controller;

import org.example.data.Person;
import org.example.port.APIServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HexController {

   private APIServicePort apiServicePort;

   @Autowired
    public HexController(APIServicePort apiServicePort) {
        this.apiServicePort = apiServicePort;
    }

    @GetMapping("/")
    public Person showInstitute() {
        return apiServicePort.getHelloMsg("vikas");
    }
}
