package com.topdoc.exercise.authenticationapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TAYYAB
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTPResponse {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("Details")
    private String details;
}
