package com.example.springdeploytest.kakao_authentication.controller.response;

import java.util.Map;

public class KakaoUserInfoResponse {
    private String nickname;
    private String email;
    public KakaoUserInfoResponse() {}
    public KakaoUserInfoResponse(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }
    public static KakaoUserInfoResponse from(Map<String, Object> userInfo) {
        Map<String, Object> properties = cast(userInfo.get("properties"));
        Map<String, Object> kakaoAccount = cast(userInfo.get("kakao_account"));

        String nickname = (String) properties.get("nickname");
        String email = (String) kakaoAccount.get("email");

        return new KakaoUserInfoResponse(nickname, email);
    }
    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}
