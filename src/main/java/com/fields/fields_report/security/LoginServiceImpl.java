package com.fields.fields_report.security;

import com.fields.fields_report.exceptions.WrongUserNamePasswordException;
import com.fields.fields_report.model.JwtRequest;
import com.fields.fields_report.model.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    public JwtResponse getToken(JwtRequest jwtRequest) throws Exception {
        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtil.createToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setJwtToken(token);
        return jwtResponse;
    }

    @Override
    public void authenticate(String userName, String password) throws Exception {
        System.out.println(userName);
        System.out.println(password);
        try {
            authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(userName, password)));
        } catch (InternalAuthenticationServiceException exc) {
            throw new WrongUserNamePasswordException();
        }
    }
}
