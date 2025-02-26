package com.topdoc.exercise.authenticationapp.services;

import com.topdoc.exercise.authenticationapp.exception.UserException;
import com.topdoc.exercise.authenticationapp.model.OTPResponse;
import com.topdoc.exercise.authenticationapp.model.UserOTPAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author TAYYAB
 */
@Service
public class UserAppOTPService {

    @Value("${twofactor-api.url}")
    private String apiBaseUrl;

    @Value("${twofactor-api.apikey}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    public OTPResponse generateOTP(String phone) throws UserException {
        String uri = apiBaseUrl + apiKey + "/SMS/" + phone + "/AUTOGEN";
        OTPResponse response = restTemplate.getForObject(uri, OTPResponse.class);
        if (response != null && "Error".equals(response.getStatus())) {
            throw new UserException(400, response.getDetails());
        }
        return response;
    }

    public boolean authenticateOTP(UserOTPAuth otpAuth) throws UserException {
        String uri = apiBaseUrl + apiKey + "/SMS/VERIFY/" + otpAuth.getOtpSessionId() + "/" + otpAuth.getOtpValue();
        OTPResponse response = restTemplate.getForObject(uri, OTPResponse.class);
        if (response != null && "Error".equals(response.getStatus())) {
            throw new UserException(400, response.getDetails());
        }
        if (response != null && "Success".equals(response.getStatus())
                && "OTP Matched".equals(response.getDetails())) {
            return true;
        }
        return false;
    }
}
