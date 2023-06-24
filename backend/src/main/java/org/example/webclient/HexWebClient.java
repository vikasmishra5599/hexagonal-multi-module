package org.example.webclient;

import org.example.data.UniversityByState;
import org.example.port.WebServicePort;
import org.example.webclient.entity.OpenUniversity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HexWebClient implements WebServicePort {

    public List<UniversityByState> getUniversities(String country) {
        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = "http://universities.hipolabs.com/search?country=" + country;
        try {
            OpenUniversity[] response
                    = restTemplate.getForEntity(fooResourceUrl, OpenUniversity[].class).getBody();

            List<UniversityByState> u = Arrays.asList(response).stream()
                    .map(s -> UniversityByState.builder()
                            .name(s.getName())
                            .stateprovince(s.getStateprovince())
                            .build())
                    .collect(Collectors.toList());
            return u;

        } catch (Exception e) {
            return null;
        }

    }

}
