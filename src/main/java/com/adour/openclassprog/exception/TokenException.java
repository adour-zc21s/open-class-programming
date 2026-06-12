package com.adour.openclassprog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 10/06/2026 - 17:15
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenException extends RuntimeException{
    public TokenException(String token, String message) {
        super(String.format("Failed for [%s]: %s", token, message));
    }
}
