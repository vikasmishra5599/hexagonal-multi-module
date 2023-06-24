package org.example.service;


import org.example.data.Person;
import org.example.data.UniversityByState;
import org.example.port.APIServicePort;
import org.example.port.DBServicePort;
import org.example.port.WebServicePort;

import java.util.List;

public class HexaService implements APIServicePort {

    private DBServicePort hexDao;
    private WebServicePort hexWebClient;

    public HexaService(DBServicePort hexDao, WebServicePort hexWebClient) {
        this.hexDao = hexDao;
        this.hexWebClient = hexWebClient;
    }

    public Person getHelloMsg(String fname) {

        Person p = getPerson(fname);

     List<UniversityByState> universities = getUniversities("india");

        return Person.builder()
                .fname(fname)
                .lname(p.getLname())
                .age(p.getAge())
                .country(p.getCountry())
                .universityByState(universities)
                .build();


    }

    //making web call to external API
    private List<UniversityByState> getUniversities(String country) {
        List<UniversityByState> universities = hexWebClient.getUniversities(country);
        return universities;
    }


    //making call to DB
    private Person getPerson(String fname) {
        return hexDao.getPerson(fname);

    }


}
