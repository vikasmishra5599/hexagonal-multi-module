package org.example.webclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenUniversity {
    private String country;
    private String alpha_two_code;
    private String name;
    @JsonProperty("state-province")
    private String stateprovince;
}
