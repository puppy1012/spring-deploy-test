package com.example.springdeploytest.controller;

import java.io.IOException;

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
    @GetMapping("/login")
    @Transactional
    public void requestLogin(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
        log.info("requestLogin(): code {}", code);
    }
}
