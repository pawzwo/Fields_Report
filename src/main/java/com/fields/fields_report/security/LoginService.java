package com.fields.fields_report.security;

import com.fields.fields_report.model.JwtRequest;
import com.fields.fields_report.model.JwtResponse;

public interface LoginService {

    JwtResponse getToken(JwtRequest jwtRequest) throws Exception;

    void authenticate(String userName, String password) throws Exception;

}
