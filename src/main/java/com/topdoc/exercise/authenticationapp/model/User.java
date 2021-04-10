package com.topdoc.exercise.authenticationapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author TAYYAB
 */

@Data
@NoArgsConstructor
@Entity(name = "User")
public class User {
    @Id
    @NotBlank(message = "USERNAME IS MANDATORY")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "PASSWORD IS MANDATORY")
    private String password;
    @NotBlank(message = "NAME IS MANDATORY")
    private String name;
    @NotBlank(message = "MOBILE IS MANDATORY")
    private String mobile;
    //@NotBlank(message = "DATE OF BIRTH IS MANDATORY")
    private Date dob;
    private String address;

}
