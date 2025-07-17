package com.example.springdeploytest.kakao_authentication.repository;

import com.example.springdeploytest.kakao_authentication.controller.response.KakaoUserInfoResponse;

import java.util.Map;

public interface KakaoAuthenticationRepository {

    Map<String,Object> getAccessToken(String code);
    Map<String,Object> getUserInfo(String accessToken);
}
