package com.topdoc.exercise.authenticationapp.exception;

import com.topdoc.exercise.authenticationapp.model.Response;
import com.topdoc.exercise.authenticationapp.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * @author TAYYAB
 */
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<UserResponse> userException(UserException exception) {
        Response response = new Response(exception.getCode(), "FAILURE", exception.getMessage());
        UserResponse userResponse = new UserResponse(response, null);
        return new ResponseEntity<>(userResponse, HttpStatus.valueOf(exception.getCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<UserResponse> handleValidationExceptions(MethodArgumentNotValidException exception) {
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        String error = allErrors.stream().findFirst().get().getDefaultMessage();
        Response response = new Response(400, "FAILURE", error);
        UserResponse userResponse = new UserResponse(response, null);
        return new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<UserResponse> allException(Exception exception) {
        Response response = new Response(500, "FAILURE", exception.getMessage());
        UserResponse userResponse = new UserResponse(response, null);
        return new ResponseEntity<>(userResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}