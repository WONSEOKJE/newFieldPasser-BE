package com.example.newfieldpasser.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
예외 처리를 위해 설정해놓은 클래스
인증(Authentication)이 실패했을 때 실행
ex)ROLE_ADMIN 권한이 있는 사용자가 필요한 요청에 ROLE_USER 권한을 가진 사용자가 접근했을 때 실행
 */
@Slf4j
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setCharacterEncoding("utf-8");
        response.sendError(403, "권한이 없습니다.");
    }
}