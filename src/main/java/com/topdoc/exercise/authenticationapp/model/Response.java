package com.topdoc.exercise.authenticationapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TAYYAB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private int statusCode;
    private String status;
    private String message;
}
