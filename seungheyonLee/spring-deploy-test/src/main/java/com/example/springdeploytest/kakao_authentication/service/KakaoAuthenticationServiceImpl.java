package com.example.springdeploytest.kakao_authentication.service;

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
}
