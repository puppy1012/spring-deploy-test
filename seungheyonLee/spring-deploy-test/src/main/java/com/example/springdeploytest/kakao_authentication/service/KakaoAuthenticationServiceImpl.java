package com.example.springdeploytest.kakao_authentication.service;

import com.example.springdeploytest.kakao_authentication.controller.response.KakaoUserInfoResponse;
import com.example.springdeploytest.kakao_authentication.repository.KakaoAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class KakaoAuthenticationServiceImpl implements KakaoAuthenticationService {
    final private KakaoAuthenticationRepository kakaoAuthenticationRepository;

    @Override
    public Map<String, Object> requestAccessToken(String code) {
        return this.kakaoAuthenticationRepository.getAccessToken(code);
    }

    @Override
    public KakaoUserInfoResponse requestUserInfo(String code) {
        // Step 1: 코드로 액세스 토큰 요청
        Map<String, Object> tokenResponse = requestAccessToken(code);
        String accessToken = (String) tokenResponse.get("access_token");

        // Step 2: 액세스 토큰으로 사용자 정보 요청
        Map<String, Object> userInfo = kakaoAuthenticationRepository.getUserInfo(accessToken);
        // Step 3: DTO로 포장해서 반환
        return KakaoUserInfoResponse.from(userInfo);
    }


}
