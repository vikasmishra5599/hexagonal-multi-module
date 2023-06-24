package org.example.port;


import org.example.data.Person;

public interface DBServicePort {
    Person getPerson(String fname);
}
