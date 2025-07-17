package com.example.springdeploytest.kakao_authentication.repository;

import com.example.springdeploytest.kakao_authentication.controller.response.KakaoUserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Repository
public class KakaoAuthenticationRepositoryImpl implements KakaoAuthenticationRepository {
    // 카카오 로그인 요청 URL을 저장.
//    private final String loginUrl;
    // 클라이언트 ID를 저장.
    private final String clientId;
    // 리디렉션 URI를 저장.
    private final String redirectUri;
    // 토큰 요청 엔드포인트를 저장.
    private final String tokenRequestUri;
    // 사용자 정보 요청 엔드포인트를 저장.
    private final String userInfoRequestUri;

    // RestTemplate을 통한 HTTP 통신을 수행.
    private final RestTemplate restTemplate;

    public KakaoAuthenticationRepositoryImpl(
//            @Value("${kakao.login-url}") String loginUrl,
            @Value("${kakao.client-id}") String clientId,
            @Value("${kakao.redirect-uri}") String redirectUri,
            @Value("${kakao.token-request-uri}") String tokenRequestUri,
            @Value("${kakao.user-info-request-uri}") String userInfoRequestUri,
            RestTemplate restTemplate
    ) {
//        this.loginUrl = loginUrl;
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.tokenRequestUri = tokenRequestUri;
        this.userInfoRequestUri = userInfoRequestUri;
        this.restTemplate = restTemplate;
    }

    @Override
    public Map<String, Object> getAccessToken(String code) {
        // 요청 본문에 필요한 파라미터 설정.
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
        formData.add("client_id", clientId);
        formData.add("redirect_uri", redirectUri);
        formData.add("code", code);
        formData.add("client_secret", "");

        // 헤더에 콘텐츠 타입을 설정.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // HTTP 요청 엔티티 생성.
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);

        // POST 요청으로 토큰 정보를 조회.
        ResponseEntity<Map> response = restTemplate.exchange(
                tokenRequestUri, HttpMethod.POST, entity, Map.class
        );
        return response.getBody();
    }

    @Override
    public Map<String, Object> getUserInfo(String accessToken) {
        // 헤더에 Bearer 토큰을 설정.
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        // HTTP 요청 엔티티 생성.
        HttpEntity<String> entity = new HttpEntity<>(headers);
        // GET 요청으로 사용자 정보 조회.
        ResponseEntity<Map> response = restTemplate.exchange(
                userInfoRequestUri, HttpMethod.GET, entity, Map.class
        );
        // 조회된 사용자 정보를 로깅.
        log.info("User Info: {}", response.getBody());
        //        String nickname = (String) ((Map) userInfo.get("properties")).get("nickname");
//        String email = (String) ((Map) userInfo.get("kakao_account")).get("email");
        return response.getBody();
    }
    //    @Override
//    public Map<String, Object> getAccessToken(String code) {
//        // 요청 본문에 필요한 파라미터 설정.
//        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("grant_type", "authorization_code");
//        formData.add("client_id", clientId);
//        formData.add("redirect_uri", redirectUri);
//        formData.add("code", code);
//        formData.add("client_secret", "");
//
//        // 헤더에 콘텐츠 타입을 설정.
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        // HTTP 요청 엔티티 생성.
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);
//
//        // POST 요청으로 토큰 정보를 조회.
//        ResponseEntity<Map> response = restTemplate.exchange(
//                tokenRequestUri, HttpMethod.POST, entity, Map.class
//        );
//
//        return response.getBody();
//    }
}
