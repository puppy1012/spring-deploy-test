package com.example.springdeploytest.kakao_authentication.service;

import com.example.springdeploytest.kakao_authentication.controller.response.KakaoUserInfoResponse;

import java.util.Map;

public interface KakaoAuthenticationService {
    Map<String, Object> requestAccessToken(String code);
    KakaoUserInfoResponse requestUserInfo(String accessToken);

//    KakaoUserInfoResponse handleLogin(String code);
}
