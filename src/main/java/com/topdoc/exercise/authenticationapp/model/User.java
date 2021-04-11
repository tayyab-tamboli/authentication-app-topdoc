package com.topdoc.exercise.authenticationapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author TAYYAB
 */

@Data
@NoArgsConstructor
@Entity(name = "User")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @Past(message = "DATE OF BIRTH SHOULD BE FROM PAST")
    @NotNull(message = "DATE OF BIRTH IS MANDATORY")
    private Date dob;
    private String address;
    private boolean active;
    @Transient
    private String otpSessionId;

}
