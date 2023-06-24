package org.example.port;

import org.example.data.UniversityByState;
import java.util.List;

public interface WebServicePort {
    List<UniversityByState> getUniversities(String country);
}
