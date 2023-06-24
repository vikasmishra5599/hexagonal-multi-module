package org.example.db;

import org.example.data.Person;
import org.example.port.DBServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class HexDao implements DBServicePort {

    private HexRepository hexRepository;

    @Autowired
    public HexDao(HexRepository hexRepository) {
        this.hexRepository = hexRepository;
    }

    @Override
    public Person getPerson(String fname) {
        List<org.example.db.entity.Person> persons = hexRepository.getPersonByName(fname);
        if(isEmpty(persons)) {
            return null;
        }

        org.example.db.entity.Person entity = persons.get(0);
        return Person.builder()
                .fname(entity.getName())
                .lname(entity.getLname())
                .age(entity.getAge())
                .country(entity.getCountry())
                .build();
    }
}
