package com.example.springdeploytest.kakao_authentication.controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

//import com.example.springdeploytest.kakao_authentication.controller.response.KakaoUserInfoResponse;
import com.example.springdeploytest.kakao_authentication.controller.response.KakaoUserInfoResponseForm;
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
//    @GetMapping("/seungheyon/login")
//    @Transactional
//    public KakaoUserInfoResponseForm requestLogin(@RequestParam("code") String code) throws IOException {
//        log.info("requestLogin(): code {}", code);
//        KakaoUserInfoResponseForm response = kakaoAuthenticationService.requestUserInfo(code);
//        log.info("requestLogin(): userInfoResponse {}", response);
//        //redis를 사용해서 userToken을 발행해서 처리한다
//        String accessToken = response.getAccessToken();
//        String temporaryUserToken = createTemporaryUserToken(accessToken);
//        return userInfoResponse;
//    }
//
//    private String createUserTokenWithAccessToken(Account account, String accessToken) {
//        try {
//            String userToken = UUID.randomUUID().toString();
//            redisCacheService.setKeyAndValue(account.getId(), accessToken);
//            redisCacheService.setKeyAndValue(userToken, account.getId());
//            return userToken;
//        } catch (Exception e) {
//            throw new RuntimeException("Error storing token in Redis: " + e.getMessage());
//        }
//    }
}
