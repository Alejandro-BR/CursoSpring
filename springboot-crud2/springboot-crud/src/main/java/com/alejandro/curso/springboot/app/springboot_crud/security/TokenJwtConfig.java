package com.alejandro.curso.springboot.app.springboot_crud.security;

import java.security.Key;

import io.jsonwebtoken.Jwts;

public class TokenJwtConfig {

    public static final Key SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
}
