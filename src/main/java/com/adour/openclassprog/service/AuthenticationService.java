package com.adour.openclassprog.service;

import com.adour.openclassprog.payload.req.AuthenticationRequest;
import com.adour.openclassprog.payload.req.RegisterRequest;
import com.adour.openclassprog.payload.res.AuthenticationResponse;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 10/06/2026 - 16:55
 */
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    // Add this line
    void updateProfileImage(Long userId, String fileName);
}
