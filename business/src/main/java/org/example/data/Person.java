package org.example.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String fname;
    private String lname;
    private int age;
    private String country;
    private List<UniversityByState> universityByState;
}
