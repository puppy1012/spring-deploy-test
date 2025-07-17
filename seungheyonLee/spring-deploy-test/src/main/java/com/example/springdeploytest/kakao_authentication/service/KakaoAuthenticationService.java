package com.example.springdeploytest.kakao_authentication.service;

import java.util.Map;

public interface KakaoAuthenticationService {
    Map<String, Object> requestAccessToken(String code);

}
