package com.example.springdeploytest.kakao_authentication.controller;

import java.io.IOException;
import java.util.Map;

import com.example.springdeploytest.kakao_authentication.controller.response.KakaoUserInfoResponse;
import com.example.springdeploytest.kakao_authentication.service.KakaoAuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao-authentication")
public class BackendController {
    final private KakaoAuthenticationService kakaoAuthenticationService;
    /*
    [1] 프론트 → 카카오 로그인 요청
    [2] 사용자 인증 → Kakao가 Redirect URI + code 전달
    [3] 백엔드 → code로 Kakao에 Access Token 요청
    [4] Access Token으로 Kakao 사용자 정보 요청
     */
    @GetMapping("/login")
    @Transactional
    public KakaoUserInfoResponse requestLogin(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
        log.info("requestLogin(): code {}", code);
//        Map<String, Object> tokenResponse = kakaoAuthenticationService.requestAccessToken(code);
//        String accessToken = (String) tokenResponse.get("access_token");
//        log.info("requestLogin(): accessToken {}", accessToken);
//        Map<String, Object> userInfo = kakaoAuthenticationService.requestUserInfo(accessToken);
//        String nickname = (String) ((Map) userInfo.get("properties")).get("nickname");
//        String email = (String) ((Map) userInfo.get("kakao_account")).get("email");
//        log.info("nickname {}", nickname);
//        log.info("email: {}", email);
//        KakaoUserInfoResponse userInfoResponse = new KakaoUserInfoResponse(nickname, email);
        KakaoUserInfoResponse userInfoResponse=kakaoAuthenticationService.requestUserInfo(code);
        log.info("requestLogin(): userInfoResponse {}", userInfoResponse);
        return userInfoResponse;
    }

}
